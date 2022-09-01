package com.co.udea.mintic.ChameleonApp.Controllers;

import net.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
