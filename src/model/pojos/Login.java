/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojos;

/**
 * Clase base para poder pasar los parametros del login al mapper
 * @author Deklok
 */
public class Login {
    private String matricula;
    private String contrasena;

    public Login() {
    }

    public Login(String matricula, String contrasena) {
        this.matricula = matricula;
        this.contrasena = contrasena;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
