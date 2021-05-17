package com.example.comercio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.comercio.models.Comercios;
import com.example.comercio.repository.ComercioRepository;
import com.example.comercio.service.ComerciosService;



@Controller
public class ComercioController {

	
	private final ComercioRepository comercioRepository;
	@Autowired
    private ComerciosService comerciosService;
	@Autowired
	public ComercioController(ComercioRepository comercioRepository) {
		this.comercioRepository=comercioRepository;
	}
	
	
	// display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listComercio", comerciosService.getAllComercios());
        return "index";
    }
    
    
    @GetMapping("/showNewComercioForm")
    public String showNewComercioForm(Model model) {
        // create model attribute to bind form data
        Comercios comercios = new Comercios();
        model.addAttribute("comercios", comercios);
        return "add-comercios";
    }
    
	
	 @PostMapping("/addcomercio")
	 public String addComercio (@Valid Comercios comercios, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	return "add-comercios";
	        }
	        comercioRepository.save(comercios);
	        return "redirect:/";
	 }
	 
	 @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
		 	Comercios comercios = comercioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        model.addAttribute("comercios", comercios);
	        
	        return "update-comercios";
	    }
	    

	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Comercios comercios = comerciosService.getComerciosById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("comercios", comercios);
	        return "update_comercios";
	    }
	 
	 @PostMapping("/saveCormercios")
	    public String saveCormercios(@ModelAttribute("comercios") Comercios comercios) {
	        // save employee to database
	        comerciosService.saveComercio(comercios);
	        return "redirect:/";
	    }
	 
	 
	 @GetMapping("/deleteComercio/{id}")
	 public String deleteComercio(@PathVariable (value = "id") long id) {
	  
	  // call delete employee method 
	  this.comerciosService.deleteComercioById(id);
	  return "redirect:/";
	 }
	 
	 
}
