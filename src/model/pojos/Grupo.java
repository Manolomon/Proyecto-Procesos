/*
 * Grupo.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

package model.pojos;

/**
 *
 * @author Deklok
 */
public class Grupo {
    private Integer idGrupo;
    private Integer cupo;
    private Integer alumnos;
    private Integer idCurso;

    public Grupo(Integer idGrupo, Integer cupo, Integer alumnos, Integer idCurso) {
        this.idGrupo = idGrupo;
        this.cupo = cupo;
        this.alumnos = alumnos;
        this.idCurso = idCurso;
    }

    public Grupo(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Integer alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
