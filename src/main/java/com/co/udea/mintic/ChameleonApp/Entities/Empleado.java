package com.co.udea.mintic.ChameleonApp.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correoEmpleado;
    @OneToOne
    @JoinColumn(name = "perfil_id")
    @Column(name = "perfil")
    private Perfil perfil;
    @Column(name = "rol_empleado")
    private Enum_RoleName rolEmpleado;
    @ManyToOne
    @JoinColumn(name = "empresa_empresa_id")
    private Empresa empresa;
    @Column(name = "movimiento")
    private List<MovimientoDinero> movDinero = new ArrayList<>();
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    public Empleado() {

    }

    public Empleado(int id, String nombre, String correoEmpleado, Perfil perfil, Enum_RoleName rolEmpleado, Empresa empresa, List<MovimientoDinero> movDinero, Date fechaCreacion, Date fechaModificacion) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
