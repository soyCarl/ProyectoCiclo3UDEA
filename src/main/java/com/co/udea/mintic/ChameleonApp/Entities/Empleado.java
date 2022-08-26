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


    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                '}';
    }
}
