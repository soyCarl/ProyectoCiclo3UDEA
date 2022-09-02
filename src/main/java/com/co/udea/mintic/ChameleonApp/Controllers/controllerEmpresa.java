package com.co.udea.mintic.ChameleonApp.Controllers;

import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
public class controllerEmpresa {

    @GetMapping("/empresa")
    public String verEmpresas() {
        return "Hola empresas desde Get";
    }

    @PostMapping("/empresa")
    public String guardarEmpresas(){
        return "Guarar empresa desde Post";
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
}
