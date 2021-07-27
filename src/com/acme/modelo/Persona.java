package com.acme.modelo;

/**
 *
 * @author Jefferson N
 */
//Clase Persona que va a ser Base padre para herencias
public class Persona {
	//Declaracion de variable de la clase Persona(padre)
	private String nombre;
	
	//Declaracion de constructor que recibe una cadena de texto
	//@param String nombre: Cadena de texto
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	//Declaracion de getters y setters de la variable de
	//la clase Persona
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
