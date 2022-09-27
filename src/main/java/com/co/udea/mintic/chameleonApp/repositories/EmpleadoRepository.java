package com.co.udea.mintic.chameleonApp.repositories;

import com.co.udea.mintic.chameleonApp.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    //Metodo para contar TODOS LOS EMPLEADOS
    @Query(value="select count(*) from empleado", nativeQuery = true)
    public abstract int CantEmpleados();

}
