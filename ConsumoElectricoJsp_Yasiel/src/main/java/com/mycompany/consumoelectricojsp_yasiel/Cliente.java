package com.mycompany.consumoelectricojsp_yasiel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author yasie
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private String nombreCalle;
    private Integer numero;
    private Integer codPostal;
    private String poblacion;
    private String provincia;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String apellido, String nombreCalle, Integer numero, Integer codPostal, String poblacion, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.codPostal = codPostal;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
