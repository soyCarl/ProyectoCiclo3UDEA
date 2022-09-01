package com.co.udea.mintic.ChameleonApp.Controllers;

import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import com.co.udea.mintic.ChameleonApp.Entities.Perfil;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

import static com.co.udea.mintic.ChameleonApp.Entities.Enum_RoleName.ADMIN;

@RestController
@RequestMapping ("/")
public class controllerEmpleado {

    @GetMapping ("/empleado")
    public Empleado verEmpleado()  {
    Empleado empley = new Empleado(1,"empleado@gmail",new Perfil(), ADMIN, new Empresa(),new ArrayList<>(),new Date(),new Date());
    return empley;
    }
    //public String verEmpleados(){
        //return "Mostrar empleado";}


    @PostMapping ("/empleado")
    public String guardarEmpleado(){
        return "Guardar Empleado";
    }


}
