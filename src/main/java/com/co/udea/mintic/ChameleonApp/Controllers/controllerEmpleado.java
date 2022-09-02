package com.co.udea.mintic.ChameleonApp.Controllers;

import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import com.co.udea.mintic.ChameleonApp.Entities.Perfil;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

import static com.co.udea.mintic.ChameleonApp.Entities.Enum_RoleName.ADMIN;

@RestController
@RequestMapping("/")
public class controllerEmpleado {

    @GetMapping("/empleado")
    public Empleado verEmpleado() {
        Empleado empley = new Empleado(1, "Diego", "empleado@gmail", new Perfil(), ADMIN, new Empresa(), new ArrayList<>(), new Date(), new Date());
        return empley;
    }

    @PostMapping("/empleado")
    public String guardarEmpleado() {
        return "Guardar Empleado";
    }

    @GetMapping(path = "empleado/{id}")
    public String empleadoPorID(@PathVariable("id") Integer id) {
        return "Hola empleado " + id;
    }

    @PatchMapping(path = "empleado/{id}")
    public String actualizarEmpleado(@PathVariable("id") Integer id) {
        return "empleado " + id + " modifcado";
    }

    @DeleteMapping(path = "empleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") Integer id) {
        return "empleado " + id + " eliminado";
    }
}
