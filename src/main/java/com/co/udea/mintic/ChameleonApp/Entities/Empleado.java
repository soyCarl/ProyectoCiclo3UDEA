package com.co.udea.mintic.ChameleonApp.Entities;

public class Empleado {

    private String nombreEmpleado;
    private String correoEmpleado;
    private String empresaEmpleado;
    private String rolEmpleado;

    public Empleado(String nombreEmpleado, String correoEmpleado, String empresaEmpleado, String rolEmpleado){
        this.nombreEmpleado=nombreEmpleado;
        this.correoEmpleado=correoEmpleado;
        this.empresaEmpleado=empresaEmpleado;
        this.rolEmpleado=rolEmpleado;
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

    public String getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                '}';
    }
}
