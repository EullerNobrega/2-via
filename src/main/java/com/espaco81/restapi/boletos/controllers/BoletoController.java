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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.espaco81.restapi.boletos.event.RecursoCriadoEvent;
import com.espaco81.restapi.boletos.model.Boleto;
import com.espaco81.restapi.boletos.services.BoletoService;

import javassist.NotFoundException;

/**
 * 
 * @author Euller
 *
 */

@RestController
@RequestMapping("/boletos")
public class BoletoController implements CadController<Boleto> {
	@Autowired
	private BoletoService boletoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Boleto> listAll() {
		return boletoService.listAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Boleto> persist(@Valid @RequestBody Boleto boleto, HttpServletResponse response) {
		Boleto boletoSalvo = boletoService.insert(boleto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, boletoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(boletoSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Boleto>> find(@PathVariable Long id) {
		Optional<Boleto> boleto = boletoService.findOne(id);
		return boleto.isPresent() ? ResponseEntity.ok(boleto) : ResponseEntity.notFound().build();

	}

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		boletoService.delete(id);
		
	}

}
