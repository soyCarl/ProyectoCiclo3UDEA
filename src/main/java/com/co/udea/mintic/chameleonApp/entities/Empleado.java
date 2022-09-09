package com.co.udea.mintic.chameleonApp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo", unique = true)
    private String correoEmpleado;

    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol_empleado")
    private Enum_RoleName rolEmpleado;

    @ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private Empresa empresa;

    @OneToMany (targetEntity = MovimientoDinero.class)
    private List<MovimientoDinero> movDinero = new ArrayList<>();

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    public Empleado() {

    }

    public Empleado(Long id, String nombre, String correoEmpleado, Perfil perfil, Enum_RoleName rolEmpleado, Empresa empresa, List<MovimientoDinero> movDinero, Date fechaCreacion, Date fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.correoEmpleado = correoEmpleado;
        this.perfil = perfil;
        this.rolEmpleado = rolEmpleado;
        this.empresa = empresa;
        this.movDinero = movDinero;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Enum_RoleName getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_RoleName rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getMovDinero() {
        return movDinero;
    }

    public void setMovDinero(List<MovimientoDinero> movDinero) {
        this.movDinero = movDinero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", perfil=" + perfil +
                ", rolEmpleado=" + rolEmpleado +
                ", empresa=" + empresa +
                ", movDinero=" + movDinero +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }


}
