package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class controllerEmpleado {
    @Autowired
    EmpleadoServices empleadoServices;

    @GetMapping("/VerEmpleado")
    public String verEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> listaEmpleado = empleadoServices.getAllEmpleados();
        model.addAttribute("emplist", listaEmpleado);
        model.addAttribute("mensaje", mensaje);
        return "verEmpleado"; //Llamamos al HTML
    }

    @PostMapping("/AgregarEmpleado")
    public String addEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        Empleado emple = new Empleado();
        model.addAttribute("emp", emple);
        model.addAttribute("mensaje", mensaje);
        return "agregarEmpleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        Empleado emple = empleadoServices.getEmpleadoById(id);
        model.addAttribute("emple", emple);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("emp") Empleado emple, RedirectAttributes redirectAttributes) {
        if (empleadoServices.saveOrUpdateEmpleado(emple)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpleado";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarEmpleado";

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (empleadoServices.deleteEmpleado(id) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerEmpleado";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleado";
    }

}
