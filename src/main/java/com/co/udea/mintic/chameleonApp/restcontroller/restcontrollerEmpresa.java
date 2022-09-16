package com.co.udea.mintic.chameleonApp.restcontroller;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class restcontrollerEmpresa {
    @Autowired
    EmpresaServices empresaServices;

    @GetMapping("/empresa")
    public List<Empresa> verEmpresas() {
        return this.empresaServices.getAllEmpresas();
    }

    @PostMapping("/empresa")
    public Empresa guardarEmpresa(@RequestBody Empresa empre) {
        return this.empresaServices.saveOrUpdateEmpresaRest(empre);
    }

    @GetMapping(path = "/empresa/{id}")
    public Empresa empresaPorID(@PathVariable("id") Long id) {
        return this.empresaServices.getEmpresaById(id);
    }

    @PatchMapping(value = "/empresa/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Long id, @RequestBody Empresa empre) {
        Empresa empr = empresaServices.getEmpresaById(id);
        empr.setNombreEmpresa(empre.getNombreEmpresa());
        empr.setNitEmpresa(empre.getNitEmpresa());
        empr.setTelefonoEmpresa(empre.getTelefonoEmpresa());
        empr.setDireccionEmpresa(empre.getDireccionEmpresa());
        empr.setEmpleado(empre.getEmpleado());
        empr.setMovimientoDinero(empre.getMovimientoDinero());
        empr.setFechaCreacion(empre.getFechaCreacion());
        empr.setFechaActualizacion(empre.getFechaActualizacion());
        System.out.println("id empresa:"+ id + "empresa para actualizar:"+ empr.getTelefonoEmpresa());
        return empresaServices.saveOrUpdateEmpresaRest(empr);
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

}
