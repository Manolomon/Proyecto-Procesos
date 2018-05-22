package model.pojos;
/**
 * Pago.java
 *
 * Copyright (c) 2018, Royal Mango Developers
 * All rights reserved.
 */

/**
 * @author Author
 * @since Tue May 22 2018
 * @version 0.1
 */

public class Pago {
    private Integer idPago;
    private String informacionDePago;
    private String estado;
    private Integer idUsuario;
    private Integer idGrupo;

    public Pago(String informacionDePago, String estado, Integer idUsuario, Integer idGrupo) {
        this.informacionDePago = informacionDePago;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idGrupo = idGrupo;
    }

    public Pago() {
    }

    public Pago(Integer idPago, String informacionDePago, String estado, Integer idUsuario, Integer idGrupo) {
        this.idPago = idPago;
        this.informacionDePago = informacionDePago;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idGrupo = idGrupo;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getInformacionDePago() {
        return informacionDePago;
    }

    public void setInformacionDePago(String informacionDePago) {
        this.informacionDePago = informacionDePago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    
}