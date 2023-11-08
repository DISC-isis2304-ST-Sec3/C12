package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="planes")

public class Plan {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idplan;

    private String tipoplan;
    private Float descuento;
    

    // Constructor
    public Plan(String tipoplan, Float descuento)
    {
        this.tipoplan = tipoplan;
        this.descuento = descuento;
    }


    public Plan(){;}


    // Getters
    public Integer getIdplan(){
        return idplan;
    }

    public String getTipoplan() {
        return tipoplan;
    }

    public Float getDescuento() {
        return descuento;
    }


    // Setters
    public void setIdplan(Integer idplan){
        this.idplan = idplan;
    }

    public void setTipoplan(String tipoplan) {
        this.tipoplan = tipoplan;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

}
