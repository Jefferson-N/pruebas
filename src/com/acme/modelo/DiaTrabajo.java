package com.acme.modelo;

/**
*
* @author Jefferson N
*/

//Clase DiaTrabajo que recibe la jornada laboral
public class DiaTrabajo {
	
	//declaracion de variables para la clase DiaTrabajo
	
	private String dia;
	private String horaLaboral;
	private double pago;
		
	/**
	  * Constructor que recibe parametros dia, horalaboral, pago
	  * @param String dia recibe el dia trabajado por el empleado
	  * @param String horaLaboral recive el horario de trabajo dell dia
	  * @param double pago - recive el valor a pagar dependiendo del dia y horario
	*/
	public DiaTrabajo(String dia, String horaLaboral, double pago) {
		super();
		this.dia = dia;
		this.horaLaboral = horaLaboral;
		this.pago = pago;
	}
	//Declaracion de constructor de la clase 
	public DiaTrabajo(){
		
	}
	
	//Declaracion de getters y setters de la variable de
	//la clase Empleado
	public String getDia() {
		return dia;
	}
	
	public void setDia(String dia) {
		this.dia = dia;
	}
	
	public String getHoraLaboral() {
		return horaLaboral;
	}
	
	public void setHoraLaboral(String horaLaboral) {
		this.horaLaboral = horaLaboral;
	}
	
	public double getPago() {
		return pago;
	}
	
	public void setPago(double pago) {
		this.pago += pago;
	}
	
	
}
