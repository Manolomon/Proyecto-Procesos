/*
 * Curso.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package model.pojos;

import java.sql.Date;

/**
 *
 * @author Daniel Escamilla Cortés
 */
public class Curso {
    private Integer idCurso;
    private String nombre;
    private Integer idCategoria;
    private Double precio;
    private Date fechaInicio;
    private Date fechaFin;
    private String imagen;

    public Curso() {
    }

    public Curso(Integer idCurso, String nombre, Integer idCategoria, Double precio, Date fechaInicio, Date fechaFin, String imagen) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imagen = imagen;
    }
        
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCategoria() {
        return idCategoria;
    }

    public void setCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
