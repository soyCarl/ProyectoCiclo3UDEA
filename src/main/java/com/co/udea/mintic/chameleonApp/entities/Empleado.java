package com.co.udea.mintic.chameleonApp.entities;

import com.fasterxml.jackson.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long empleadoId;

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

    @Column(name = "password")
    private String contraseña;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @JsonIgnore
    @OneToMany (mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<MovimientoDinero> movDinero;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaModificacion;

    public Empleado() {

    }

    public Empleado(Long empleadoId, String nombre, String correoEmpleado, Perfil perfil, Enum_RoleName rolEmpleado, String contraseña, Boolean estado, Empresa empresa, List<MovimientoDinero> movDinero, Date fechaCreacion, Date fechaModificacion) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.correoEmpleado = correoEmpleado;
        this.perfil = perfil;
        this.rolEmpleado = rolEmpleado;
        this.contraseña = contraseña;
        this.estado = estado;
        this.empresa = empresa;
        this.movDinero = movDinero;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
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

    public Long getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(Long empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
