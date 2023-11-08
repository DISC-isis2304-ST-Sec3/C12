package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tipos")

public class Tipo {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idtipo;

    private String tipo;
    private Integer capacidad;
    private String dotacion;


    // Constructor
    public Tipo(String tipo, Integer capacidad, String dotacion)
    {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.dotacion = dotacion;
    }


    public Tipo(){;}


    // Getters
    public Integer getIdtipo(){
        return idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public String getDotacion() {
        return dotacion;
    }


    // Setters
    public void setIdtipo(Integer idtipo){
        this.idtipo = idtipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }

}
