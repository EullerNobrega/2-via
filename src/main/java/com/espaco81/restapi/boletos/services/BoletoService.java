package com.espaco81.restapi.boletos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espaco81.restapi.boletos.dao.BoletoDAO;
import com.espaco81.restapi.boletos.model.Boleto;

/**
 * 
 * @author Euller
 *
 */

@Service
public class BoletoService {
	@Autowired
	private BoletoDAO boletoDAO;
	
	public List<Boleto> listAll() {
		return boletoDAO.findAll();
	}
	
	public Boleto insert(Boleto boleto) {
		return boletoDAO.save(boleto);
	}
	
	public Optional<Boleto> findOne(Long id) {
		return boletoDAO.findById(id);
	}
}
