package com.espaco81.restapi.boletos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espaco81.restapi.boletos.model.Boleto;

/**
 * 
 * @author Euller
 *
 */

public interface BoletoDAO extends JpaRepository<Boleto, Long>{

}
