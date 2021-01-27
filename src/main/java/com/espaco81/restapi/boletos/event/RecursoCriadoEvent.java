package com.espaco81.restapi.boletos.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * 
 * @author Euller
 *
 */

public class RecursoCriadoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3701215896005276423L;

	private HttpServletResponse response;

	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}

}
