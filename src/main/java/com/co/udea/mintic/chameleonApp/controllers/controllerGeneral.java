package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.services.EmpleadoServices;
import com.co.udea.mintic.chameleonApp.services.EmpresaServices;
import com.co.udea.mintic.chameleonApp.services.MovimientosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class controllerGeneral {
    @Autowired
    EmpleadoServices empleadoServices;
    @Autowired
    EmpresaServices empresaServices;
    @Autowired
    MovimientosServices movimientosServices;

    @GetMapping("/Index")
    public String verEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        int numEmple=empleadoServices.obtenerCantEmpleados();
        int numEmpre=empresaServices.obtenerCantEmpresas();
        float totalPos=movimientosServices.obtenerTotalMovPos();
        float totalNeg=movimientosServices.obtenerTotalMovNeg();

        model.addAttribute("mensaje",mensaje);
        model.addAttribute("numEmple",numEmple);
        model.addAttribute("numEmpre",numEmpre);
        model.addAttribute("totalPos",totalPos);
        model.addAttribute("totalNeg",totalNeg);
        return "index"; //Llamamos al HTML
    }

}
