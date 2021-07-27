# ACMEPagos
Exercise
The company ACME offers their employees the flexibility to work the hours they want. They will pay for 
the hours worked based on the day of the week and time of day, according to the following table:
Monday - Friday
00:01 - 09:00 25 USD
09:01 - 18:00 15 USD
18:01 - 00:00 20 USD
Saturday and Sunday
00:01 - 09:00 30 USD
09:01 - 18:00 20 USD
18:01 - 00:00 25 USD
The goal of this exercise is to calculate the total that the company has to pay an employee, based on 
the hours they worked and the times during which they worked. The following abbreviations will be used 
for entering data:
MO: Monday
TU: Tuesday
WE: Wednesday
TH: Thursday
FR: Friday
SA: Saturday
SU: Sunday
Input: the name of an employee and the schedule they worked, indicating the time and hours. This should 
be a .txt file with at least five sets of data. You can include the data from our two examples below.
Output: indicate how much the employee has to be paid
##For example:
Case 1:
INPUT
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
OUTPUT:
The amount to pay RENE is: 215 USD
Case 2:
INPUT
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
OUTPUT:
The amount to pay ASTRID is: 85 USD

## Descripcion de la Solución :
	El codigo esta constituido por metodos que asignan tareas, para capturar la informacion de archivo(.txt)
	dividiendo la informacion según el horario y costo por hora, esta informacion se guarda en diccionarios que asocian claves 
	a los valores y estas no pueden contener valores duplicados.
	Luego el sistema realizara comparaciones para sumar los pagos del empleado asignando este valor a una 
	variable donde va a contener el sueldo total del empleado
	
	*Tomar en cuenta que para evitar conflictos a futuro los nombres y días laborados no pueden repetirse.
	
	*Una recomendación seria que si los nombres de los empleados coinciden se les podría agregar la inicial del primer apellido al nombre
	ejemplo JeffersonN o poner el segundo nombre de uno de los empleados.
	
	*Los empleados podrán escoger un horario por cada día de la semana
	
	*Los datos de los empleados deben registrarse según de la siguiente manera:
		Nombre=DiaHorario,DiaHorario,DiaHorario,DiaHorario
		DAVID=FR00:01-09:00,TU09:01-18:00,WE18:01-00:00
	De esta manera el sistema podrá separar la información y almacenarla en diccionarios

## 	Enfoque utilizado:
		Se utilizo el modelo en cascada ya que es un proceso secuencial, la cual permite
		dividir los procesos de desarrollo en fases sucesivas del proyecto.
		
		Este enfoque permite al desarrollador verificar la aplicación en el siguiente orden:
##   	Análisis: 
		En esta parte es donde verificamos los requisitos que pide el ejercicio:
		*El sistema Pide el ingreso de un nombre 
		  una jornada laboral en Archivo.txt, el cual contendrá la información
		  de 5 empleados.
		  INPUT
		  RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
	
		*El sistema tendrá una salida en pantalla con el siguiente formato.
   		  OUTPUT:
		   The amount to pay Rene is: 85 USD
		  Dado que los horarios del caso anterior no son similares a los horarios de comparación,
		  el sistema va imprimir un sueldo de 0USD, es por esto que se han modificado los horarios
		  de los ejemplos para que imprima un valor real.
		*La información ingresada anteriormente será comparada según los días y horarios establecidos por el cliente:
			
## 	Diseño:
		Para la arquitectura de software se utilizó el MVC(Modelo Vista Controlador)
		Modelo: Va a contener la estructura de las clases implementadas de la siguiente manera:
		Paquete com.acme.modelo
			Class Persona : Basado en los principios SOLID se creo esta clase para que sirva de 
					base para que puedan heredar clases hijas.
			Class Empleado : Esta clase hereda los atriburos de la clase persona.
			Class DiaTrabajo : Esta clase sirne de plantilla contruir un array de la misma que almacene valores,
					   representando el dia trabajado por un empleado
			
		Paquete com.acme.Vista
			Class Main: Esta clase muestra la información de los pagos generados a cada empleado al usuario.
		
		paquete com.acme.controlador
			class ControlArchivo: Esta clase realiza las operaciones para leer el archivo y guardar 
					      la información en un diccionario Map
			class ControlInformacion: Esta clase permite registrar la información dada para las comparaciones y 
						  validacion de los sueldos de cada empleado
		 
		-------Paquetes adicionales-------------------
		com.acme.test: Paquete que contiene los test de la clase persona
		com.acme.imagen.uml: paquete que contiene un diagrama uml en formato jpg del proyecto
		com.acme.excepcion: Este paquete contiene una clase LLamada EmptyException la cual hereda los atributos de la clase Exception
					que permite enviar un mensaje de Excepcion personalizado.
