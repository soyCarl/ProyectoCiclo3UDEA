package com.co.udea.mintic.ChameleonApp.Services;

import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import com.co.udea.mintic.ChameleonApp.Repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpresaServices {
    @Autowired //Conectamos esta clase con el repository de Empresa
    EmpresaRepository empresaRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

        //Metodo que retornará la lista de empresas usando metodos heredados del jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return empresaList;
    }

        //Metodo que me trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }

        //Metodo para guardar o actualizar objetos de tipo Empresa
    public Empresa saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepository.save(empresa);
        return emp;
    }

        //Metodo para eliminar empresas registradas teniendo el id
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id);  //Eliminar

        if (empresaRepository.findById(id)!=null){  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }

}

