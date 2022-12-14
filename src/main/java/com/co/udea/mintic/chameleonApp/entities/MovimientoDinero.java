package com.co.udea.mintic.chameleonApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movimiento_dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento_dinero")
    private Long movDineroId;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "monto")
    private Float monto;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaActualizacion;

    public MovimientoDinero() {
    }

    public MovimientoDinero(Long movDineroId, String concepto, Float monto, Empleado empleado, Empresa empresa, Date fechaCreacion, Date fechaActualizacion) {
        this.movDineroId = movDineroId;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getMovDineroId() {
        return movDineroId;
    }

    public void setMovDineroId(Long movDineroId) {
        this.movDineroId = movDineroId;
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

    //@JsonBackReference
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    //@JsonBackReference
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
