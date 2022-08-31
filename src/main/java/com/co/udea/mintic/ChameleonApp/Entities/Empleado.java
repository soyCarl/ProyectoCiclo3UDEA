package com.co.udea.mintic.ChameleonApp.Entities;


public class Empleado {
    private Long id;
    private String nombreEmpleado;
    private String correoEmpleado;
    private String empresaEmpleado;
    private Enum_RoleName rolEmpleado;

    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String correoEmpleado, String empresaEmpleado, String rolEmpleado){
        this.nombreEmpleado=nombreEmpleado;
        this.correoEmpleado=correoEmpleado;
        this.empresaEmpleado=empresaEmpleado;
        this.rolEmpleado= Enum_RoleName.valueOf(rolEmpleado);
    }
    //Espacio para Getter y Setter


    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(String empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public Enum_RoleName getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_RoleName rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                '}';
    }
}
