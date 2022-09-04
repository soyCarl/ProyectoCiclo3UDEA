package com.co.udea.mintic.chameleonApp.repositories;

import com.co.udea.mintic.chameleonApp.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
