package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="piscinas")

public class Piscina {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private Integer capacidad;
    private Float profundidad;


    // Constructor
    public Piscina(Integer idservicio, Integer capacidad, Float profundidad)
    {
        this.idservicio = idservicio;
        this.capacidad = capacidad;
        this.profundidad = profundidad;
    }


    public Piscina(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Float getProfundidad() {
        return profundidad;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

}
