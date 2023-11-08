package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="gimnasios")

public class Gimnasio{

    // Atributos
    @Id //PK
    private Integer idservicio;

    private Integer capacidad;
    private String maquinas;


    // Constructor
    public Gimnasio(Integer idservicio, Integer capacidad, String maquinas)
    {
        this.idservicio = idservicio;
        this.capacidad = capacidad;
        this.maquinas = maquinas;
    }


    public Gimnasio(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public String getMaquinas() {
        return maquinas;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }

}
