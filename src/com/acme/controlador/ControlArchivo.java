package com.acme.controlador;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;;

/**
*
* @author Jefferson N
*/

//Clase ControlArchivo que lee un fichero de texto(.txt)
//y separa la informacion obtenida en cada linea del texto
//almacenando la informacion en un Map 

public class ControlArchivo {
	
	//Declaracion de variables para la lectura del archivo	
	private File fichero;
	private FileReader  fr;
	private BufferedReader br;
	
	/**
	  * Metodo obtenerHorarioEmpleado del tipo Map y recibe un parametro :	
	  * @param String rutaArchivo: Recibe la direccion del archivo
	  * @return retorna un map del tipo Map<String, Map<String , String> >
	*/
	public Map<String, Map<String , String> >  obtenerHorarioEmpleado(String rutaArchivo){
		
		Map<String,Map<String,String>> resultadoMapa;
		resultadoMapa= new HashMap<String,Map<String,String>>();
		//Manejo de errores
		try{
			//Busca el archivo de texto (.txt) de acuerdo a la ruta			
			this.fichero=new File(rutaArchivo);
			
			//Lee el archivo de texto (.txt) obtenido 
			this.fr= new FileReader(this.fichero);
			
			//Almacena el archivo de texto(.txt) dentro del bufer
			this.br=new BufferedReader(this.fr);
			
			//Revisa que el bufer tenga informacion
			//de no ser asi emite un mensaje de texto
			if(br.ready()){
			
				//Declaracion de una variable y un vector del tipo String
				String linea;			
				String[] resultado = null;			
						
				//Bucle while que toma el valor de una linea de texto y separa en 2 partes
				//almacenando en un Map
				while((linea=br.readLine()) != null ){
					resultado=linea.split("=",2);
					
					Map<String, String> resultadoHora;
					
					//Metodo recibe el horario laboral y separa por dia y hora
					resultadoHora= obtenerHora(resultado[1]);
					
					//Recibe el nombre del empleado y el horario laboral, 
					//almacena la informacion en un Map
					resultadoMapa.put(resultado[0], resultadoHora);
					
				}
				
			}else{
				System.out.println("Agrege la listas de empleados al archivo");
			}
			
			
		}catch(Exception e){
			//imprime un mensaje de error si el contenido evaludado
			// posee algun error
			System.out.println(e.getMessage());
		}finally{
			
			//Manejo de errores
			try{
				//Compara que el FileReader tenga un valor almacenado 
				if(null != fr){
					//Cierra el archivo d texto
					fr.close();
				}
				//imprime un mensaje de error si el contenido evaludado
				// posee algun error
			}catch(Exception e){
					System.out.println(e.getMessage());
			}
		}
		return resultadoMapa;
	}
	
	/**Metodo obtenerHora del tipo Map y recibe un parametro :	
	  * @param String horario: Recibe la jornada laboral de un empleado
	  * @return retorna el dia y hora almacenados en map del tipo Map<String,String>
	*/
	public Map<String,String>obtenerHora(String horario){
		
		// Crea y inicializa una variable del resultadoHora del tipo Map
		Map<String,String> resultadoHora = new HashMap<String,String>();
		
		if(horario!= null){
		//Crea y inicializa vector que recibe una cadena y los separa
		String[] diaHora= horario.split(",",6);
		
		//Creacion de variables del tipo String
		String dia,hora;
		
		//Bucle for que toma el valor de un vector y separa en 2 partes
		//almacenando la informacion en una variable resultadoHora del tipo Map
		for(int i=0;i<diaHora.length;i++){
			dia=diaHora[i].substring(0, 2);
			hora=diaHora[i].substring(2);
			resultadoHora.put(dia, hora);
		}
	}else{
		System.out.println("Ingrese un horario para obtener la hora");
		return null;
	}
	
		return resultadoHora ;
		
	}
	
	
	

	
	
}
