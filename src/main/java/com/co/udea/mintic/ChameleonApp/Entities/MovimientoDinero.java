package com.co.udea.mintic.ChameleonApp.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String concepto;
    private Float monto;
    @ManyToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Date fechaCreacion;
    private Date fechaActualizacion;

    public MovimientoDinero() {
    }

    public MovimientoDinero(Long id, String concepto, Float monto, Empleado empleado, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
