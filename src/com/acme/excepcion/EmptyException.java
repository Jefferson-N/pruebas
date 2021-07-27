package com.acme.excepcion;

//Clase EmptyException que hereda las propid¿edades de Exception

public class EmptyException extends Exception {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	//Metodo que da un mensaje de error personalizado
	public EmptyException(String msg) {
		super(msg);
	}

}
