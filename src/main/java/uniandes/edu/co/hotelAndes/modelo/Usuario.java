package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    private String nombre;

    private String tipoDocumento;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String numeroDocumento;

    private String rol;

    private String correo;


    public Usuario(){;}

    public Usuario(String nombre, String tipoDocumento, String numeroDocumento, String rol, String correo)
    {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.rol = rol;
        this.correo = correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String toString(){

        return this.nombre+"|"+this.tipoDocumento +"|"+this.numeroDocumento +"|"+this.rol+"|"+this.correo;
    }
}
