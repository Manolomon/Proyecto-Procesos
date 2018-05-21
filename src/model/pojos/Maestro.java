package model.pojos;

/**
 *
 * @author Daniel Escamilla Cortes
 */
public class Maestro {
    private Integer idMaestro;
    private String usuario;
    private String contrasena;
    private String nombre;

    public Maestro() {
    }

    public Maestro(Integer idMaestro, String usuario, String contrasena, String nombre) {
        this.idMaestro = idMaestro;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public Integer getIdMaestro() {
        return idMaestro;
    }

    public void setIdMaestro(Integer idMaestro) {
        this.idMaestro = idMaestro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
