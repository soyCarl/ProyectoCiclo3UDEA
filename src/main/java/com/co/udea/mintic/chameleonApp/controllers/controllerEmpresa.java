package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/")
public class controllerEmpresa {
    @Autowired
    EmpresaServices empresaServices;

    @GetMapping("/empresa")
    public List<Empresa> verEmpresas() {
        return this.empresaServices.getAllEmpresas();
    }

    @PostMapping("/empresa")
    public Empresa guardarEmpresa(@RequestBody Empresa empre) {
        return this.empresaServices.saveOrUpdateEmpresa(empre);
    }

    @GetMapping(path = "/empresa/{id}")
    public Empresa empresaPorID(@PathVariable("id") Long id) {
        return this.empresaServices.getEmpresaById(id);
    }

    @PatchMapping("/empresa/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empre) {
        Empresa empr = empresaServices.getEmpresaById(id);
        empr.setNombreEmpresa(empre.getNombreEmpresa());
        empr.setNitEmpresa(empr.getNitEmpresa());
        empr.setTelefonoEmpresa(empr.getTelefonoEmpresa());
        empr.setDireccionEmpresa(empr.getDireccionEmpresa());
        empr.setEmpleado(empr.getEmpleado());
        empr.setMovimientoDinero(empr.getMovimientoDinero());
        empr.setFechaCreacion(empr.getFechaCreacion());
        empr.setFechaActualizacion(empr.getFechaActualizacion());
        return empresaServices.saveOrUpdateEmpresa(empr);
    }

    @DeleteMapping(path = "empresa/{id}")
    public String DeleteEmpresa(@PathVariable("id") Long id) {
        boolean respuesta = this.empresaServices.deleteEmpresa(id);
        if (respuesta) {
            return "Se eliminó la empresa con id" + id;
        } else {
            return "No se pudo eliminar la empresa con id" + id;
        }
    }
    /*
    @GetMapping("/empresa")
    public String verEmpresas() {
        return "Hola empresas desde Get";
    }

    @PostMapping("/empresa")
    public String guardarEmpresas(){
        return "Guardar empresa desde Post";
    }

    @GetMapping(path = "/empresa/buscar/{id}")
    public Empresa buscarEmpresa(){
        Empresa empresa = new Empresa(1, "ChameleonDevs", "12345-7", "33377712", "Avenida 5", null, null, new Date(), new Date());
        return empresa;
    }

    @PatchMapping(path = "/empresa/actualizar/{id}")
    public String actualizarEmpresa(){
        return "Actualizando empresa con el id";
    }

    @DeleteMapping(path = "/empresa/borrrar/{id}")
    public String borrarEmpresa(){
        return "Borrando empresa con el id";
    }
     */
}
