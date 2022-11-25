package com.example.loginregistrer;

public class Incidente {

    String id;
    String direccion;
    String distrito;
    String descripcion;

    public Incidente(){

    }

    public Incidente(String id, String direccion, String distrito, String descripcion) {
        this.id = id;
        this.direccion = direccion;
        this.distrito = distrito;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}
