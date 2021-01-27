package com.espaco81.restapi.boletos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espaco81.restapi.boletos.model.Categoria;

public interface CategoriaDAO extends JpaRepository<Categoria, Long>{

}
