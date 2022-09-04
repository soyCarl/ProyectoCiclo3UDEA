package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class controllerEmpleado {
    @Autowired
    EmpleadoServices empleadoServices;

    @GetMapping("/empleado")
    public List<Empleado> verEmpleados() {
        return empleadoServices.getAllEmpleados();
    }

    @PostMapping("/empleado")
    public Empleado guardarEmpleado(@RequestBody Empleado emple) {
        return this.empleadoServices.saveOrUpdateEmpleado(emple);
    }

    @GetMapping(path = "/empleado/{id}")
    public Empleado empleadoPorID(@PathVariable("id") Long id) {
        return this.empleadoServices.getEmpleadoById(id);
    }

    @PatchMapping("/empleado/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Long id, @RequestBody Empleado emple) {
        Empleado emp = empleadoServices.getEmpleadoById(id);
        emp.setNombre(emple.getNombre());
        emp.setCorreoEmpleado(emple.getCorreoEmpleado());
        emp.setPerfil(emple.getPerfil());
        emp.setRolEmpleado(emple.getRolEmpleado());//Diego por favor revisar si en esta linea hay conflicto con haber creado el Enum de rolEmpleado
        emp.setEmpresa(emple.getEmpresa());
        emp.setMovDinero(emple.getMovDinero());
        emp.setFechaCreacion(emple.getFechaCreacion());
        emp.setFechaModificacion(emple.getFechaModificacion());
        return empleadoServices.saveOrUpdateEmpleado(emp);
    }

    @DeleteMapping(path = "empleado/{id}")
    public String DeleteEmpleado(@PathVariable("id") Long id) {
        boolean respuesta = this.empleadoServices.deleteEmpleado(id);
        if (respuesta) {
            return "Se eliminó el empleado con id" + id;
        } else {
            return "No se pudo eliminar el empleado con id" + id;
        }
    }

/*
    @GetMapping("/empleado") //Ver json de todos los empleados
    public String verEmpleados(){
        return "Hola empleado desde Get";
    }

    @PostMapping("/empleado")
    public String guardarEmpleado() {
        return "Guardar Empleado";
    }

    @GetMapping(path = "empleado/{id}")
    public String empleadoPorID(@PathVariable("id") Integer id) {
        return "Hola empleado " + id;
    }

    @PatchMapping(path = "empleado/{id}")
    public String actualizarEmpleado(@PathVariable("id") Integer id) {
        return "empleado " + id + " modifcado";
    }

    @DeleteMapping(path = "empleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        return "empleado " + id + " eliminado";
    }
*/
}
