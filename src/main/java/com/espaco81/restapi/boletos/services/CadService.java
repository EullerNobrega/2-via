package com.espaco81.restapi.boletos.services;

import java.util.List;
import java.util.Optional;


/**
 * 
 * @author Euller
 */


/**
 * 
 * @param t
 * @return
 */

public interface CadService<T> {

	public List<T> listAll();
	
	public T insert(T t);
	
	public Optional<T> findOne(Long id);
	
	public void delete(Long id);
	
	
}
