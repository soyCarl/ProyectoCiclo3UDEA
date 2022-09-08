package com.co.udea.mintic.chameleonApp.services;

import com.co.udea.mintic.chameleonApp.entities.MovimientoDinero;
import com.co.udea.mintic.chameleonApp.repositories.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientosServices {
    @Autowired
    MovimientosRepository movimientosRepository;

    public List<MovimientoDinero> getAllMovimientos() {
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        movimientosRepository.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Long id) {
        return movimientosRepository.findById(id).get();
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero) {
        MovimientoDinero mov = movimientosRepository.save(movimientoDinero);
        return mov;
    }
    public boolean deleteMovimiento(Long id) {
        movimientosRepository.deleteById(id);
        if (this.movimientosRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Long id) {
        return movimientosRepository.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Long id) {
        return movimientosRepository.findByEmpresa(id);
    }


}
