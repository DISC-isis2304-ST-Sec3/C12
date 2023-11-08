package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;


@Entity
@Table(name="conferencias")

public class Conferencia {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private Integer capacidad;
    private Date fecha;
    private Time hora;
    private Integer duracion;


    // Constructor
    public Conferencia(Integer idservicio,Integer capacidad, Date fecha, Time hora, Integer duracion)
    {
        this.idservicio = idservicio;
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }


    public Conferencia(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public Integer getDuracion() {
        return duracion;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

}
