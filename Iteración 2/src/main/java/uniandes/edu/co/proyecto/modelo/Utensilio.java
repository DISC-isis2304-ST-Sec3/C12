package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="utensilios")

public class Utensilio {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private String devuelto;
    private String estado;


    // Constructor
    public Utensilio(Integer idservicio, String devuelto, String estado)
    {
        this.idservicio = idservicio;
        this.devuelto = devuelto;
        this.estado = estado;
    }


    public Utensilio(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public String getDevuelto()
    {
        return this.devuelto;
    }

    public String getEstado()
    {
        return this.estado;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setDevuelto(String devuelto)
    {
        this.devuelto = devuelto;
    }

    public void setEstado(String estado)
    {
        this.estado = estado;
    }

}
