package com.co.udea.mintic.chameleonApp.controllers;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.services.EmpleadoServices;
import com.co.udea.mintic.chameleonApp.services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class controllerEmpleado {
    @Autowired
    EmpleadoServices empleadoServices;
    @Autowired
    EmpresaServices empresaServices;

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/VerEmpleados")
    public String verEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        List<Empleado> listaEmpleado = empleadoServices.getAllEmpleados();
        model.addAttribute("emplelist", listaEmpleado);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emplist",emprelist);
        System.out.println("entre al verEmpleado" + listaEmpleado + mensaje);
        return "verEmpleado"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpleado")
    public String addEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        Empleado emple = new Empleado();
        model.addAttribute("emple", emple);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emplist",emprelist);
        System.out.println("ingrese al agregrarEmpleado");
        return "agregarEmpleado";
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado emple, RedirectAttributes redirectAttributes){
        String passEncriptada = passwordEncoder().encode(emple.getContraseña());
        emple.setContraseña(passEncriptada);
        if(empleadoServices.saveOrUpdateEmpleado(emple)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            System.out.println("ingresado con exito");
            return "redirect:/VerEmpleados";
        }else{
            redirectAttributes.addFlashAttribute("mensaje","saveError");
            System.out.println("fallo ingreso");
            return "redirect:/AgregarEmpleado";
        }
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id, @ModelAttribute("mensaje") String mensaje) {
        Empleado emple = empleadoServices.getEmpleadoById(id);
        model.addAttribute("emple", emple);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emplist",emprelist);
        return "editarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(@ModelAttribute("emple") Empleado emple, RedirectAttributes redirectAttributes) {
        Long id=emple.getEmpleadoId();
        String oldPass = empleadoServices.getEmpleadoById(id).getContraseña();
        if(!emple.getContraseña().equals(oldPass)){
            String passEncrip = passwordEncoder().encode(emple.getContraseña());
            emple.setContraseña(passEncrip);
        }
        if (empleadoServices.saveOrUpdateEmpleado(emple)) {
            redirectAttributes.addFlashAttribute("mensaje", "updateOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateError");
        return "redirect:/EditarEmpleado/"+emple.getEmpleadoId();

    }

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (empleadoServices.deleteEmpleado(id)) {
            redirectAttributes.addFlashAttribute("mensaje", "deleteOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerEmpleados";
    }

    @RequestMapping("/AccesoDenegado")
    public String accesoDenegado(){
        return "accesoDenegado";
    }

    @RequestMapping("/AccessDenied")
    public String accessDenied(){
        return "accessDenied";
    }

    @RequestMapping("/Index")
    public String index(){
        return "index";
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/RegistrarEmpleado")
    public String addRegEmpleado(Model model, @ModelAttribute("mensaje") String mensaje) {
        Empleado emple = new Empleado();
        model.addAttribute("emple1", emple);
        model.addAttribute("mensaje", mensaje);
        List<Empresa> emprelist = empresaServices.getAllEmpresas();
        model.addAttribute("emplist",emprelist);
        System.out.println("ingrese al registrarEmpleado");
        return "registrarEmpleado";
    }

    @PostMapping("/GuardarRegistroEmpleado")
    public String guardarRegEmpleado(Empleado emple1){
        System.out.println("holi");
        String passEncriptada = passwordEncoder().encode(emple1.getContraseña());
        emple1.setContraseña(passEncriptada);
        if(empleadoServices.saveOrUpdateEmpleado(emple1)==true){
            System.out.println("ingresado con exito");
            return "redirect:/RegistrarEmpleado?exito";
        }else{
            System.out.println("fallo ingreso");
            return "redirect:/RegistrarEmpleado";
        }
    }

}