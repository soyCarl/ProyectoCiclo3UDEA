package com.co.udea.mintic.ChameleonApp;

import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
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

		//Instancia de la clase MovimientoDinero
		MovimientoDinero compra = new MovimientoDinero();
		compra.setConcepto("Compra televisor");
		compra.setMonto(1500000f);
		compra.setEmpleado(new Empleado("Diego","prueba@gmail.com","Chamaleon","ADMIN"));

		System.out.println(compra.getConcepto());
		System.out.println(compra.getMonto());
		System.out.println(compra.getEmpleado().toString());


	}

}
