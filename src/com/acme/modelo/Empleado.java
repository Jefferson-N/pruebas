package com.acme.modelo;
/**
*
* @author Jefferson N
*/
//Clase Empleado que hereda los atributos de la clase Persona

public class Empleado extends Persona {
	
	private	double sueldo=0.0; //Declaracion de variable de la clase Empleado(hija)	
	
	//Declaracion de constructor que recibe una cadena de texto heredada de la clase Persona
	//@param String nombre: Cadena de texto heredada de la clase Persona
	
	public Empleado(String nombre) {
		super(nombre);		
		this.sueldo=0.0;
	}

	//Declaracion de getters y setters de la variable de
	//la clase Empleado
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo =  sueldo;
	}

	

	
	
	
	
}
