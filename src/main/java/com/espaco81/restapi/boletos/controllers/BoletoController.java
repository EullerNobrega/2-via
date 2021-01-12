package com.espaco81.restapi.boletos.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.espaco81.restapi.boletos.model.Boleto;
import com.espaco81.restapi.boletos.services.BoletoService;

/**
 * 
 * @author Euller
 *
 */

@RestController
@RequestMapping("/boletos")
public class BoletoController {
	@Autowired
	private BoletoService boletoService;

	@GetMapping
	public List<Boleto> listAll() {
		return boletoService.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Boleto> persist(@Valid @RequestBody Boleto b, HttpServletResponse response) {
		Boleto boleto = boletoService.insert(b);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(boleto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(boleto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Boleto>> find(@PathVariable Long id) {
		Optional<Boleto> boleto = boletoService.findOne(id);
		return boleto.isPresent() ? ResponseEntity.ok(boleto) : ResponseEntity.notFound().build();
		
	}

}
