package com.co.udea.mintic.ChameleonApp;

import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import com.co.udea.mintic.ChameleonApp.Entities.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ChameleonAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(ChameleonAppApplication.class, args);
		System.out.println("Hello my people. I'm Armando!");
		System.out.println("hola soy Diego, saludos");
		System.out.println("Hola soy luisa");
		System.out.println("Hola, soy Briggid");
		System.out.println("Hola soy Pablo");

		//Intancia Modelo Empresa
		Empresa empresa = new Empresa();
		empresa.setNombreEmpresa("Chameleon Devs");
		empresa.setDireccionEmpresa("Plaza Bolivar");
		empresa.setTelefonoEmpresa("555 5555");
		empresa.setNitEmpresa("1236571-1");

		System.out.println("\nNombre de la empresa: " + empresa.getNombreEmpresa());
		System.out.println("Direccion de la empresa: " + empresa.getDireccionEmpresa());
		System.out.println("Telefono de la empresa: " + empresa.getTelefonoEmpresa());
		System.out.println("Nit de la empresa: " + empresa.getNitEmpresa() + "\n");
		//Intancia Modelo Empresa


	    //Instancia de la clase Empleado
		Empleado empleado = new Empleado();
		empleado.setNombreEmpleado("Briggid Sierra");
		empleado.setCorreoEmpleado("brisierrav@gmail.com");
		empleado.setEmpresaEmpleado("Chameleon");
		empleado.setRolEmpleado("");

		System.out.println(empleado.getNombreEmpleado());
		System.out.println(empleado.getCorreoEmpleado());
		System.out.println(empleado.getEmpresaEmpleado());
		System.out.println(empleado.getRolEmpleado());
		//Instancia de la clase Empleado


		//Instancia de la clase MovimientoDinero
		MovimientoDinero compra = new MovimientoDinero();
		compra.setConcepto("Compra televisor");
		compra.setMonto(1500000f);
		compra.setEmpleado(new Empleado("Diego","prueba@gmail.com","Chamaleon","ADMIN"));

		System.out.println(compra.getConcepto());
		System.out.println(compra.getMonto());
		System.out.println(compra.getEmpleado().toString());
		//Instancia de la clase MovimientoDinero

	}

}

