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
@Table(name = "boleto")
public class Boleto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4864570852883097430L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String codigo;
	@NotNull
	@Size(min = 2, max = 20)
	private String descricao;
	private String imagemPath;
	private Categoria categoria;
	
	// Getters & Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getimagemPath() {
		return imagemPath;
	}
	public void setimagemPath(String imagemPath) {
		this.imagemPath = imagemPath;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
