package com.acme.test;

import static org.junit.Assert.*;

import java.util.Map;
import org.junit.Test;

import com.acme.controlador.ControlArchivo;

public class ControlArchivoTest {
	private static ControlArchivo informacionArchivo = new ControlArchivo();
	Map<String,Map<String,String>> informacion;
	
	//Busca el archivo y debuelve true si lo encuentra caso contrario devuelve false
	@Test
	public void obtenerHorarioEmpleadoTest() {
		
		informacion = informacionArchivo.obtenerHorarioEmpleado("./src/data.txt");
		assertEquals("Archivo encontrado", informacion.isEmpty(),false);
		
	}	
	
	//Acepta una cadena de texto y obtiene la hora 
	@Test
	public void obtenerHoraTest() {
		String infoHora = "MO09:01-18:00,TH09:01-18:00";
	
		Map<String,String> resultadoObtenido=informacionArchivo.obtenerHora(infoHora);
	
		assertEquals("Hora obtenida", resultadoObtenido.isEmpty(),false);
		
	}
	
	
	
}
