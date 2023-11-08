package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="alojamientos")

public class Alojamiento {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idalojamiento;

    private String activa;
    private Date checkin;
    private Date checkout;
    private Integer acompanantes;
    //FK-
    @ManyToOne
    @JoinColumn(name = "planes", referencedColumnName = "idplan")
    private Plan plan;


    // Constructor
    public Alojamiento(String activa, Date checkin, Date checkout, Integer acompanantes, Plan plan)
    {
        this.activa = activa;
        this.checkin = checkin;
        this.checkout = checkout;
        this.acompanantes = acompanantes;
        this.plan = plan;
    }


    public Alojamiento(){;}


    // Getters
    public Integer getIdalojamiento(){
        return idalojamiento;
    }

    public String getActiva() {
        return activa;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer getAcompanantes() {
        return acompanantes;
    }

    public Plan getPlan() {
        return plan;
    }

    // Setters
    public void setIdalojamiento(Integer idalojamiento){
        this.idalojamiento = idalojamiento;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public void setAcompanantes(Integer acompanantes) {
        this.acompanantes = acompanantes;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

}
