package com.example.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.comercio.models.Comercios;
import com.example.comercio.repository.ComercioRepository;
import java.util.Optional;
@Service
public class ComerciosServiceImpl implements ComerciosService {

	@Autowired
    private ComercioRepository comercioRepository;

	@Override
	public List<Comercios> getAllComercios() {
		// TODO Auto-generated method stub
		return comercioRepository.findAll();
	}

	@Override
	public void saveComercio(Comercios comercios) {
		// TODO Auto-generated method stub
		this.comercioRepository.save(comercios);
	}

	
	@Override
	public Comercios getComerciosById(long id) {
	    Optional <Comercios> optional = comercioRepository.findById(id);
	    Comercios employee = null;
	    if (optional.isPresent()) {
	        employee = optional.get();
	    } else {
	        throw new RuntimeException(" Employee not found for id :: " + id);
	    }
	    return employee;
	}

	
	 @Override
	 public void deleteComercioById(long id) {
	  this.comercioRepository.deleteById(id);
	 }
	
}
