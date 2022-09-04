package com.co.udea.mintic.chameleonApp.services;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import com.co.udea.mintic.chameleonApp.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaServices {
    @Autowired
    EmpresaRepository empresaRepository;


    public List<Empresa> getAllEmpresas() {
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id).get();
    }

    public Empresa saveOrUpdateEmpresa(Empresa empresa) {
        Empresa emp = empresaRepository.save(empresa);
        return emp;
    }

    public boolean deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);  //Eliminar
        if (empresaRepository.findById(id) != null) {  //Verificacion del servicio eliminacion
            return true;
        }
        return false;
    }

}

