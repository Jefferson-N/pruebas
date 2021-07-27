package com.acme.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.acme.excepcion.EmptyException;
import com.acme.modelo.DiaTrabajo;
import com.acme.modelo.Empleado;
/**
*
* @author Jefferson N
*/

//Clase ControlInformacion añade informacion que sirve de base 
//para calcular los pagos a cada empleado.
//almacenando la informacion en un Map 
public class ControlInformacion {
	
	//Declaracion de un ArrayList del tipo diasTrabajo
	private ArrayList<DiaTrabajo> diasTrabajo=new ArrayList<>();
	
	//Declaracion de un ArrayList del tipo Empleado
	private ArrayList<Empleado> empleados=new ArrayList<>();
	
	//Constructor que inicializa el metodo registroHorario
	public  ControlInformacion(){
						
		registroHorario();	
	
	}	
	
	//Metodo con retorno de booleano para la realizacion de pruebas unitarias
	// registroHorario que agrega informacion a la variable diasTrabajo
	public boolean registroHorario(){
		
		//Declaracion de vector dias 
		String[] dias={"MO","TU","WE","TH","FR","SA","SU"};
		
		//Condiciones que comparan y asignan un valor establecio a la 
		//variable DiaTrabajo dependiendo de los dias establecidos
		
		if(dias[0].equals("MO")||dias[1].equals("TU") || dias[2].equals("TU")
				||dias[3].equals("TH")||dias[4].equals("FR")){
			
			for(int i=0 ; i<dias.length-2;i++){
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"00:01-09:00",25.0));
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"09:01-18:00",15.0));
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"18:01-00:00",20.0));
		}			
		
		}
		
		if(dias[5].equals("SA")||dias[6].equals("SU")){
			
			for(int i=5 ; i<dias.length;i++){
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"00:01-09:00",30.0));
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"09:01-18:00",20.0));
				this.diasTrabajo.add(new  DiaTrabajo(dias[i],"18:01-00:00",25.0));
			}
		}		
		
		if(diasTrabajo.size() >0){
			return true;
		}else{
			return false;
		}
	}
	
	// registroEmpleado que agrega informacion a la variable empleados
	public void registroEmpleado(String nombre) throws EmptyException{
		//Verifica que los nombres se ingresen correctamente de no ser asi 
		//emite un mensaje.
		if(nombre ==(null))
			throw new EmptyException("No se puede registrar los empleados\nPor favor verificar la configuracion");
		
			empleados.add(new Empleado(nombre));
		
				
	}
	
	/**
	  * Metodo obtenerPago para calcular el pago del sueldo parametros :	
	  * @param String horario: Recibe la jornada laboral de un empleado
	  * @param String claveDia: obtiene el dia de trabajo
	  *@param String horario:	Obtiene el horario de trabajo
	  * @param ArrayList<DiaTrabajo> diasTrabajo: obtiene los dias almacenados el la variable diasTrabajo
	  * @return retorna un double pagoDia
	*/
	private double obtenerPago(String claveDia, String horario, ArrayList<DiaTrabajo> diasTrabajo) throws EmptyException{
		double pagoDia=0.0;
		
		//Condcion que verifica que la variable diasTrabajo contenga informacion
		if(diasTrabajo.size()<=0)
			//Tratamiento de errores en tiempo de ejcucion si diasTrabajo.size() es menor o igual a 0
			throw new EmptyException("jornadas laborales no registradas");
		
			//Bucle for para obtener y sumar el el pago el pago obtenido por dias
			for(int i=0;i<diasTrabajo.size();i++){
				//Declaracion y asignacion de valor a las  variables obtenidas en cada poscicion de i
				String diaObtenido =diasTrabajo.get(i).getDia();
				String horarioObtenido=diasTrabajo.get(i).getHoraLaboral();
				
				//Comprobacion de que  las variables diaObtenido y horarioObtenido  coincidan con claveDia y horario
				if(diaObtenido.equalsIgnoreCase(claveDia) &&  horarioObtenido.equalsIgnoreCase(horario) ){
						//Contador que almacena los pagos obtenidos en cada poscicion				
						pagoDia = pagoDia+diasTrabajo.get(i).getPago();
					
				}
			}
		
		return pagoDia;
		
	}
	
	/**
	  * Metodo validarDia que valida los dias laborados y asigna el pago total del empleado
	  * Recibe los siguientes parametros parametros :	
	  * @param Map<String,String>  horario:	Obtiene el dia y horario trabajado
	  * @param ArrayList<DiaTrabajo> diasTrabajo: obtiene los dias almacenados el la variable diasTrabajo
	  * @return retorna un double valor
	*/
	private double validarDia(Map<String,String> horario,ArrayList<DiaTrabajo> diasTrabajo) throws EmptyException  {
		double valor = 0.0; 
		//Variable iterador que asigna un map horario obteniendo la clave del mismo
		Iterator<String> iterador =  horario.keySet().iterator(); 
		
		//Bucle while que recorre cada clave contenida en el Map y asigna un valor del tipo double  a claveDia
		while(iterador.hasNext()){ 
		  String claveDia =  iterador.next().toString();
		  valor += obtenerPago(claveDia,horario.get(claveDia),diasTrabajo); 
		}
		return valor; 
	}
	
	/**
	  * Metodo mostrarPago que imprime el nombre y salario del empleado
	  * Recibe los siguientes parametros parametros :	
	  * @param Map<String,String>  horario:	Obtiene el dia y horario trabajado
	  * @param String nombre: obtiene el nombre del empleado
	  * @return retorna un double valor
	*/
	public void mostrarPago(String nombre, Map<String,String> horarioEmpleado) throws EmptyException{
				
		//Declaracion de una variable del tipo Empleado
		Empleado empleado;
		//Verifica que la variable empleados contenga informacion
		if(empleados.size()>0){
			//Imprime la informacion de cada empleado.
			for(int i=0;i<empleados.size();i++){
				 empleado= empleados.get(i);
				 
				if(empleado.getNombre().equalsIgnoreCase(nombre)) {
					double value = this.validarDia(horarioEmpleado, this.diasTrabajo);
					empleado.setSueldo(value);
					System.out.println("The amount to pay "+nombre+" is: "+empleado.getSueldo()+" USD");
				
				}
				
			}
			
		}else{
			//Tratamiento de errores en tiempo de ejcucion si la condicion no se cumple
			throw new EmptyException("Empleado no registrados");
		}
		
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	
}
