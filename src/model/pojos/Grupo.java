/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public Grupo() {
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