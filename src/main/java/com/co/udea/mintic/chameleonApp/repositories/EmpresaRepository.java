package com.co.udea.mintic.chameleonApp.repositories;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    //Metodo para contar TODAS LOS EMPRESAS
    @Query(value="select count(*) from empresa", nativeQuery = true)
    public abstract int CantEmpresas();
}
