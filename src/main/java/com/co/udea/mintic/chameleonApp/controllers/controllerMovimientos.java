package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import com.co.udea.mintic.chameleonApp.services.EmpleadoServices;
import com.co.udea.mintic.chameleonApp.services.EmpresaServices;
import com.co.udea.mintic.chameleonApp.services.MovimientosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    EmpresaServices empresaServices;
    @Autowired
    EmpleadoServices empleadoServices;

    @GetMapping("/VerMovimientos")
    public String verMovimientos(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<MovimientoDinero> listaMov = movimientosServices.getAllMovimientos();
        model.addAttribute("listMov", listaMov);
        model.addAttribute("mensaje", mensaje);

        List<Empleado> empleList = empleadoServices.getAllEmpleados();
        model.addAttribute("emplist",empleList);
        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emprlist",emprelist);
        System.out.println("ingrese al agregrarEmpleado");
        return "verMovimientos"; //Llamamos al HTML
    }

    @GetMapping("/AgregarMovimientos")
    public String addMovimientos(Model model, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero mov = new MovimientoDinero();
        model.addAttribute("mov", mov);
        model.addAttribute("mensaje", mensaje);

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String correo=auth.getName();
        Long idEmpleado=movimientosServices.IdPorCorreo(correo);
        model.addAttribute("idEmpleado",idEmpleado);

        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emprlist",emprelist);
        return "agregarMovimiento";
    }

    @PostMapping("/GuardarMovimientos")
    public String guardarMovimientos(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientosServices.saveOrUpdateMovimientoRest(mov)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            System.out.println("ingresado con exito");
            return "redirect:/VerMovimientos";
        }else{
            redirectAttributes.addFlashAttribute("mensaje","saveError");
            System.out.println("fallo ingreso");
            return "redirect:/AgregarMovimientos";
        }
    }



    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero mov = movimientosServices.getMovimientoById(id);
        model.addAttribute("mov", mov);
        model.addAttribute("mensaje", mensaje);

        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String correo=auth.getName();

        Long idEmpleado=movimientosServices.IdPorCorreo(correo);
        model.addAttribute("idEmpleado",idEmpleado);

        List<Empleado> empleList = empleadoServices.getAllEmpleados();
        model.addAttribute("emplist",empleList);

        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emprlist",emprelist);

        return "editarMovimiento";
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
