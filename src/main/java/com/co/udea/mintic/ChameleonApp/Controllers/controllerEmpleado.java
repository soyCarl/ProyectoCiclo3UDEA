package com.co.udea.mintic.ChameleonApp.Controllers;

import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
import com.co.udea.mintic.ChameleonApp.Services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class controllerEmpleado {
    @Autowired(required=false)
    EmpleadoServices empleadoService;

    @GetMapping("/empleado") //Ver json de todos los empleados
    public List<Empleado> verEmpresas(){
        return empleadoService.getAllEmpleados();
    }

    @PostMapping("/empleado") //Guardar el json del body como un nuevo empleado o registro en nuestra bd
    public Empleado guardarEmpresa(@RequestBody Empleado emple){
        return this.empleadoService.saveOrUpdateEmpleado(emple);
    }

    @GetMapping(path = "/empleado/{id}")
    public Empleado empleadoPorID(@PathVariable("id") Integer id){
        return this.empleadoService.getEmpleadoById(id);
    }

    @PatchMapping("/empleado/{id}")
    public Empleado actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empleado emple){
        Empleado emp= empleadoService.getEmpleadoById(id);
        emp.setCorreoEmpleado(emple.getCorreoEmpleado());
        emp.setPerfil(emple.getPerfil());
        emp.setRolEmpleado(emple.getRolEmpleado());//Diego por favor revisar si en esta linea hay conflicto con haber creado el Enum de rolEmpleado
        emp.setEmpresa(emple.getEmpresa());
        emp.setMovDinero(emple.getMovDinero());
        emp.setFechaCreacion(emple.getFechaCreacion());
        emp.setFechaModificacion(emple.getFechaModificacion());
        return empleadoService.saveOrUpdateEmpleado(emp);

    }

    @DeleteMapping (path= "empleado/{id}") //Eliminar registro de la bd
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta= this.empleadoService.deleteEmpleado(id);
        if (respuesta){  //Si respuesta es true?
            return "Se eliminó el empleado con id" +id;
        }
        else{
            return "No se pudo eliminar el empleado con id"+id;
        }
    }


}
