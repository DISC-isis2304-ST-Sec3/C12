package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="spas")

public class Spa {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private Integer capacidad;


    // Constructor
    public Spa(Integer idservicio, Integer capacidad)
    {
        this.idservicio = idservicio;
        this.capacidad = capacidad;
    }


    public Spa(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

}
