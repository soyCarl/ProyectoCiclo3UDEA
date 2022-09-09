package com.co.udea.mintic.chameleonApp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="movimiento_dinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento_dinero")
    private Long id;

    @Column(name = "concepto")
    private String concepto;

    @Column(name = "monto")
    private Float monto;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private Empresa empresa;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    public MovimientoDinero() {
    }

    public MovimientoDinero(Long id, String concepto, Float monto, Empleado empleado, Empresa empresa, Date fechaCreacion, Date fechaActualizacion) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
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

    @Override
    public String toString() {
           return "MovimientoDinero{" +
                "id=" + id +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
