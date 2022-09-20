package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import com.co.udea.mintic.chameleonApp.services.MovimientosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/")
public class controllerMovimientos {
    @Autowired
    MovimientosServices movimientosServices;

    @GetMapping("/VerMovimientos")
    public String verMovimientos(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<MovimientoDinero> listaMov = movimientosServices.getAllMovimientos();
        model.addAttribute("emplist", listaMov);
        model.addAttribute("mensaje", mensaje);
        return "verMovimientos"; //Llamamos al HTML
    }

    @PostMapping("/AgregarMovimientos")
    public String addMovimientos(Model model, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero mov = new MovimientoDinero();
        model.addAttribute("emp", mov);
        model.addAttribute("mensaje", mensaje);
        return "agregarMovimiento";
    }

    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero mov = movimientosServices.getMovimientoById(id);
        model.addAttribute("emp", mov);
        model.addAttribute("mensaje", mensaje);
        return "editarMovimientos";
    }

    @PostMapping("/ActualizarMovimientos")
    public String updateMovimiento(@ModelAttribute("emp") MovimientoDinero mov, RedirectAttributes redirectAttributes) {
        if (movimientosServices.saveOrUpdateMovimiento(mov)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarMovimiento";
    }

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (movimientosServices.deleteMovimiento(id) == true) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientos";
    }
}
