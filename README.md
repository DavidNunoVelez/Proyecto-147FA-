# Gestión de partes #

Está aplicación está diseñada para su uso en una empresa de transportes. Permite la gestión de centros de trabajo, vehículos, trabajadores y partes.

## ¿Cómo funciona? ##

Existen dos tipos de trabajadores:

	* Transportistas 
		Crean los partes de trabajo según los repartos que hayan realizado en su jornada laboral. Además pueden adjuntar los gastos de gasoil o dietas, entre otros, y dejar constancia de las incidencias recogidas.
	* Administrativos
		Gestionan altas y bajas de centros, trabajadores y vehículos. También validan que los transportistas hayan rellenado los partes correctamente y no hayan excedido su jornada laboral.
		
## Requisitos: ##
	
	Una base de datos Oracle DataBase 12c o superior.

## Pasos para la instalación: ##

	### ¡OJO! El orden de ejecución es importante. ###
	
	1. Ejecutar el siguiente [script](MODELO FÍSICO/SCRIPT FISICO.ddl) sobre la base de datos. 
			Este script crea las tabla necesarias y la configuración de usuario, contraseña y servidor que va a utilizar la aplicación.
			Si necesitas cambiar estos datos, puedes consultar [aquí]() como hacerlo.
	2. Ejecutar el [script](PL-SQL/Pl-sql FASE 2.sql) de procedimientos sobre la base de datos.
	3. Ejecutar el [script]() que contiene el trigger sobre la base de datos.
	4. Iniciar el ejecutable [Proyecto](Proyecto/dist/Proyecto.jar).
			Si quieres cambiar la ubicación de este archivo debes mover también la carpeta [lib](Proyecto/dist/lib) a la misma carpeta que el ejecutable.
			Es recomendable que crees un acceso directo por ejemplo a tu escritorio.

