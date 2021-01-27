package com.espaco81.restapi.boletos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espaco81.restapi.boletos.dao.CategoriaDAO;
import com.espaco81.restapi.boletos.model.Categoria;

@Service
public class CategoriaService implements CadService<Categoria>{
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> listAll() {
		return categoriaDAO.findAll();
	}

	@Override
	public Categoria insert(Categoria categoria) {
		return categoriaDAO.save(categoria);
	}

	@Override
	public Optional<Categoria> findOne(Long id) {
		return categoriaDAO.findById(id);
	}

	@Override
	public void delete(Long id) {
		categoriaDAO.deleteById(id);
		
	}

}
