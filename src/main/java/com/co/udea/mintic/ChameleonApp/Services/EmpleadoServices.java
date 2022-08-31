package com.co.udea.mintic.ChameleonApp.Services;


import com.co.udea.mintic.ChameleonApp.Entities.Empleado;
import com.co.udea.mintic.ChameleonApp.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServices {
    @Autowired(required=false) //conexion automatica de esta clase con el repository de Empleado
    EmpleadoRepository empleadoRepository; //objeto tipo EmpleadoRepository para poder usar los metodos que dicha clase hereda

    //Metodo que retornará la lista de empleados usando metodos heredados del jpaRepository
    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return empleadoList;
    }

    //Metodo que me trae un objeto de tipo Empleado cuando cuento con el id del mismo
    public Empleado getEmpleadoById(Integer id){
        return empleadoRepository.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empleado
    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        Empleado emple=empleadoRepository.save(empleado);
        return emple;
    }

    //Metodo para eliminar Empleados registradas teniendo el id
    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);  //Eliminar

        if (empleadoRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }
}
