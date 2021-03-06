package com.espaco81.restapi.boletos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 
 * @author Euller
 *
 */

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4338273482037205049L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min = 3, max = 20)
	@NotNull
	private String descricao;
	
	// Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
