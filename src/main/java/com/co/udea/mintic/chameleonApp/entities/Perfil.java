package com.co.udea.mintic.chameleonApp.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//El id debe se tipo string y no autoincrementado
    @Column(name = "id_perfil")
    private Long perfilId;

    @Column(name = "imagen")
    private Blob imagen;

    @Column(name = "telefono")
    private String telefono;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaActualizacion;

    public Perfil() {

    }

    public Perfil(Long perfilId, Blob imagen, String telefono, Empleado empleado, Date fechaCreacion, Date fechaActualizacion) {
        this.perfilId = perfilId;
        this.imagen = imagen;
        this.telefono = telefono;
        this.empleado = empleado;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Long perfilId) {
        this.perfilId = perfilId;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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


    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + perfilId +
                ", imagen=" + imagen +
                ", telefono='" + telefono + '\'' +
                ", empleado=" + empleado +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }
}
