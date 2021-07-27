package com.acme.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.acme.controlador.ControlInformacion;
import com.acme.excepcion.EmptyException;

public class ControlInformacionTest {


	private static ControlInformacion controlnformacion = new ControlInformacion();
	//Registra un empleado y verifica que la lista contenga informacion
	@Test
	public void registroEmpleadoTest() throws EmptyException {
		controlnformacion.registroEmpleado("Marco");
		assertEquals("Empleado ingresado",controlnformacion.getEmpleados().isEmpty(),false );
		
	}	
	
	//Si los horarios son registrados retorna true caso contrario retorna false
	@Test
	public void registroHorarioTest() {
				
		assertEquals("Horario registrado",true,controlnformacion.registroHorario() );
		
	}
	

}
