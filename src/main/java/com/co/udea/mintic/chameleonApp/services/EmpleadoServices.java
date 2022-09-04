package com.co.udea.mintic.chameleonApp.services;


import com.co.udea.mintic.chameleonApp.entities.Empleado;
import com.co.udea.mintic.chameleonApp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServices {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    public Empleado getEmpleadoById(Long id){
        return empleadoRepository.findById(id).get();
    }

    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        Empleado emple=empleadoRepository.save(empleado);
        return emple;
    }

    public boolean deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
        if (empleadoRepository.findById(id)!=null){
            return true;
        }
        return false;
    }
}
