package com.co.udea.mintic.chameleonApp;


import com.co.udea.mintic.chameleonApp.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;


@SpringBootApplication
public class ChameleonAppApplication {


    public static void main(String[] args) {

        SpringApplication.run(ChameleonAppApplication.class, args);
		/*
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
		empleado.setRolEmpleado("Administrador");

		System.out.println("\nNombre del empleado: " + empleado.getNombreEmpleado());
		System.out.println("Correo electronico del empleado: " + empleado.getCorreoEmpleado());
		System.out.println("Empresa del empleado: " + empleado.getEmpresaEmpleado());
		System.out.println("Rol del empleado: " + empleado.getRolEmpleado() + "\n");
		//Instancia de la clase Empleado


		//Instancia de la clase MovimientoDinero
		MovimientoDinero compra = new MovimientoDinero();
		compra.setConcepto("Compra televisor");
		compra.setMonto(1500000f);
		compra.setEmpleado(new Empleado("Diego","prueba@gmail.com","Chamaleon","ADMIN"));

		System.out.println("\nCompra realizada: " + compra.getConcepto());
		System.out.println("Valor de la compra: " + compra.getMonto());
		System.out.println("Nombre del empleado que realiza la compra: " + compra.getEmpleado().toString() + "\n");
		//Instancia de la clase MovimientoDinero
*/

		Empleado empleado = new Empleado();

        empleado.setId(1l);
        empleado.setCorreoEmpleado("cdtobon19@gmail.com");
        empleado.setPerfil(new Perfil());
        empleado.setRolEmpleado(Enum_RoleName.valueOf("ADMIN")); //al crear el enum pidio este cambio
		empleado.setEmpresa(new Empresa());
		empleado.setMovDinero(new ArrayList<MovimientoDinero>());


		System.out.println("Id empleado:"+empleado.getId());
		System.out.println("Correo empleado:"+empleado.getCorreoEmpleado());
		System.out.println("Perfil empleado:"+empleado.getPerfil());
		System.out.println("Rol empleado:"+empleado.getRolEmpleado());
		System.out.println("Empresa empleado:"+empleado.getEmpresa());
		System.out.println("Movimientos empleado:"+empleado.getMovDinero());
		System.out.println("Fecha creacion empleado:"+empleado.getFechaCreacion());
		System.out.println("Fecha modificacion empleado:"+empleado.getFechaModificacion());



    }

}

