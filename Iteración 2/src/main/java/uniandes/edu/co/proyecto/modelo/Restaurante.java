package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="restaurantes")

public class Restaurante extends Servicio{

    // Atributos
    @Id //PK
    private Integer idservicio;

    private String estilo;


    // Constructor
    public Restaurante(Integer idservicio, String estilo)
    {
        this.idservicio = idservicio;
        this.estilo = estilo;
    }


    public Restaurante(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public String getEstilo()
    {
        return this.estilo;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }
    
}
