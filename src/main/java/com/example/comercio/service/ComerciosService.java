package com.example.comercio.service;

import java.util.List;

import com.example.comercio.models.Comercios;
//Contrato del crud
public interface ComerciosService {
	 List<Comercios> getAllComercios();
	 void saveComercio(Comercios comercios);
	 Comercios getComerciosById(long id);
	 void deleteComercioById(long id);
}
