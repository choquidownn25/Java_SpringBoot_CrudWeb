package com.example.comercio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.comercio.models.Comercios;



@Repository
public interface ComercioRepository  extends JpaRepository<Comercios, Long>{

}