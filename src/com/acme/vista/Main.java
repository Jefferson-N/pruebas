package com.acme.vista;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.acme.controlador.*;
/**
*
* @author Jefferson N
*/

public class Main {
	//Declaracion de variables privadas del tipo ControlArchivo y ControlInformacion
	private static ControlArchivo informacionArchivo;
	private  static ControlInformacion informacionEmpleado;
	public static void main(String[] args) {
		//Inicializacion de variables privadas
		informacionArchivo= new ControlArchivo();
		informacionEmpleado= new ControlInformacion();
		
		Boolean valor=true;
		String rutaInformacion="src/data.txt";
		
		
		 
		
		 
	      //Bucle  wile que ejecuta mientras el valor booleano sea verdadero 
		 while(valor) {
			 
			 new Scanner(System.in );
			 
			 	//Impresion del menu del sistema de pagos
	        	System.out.println("*    ACME Employee Payment System  *");
	        	System.out.println("*-------Employee payments----------*");
	        	        	
	           			//Control de excepciones
		        		try {
		        			
		        			//Declaracion de variable tipo map
		      				Map<String,Map<String,String>> entrada;
		      				
		      				//asignacion de valores a la variable entrada
		      				entrada= informacionArchivo.obtenerHorarioEmpleado(rutaInformacion);
		      				
		      				//Declaracion de iteradores y asignacion de valores
		      				Iterator<String> itNombre = entrada.keySet().iterator();
		      				Iterator<String> itMostrarPagos = entrada.keySet().iterator();
		      				
		      				//declaracion de la variable clave
		      				String clave=null;
		      				
		      				System.out.println("************************************");
		      				informacionEmpleado.getEmpleados().clear();
		      				//recorre el iterador itNombre y registra los nombres obtenidos
		      				while(itNombre.hasNext()){
		      					
		      						clave = itNombre.next().toString();
		      					
		      						informacionEmpleado.registroEmpleado(clave);
		      				 
		      					
		      				}
		      				
		      				//recorre el itMostrarPagos itNombre y muestra los nombres y sueldo de cada empleado
		      				while(itMostrarPagos.hasNext()){
		      					
			      				  clave =  itMostrarPagos.next().toString();			      				
			      				  informacionEmpleado.mostrarPago(clave, entrada.get(clave));
			      			}
		      				
		      				System.out.println("************************************\n");
		      				System.out.println("Thanks, come back soon:)");
		      				
		      		  	} catch (Exception e) {//Envia un mensaje de error si el bloque evaluado tiene algun error
		      		  		
		      		  		System.out.println(e.getMessage());
		      		  	}
		      
		        		valor=false;
	       	        
		 }// cierra el sistema
		 System.exit(0);
	}
}
