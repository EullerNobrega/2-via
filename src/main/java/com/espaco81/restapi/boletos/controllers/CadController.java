package com.espaco81.restapi.boletos.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 
 * @author Euller
 *
 * @param <T>
 */

public interface CadController<T> {
	public List<T> listAll();
	
	public ResponseEntity<T> persist(@Valid @RequestBody T t, HttpServletResponse response);
	
	public ResponseEntity<Optional<T>> find(@PathVariable Long id);
	
	public void delete(@PathVariable Long id);
	
}
