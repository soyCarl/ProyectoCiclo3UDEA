package com.co.udea.mintic.ChameleonApp.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Empresa {
    /* ------- Atributos ------- */

    private String nombreEmpresa;
    private String direccionEmpresa;
    private String telefonoEmpresa;
    private String nitEmpresa;
    /* ------- Atributos ------- */


    /* ------- Constructor ------- */
    public Empresa() {
    }
    public Empresa(String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, String nitEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.nitEmpresa = nitEmpresa;
    }
    /* ------- Constructor ------- */


    /* ------- Getters & Setters ------- */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
    public String getNitEmpresa() {
        return nitEmpresa;
    }
    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }
    /* ------- Getters & Setters ------- */


}
