package com.co.udea.mintic.chameleonApp.repositories;

import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientosRepository extends JpaRepository<MovimientoDinero, Long> {

    //Metodo para filtrar movimientos por empleado
    @Query(value = "select * from movimiento_dinero where id_empleado= ?", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Long id);

    //Metodo para filtrar movimientos por empresa
    @Query(value = "select * from movimiento_dinero where id_empresa= ?", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Long id);

}
