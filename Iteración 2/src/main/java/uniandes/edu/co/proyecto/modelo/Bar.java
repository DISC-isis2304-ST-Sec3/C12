package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="bares")

public class Bar {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private String estilo;


    // Constructor
    public Bar(Integer idservicio, String estilo)
    {
        this.idservicio = idservicio;
        this.estilo = estilo;
    }


    public Bar(){;}


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
