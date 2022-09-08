package com.co.udea.mintic.chameleonApp.repositories;

import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientosRepository extends JpaRepository<MovimientoDinero, Long> {

    //Metodo para filtrar movimientos por empleado
    @Query(value = "select * from movimientos where empleado_id= ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Long id);

    //Metodo para filtrar movimientos por empresa
    @Query(value = "select * from movimientos where empleado_id in (select id from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Long id);

}
