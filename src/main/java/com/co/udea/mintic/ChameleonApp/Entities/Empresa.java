package com.co.udea.mintic.ChameleonApp.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Empresa")
@Data public class Empresa {
    /* ------- Atributos ------- */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_empresa") private int empresaId;
    @Column(name = "nombre_empresa", unique = true) private String nombreEmpresa;
    @Column(name = "nit_empresa", unique = true) private String nitEmpresa;
    @Column(name = "teléfono_empresa") private String telefonoEmpresa;
    @Column(name = "dirección_empresa") private String direccionEmpresa;

    @OneToMany
    @JoinColumn(name = "empleado_id") private Empleado empleado;

    @OneToMany
    @JoinColumn(name = "MovimientoDinero_id") private MovimientoDinero movimientoDinero;
    @Column(name = "fecha_creación") private Date fechaCreacion;
    @Column(name = "fecha_actualización") private Date fechaActualizacion;
    /* ------- Atributos ------- */


    /* ------- Constructor ------- */
    public Empresa() {
    }
    public Empresa(int empresaId, String nombreEmpresa, String nitEmpresa, String telefonoEmpresa, String direccionEmpresa, Empleado empleado, MovimientoDinero movimientoDinero, Date fechaCreacion, Date fechaActualizacion) {
        this.empresaId = empresaId;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.empleado = empleado;
        this.movimientoDinero = movimientoDinero;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    /* ------- Constructor ------- */


    /* ------- Getters & Setters ------- */
//    public Long getEmpresaId() {
//        return empresaId;
//    }
//    public void setEmpresaId(Long empresaId) {
//        this.empresaId = empresaId;
//    }
//    public String getNombreEmpresa() {
//        return nombreEmpresa;
//    }
//    public void setNombreEmpresa(String nombreEmpresa) {
//        this.nombreEmpresa = nombreEmpresa;
//    }
//    public String getDireccionEmpresa() {
//        return direccionEmpresa;
//    }
//    public void setDireccionEmpresa(String direccionEmpresa) {
//        this.direccionEmpresa = direccionEmpresa;
//    }
//    public String getTelefonoEmpresa() {
//        return telefonoEmpresa;
//    }
//    public void setTelefonoEmpresa(String telefonoEmpresa) {
//        this.telefonoEmpresa = telefonoEmpresa;
//    }
//    public String getNitEmpresa() {
//        return nitEmpresa;
//    }
//    public void setNitEmpresa(String nitEmpresa) {
//        this.nitEmpresa = nitEmpresa;
//    }
//    public Empleado getEmpleado() {
//        return empleado;
//    }
//    public void setEmpleado(Empleado empleado) {
//        this.empleado = empleado;
//    }
//    public MovimientoDinero getMovimientoDinero() {
//        return movimientoDinero;
//    }
//    public void setMovimientoDinero(MovimientoDinero movimientoDinero) {
//        this.movimientoDinero = movimientoDinero;
//    }
//    public Date getFechaCreacion() {
//        return fechaCreacion;
//    }
//    public void setFechaCreacion(Date fechaCreacion) {
//        this.fechaCreacion = fechaCreacion;
//    }
//    public Date getFechaActualizacion() {
//        return fechaActualizacion;
//    }
//    public void setFechaActualizacion(Date fechaActualizacion) {
//        this.fechaActualizacion = fechaActualizacion;
//    }
    /* ------- Getters & Setters ------- */


}
