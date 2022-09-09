package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import com.co.udea.mintic.chameleonApp.services.MovimientosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/")
public class controllerMovimientos {
    @Autowired
    MovimientosServices movimientosServices;

    @GetMapping("/movimientos") 
    public List<MovimientoDinero> verMovimientos(){
        System.out.println("entre al get:"+movimientosServices.getAllMovimientos());
        return movimientosServices.getAllMovimientos();
    }

    @PostMapping("/movimientos")
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero movimiento){
        return movimientosServices.saveOrUpdateMovimiento(movimiento);
    }

    @GetMapping("/movimientos/{id}")
    public MovimientoDinero movimientoPorId(@PathVariable("id") Long id){
        return movimientosServices.getMovimientoById(id);
    }

    @PatchMapping("/movimientos/{id}")//Editar o actualizar un movimiento
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Long id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov=movimientosServices.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setEmpleado(movimiento.getEmpleado());
        mov.setEmpresa(movimiento.getEmpresa());
        mov.setFechaCreacion(movimiento.getFechaCreacion());
        mov.setFechaActualizacion(movimiento.getFechaActualizacion());
        return movimientosServices.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/movimientos/{id}")
    public String deleteMovimiento(@PathVariable("id") Long id){
        boolean respuesta= movimientosServices.deleteMovimiento(id);
        if (respuesta){
            return "Se elimino correctamente el movimiento con id " +id;
        }
        return "No se pudo eliminar el movimiento con id "+id;
    }

    @GetMapping("/empleados/{id}/movimientos") //Consultar movimientos por id del empleado
    public ArrayList<MovimientoDinero> movimientosPorEmpleado(@PathVariable("id") Long id){
        return movimientosServices.obtenerPorEmpleado(id);
    }

    @GetMapping("/enterprises/{id}/movimientos") //Consultar movimientos que pertenecen a una empresa por el id de la empresa
    public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("id") Long id){
        return movimientosServices.obtenerPorEmpresa(id);
    }
}

