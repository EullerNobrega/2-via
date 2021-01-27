package com.espaco81.restapi.boletos.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.espaco81.restapi.boletos.event.RecursoCriadoEvent;
import com.espaco81.restapi.boletos.model.Categoria;
import com.espaco81.restapi.boletos.services.CategoriaService;

/**
 * 
 * @author Euller
 *
 */

@RestController
@RequestMapping("/categorias")
public class CategoriaController implements CadController<Categoria>{
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Override
	@GetMapping
	public List<Categoria> listAll() {
		return categoriaService.listAll();
	}

	@Override
	@PostMapping
	public ResponseEntity<Categoria> persist(@Valid Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaService.insert(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> find(Long id) {
		Optional<Categoria> categoria = categoriaService.findOne(id);
		return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		categoriaService.delete(id);
		
	}
	

}