##	   Implementación	
		En esta fase realizamos las pruebas unitarias:
			En esta fase se busca errores en el codigo
			Para la realización de pruebas unitarias añadimos una biblioteca externa:
			JUnit 4
		Paquete com.acme.test: Este paquete va a contener las siguientes clases:
			Class ControlArchivoTest: Esta clase va a realizar pruebas unitarias de la clase ControlArchivo
			Class ControlInformacionTest: Esta clase va a realizar pruebas unitarias de la clase ControlInformacion
	
	   Pruebas: En esta fase se realizaron pruebas de funcionamiento del software para ver si el software cumple con las exigencias DE la	
	 	    empresa ACME.
		
	   Mantenimiento: en esta fase se corrige el codigo para que el sistema funcione de acuerda a las exigencias de la empresa ACME		
		
## Metodología utilizada 

	Nos basamos en la metodología Scrum la cual es una metodología ágil y nos permite divide en etapas 
	(análisis, desarrollo y testing)
	Instrucciones para descargar el proyecto-
	Se puede descargar el proyecto de dos maneras:

	1- Ingrese al siguiente Link  https://github.com/Jefferson-N/ACMEPagos.git 

	2.- En la parte superior derecha de la página dar click en code.

	3.-Seleccionar Descargar ZIP, la descarga se iniciara.


Mediante código de Git Bash:

	1.- Abrimos la consola de comandos de git

	2.-Nos ubicamos en la carpeta donde se desea clonar el proyecto.

	3.-Ingresar el siguiente código

		# git clone https://github.com/Jefferson-N/ACMEPagos.git 

	4.- presionar enter y el proyecto se copiara a la carpeta seleccionad.
	
	Instrucciones para compilar y ejecutar el proyecto
 Dadas las especificaciones, el proyecto se subió sin los archivos compilados.
A continuación, se detalla en que sistema se desarrolló la a aplicación y los pasos a seguir para compilar y ejecutar el proyecto. 
## El proyecto se realizó en un sistema con las siguientes características:
	
	S.O(Sistema Operativo):			        Windows 10 Pro-64bits
	Lenguaje de programación: 			java
	IDE(Integrated Development Environment):	Eclipse Version: Neon.3 Release (4.6.3)
	JDK(Java Development Kit):			java version "1.8.0_171"
	Java Run Time 					pre requisito debe estar instalado en la maquina cliente.
	
	1.-Abrimos eclipse.

	2.- Escogemos la opción File -> Open Projects from File System
	
	3.- Escogemos “Directory” y buscamos la carpeta que contiene nuestro proyecto.

	4.-Damos clic en Finish

	5.- Abierto el proyecto en eclipse nos dirigimos al paquete com.acme.vista
	
	6.-Verificar en la pestaña Project que este seleccionado Build Automatically
	
	7.-Selecionamos la clase Main.java
	
	8.-Selecionamos Run As

	9.-Damos click en Java Aplication

	10.-El proyecto procede a ejecutarse y compilarse

### Compilar desde consola de windows:
	
	1.- Ejecutar como administrador la consola de comandos.
	2.- Acedemos a la carpeta del proyecto.
	3.- Creamos un directorio bin con el siguiente comando:
		´md bin´
	4.- ejecutamos el siguiente comando:
		javac -d bin -cp src src/com/acme/vista/Main.java
	5.- Presionar enter
Se generaran los archivos compilados y se guardaran en la carpeta bin.

### Ejecutar desde consola de windows:
	1.- Ejecutar como administrador la consola de comandos.
	2.- Acedemos a la carpeta del proyecto.
	3.- Si ya se realizo la compilacion  se ejecuta el siguiente codigo:
			java -cp bin com.acme.vista.Main
	4.-Presionar enter
El proyecto se ejecutara y mostrara la informacion en consola

## Diagrama UML   ![Alt Diagrama UML](https://github.com/Jefferson-N/ACMEPagos/blob/master/src/com/acme/imagen/uml/ACMEPagosUML.jpg)
