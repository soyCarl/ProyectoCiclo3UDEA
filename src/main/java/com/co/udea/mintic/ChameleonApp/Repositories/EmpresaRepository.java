package com.co.udea.mintic.ChameleonApp.Repositories;

import com.co.udea.mintic.ChameleonApp.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
