package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")

public class Reserva {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idreserva;

    private Date horareserva;
    //FK
    @ManyToOne
    @JoinColumn(name = "cuentas", referencedColumnName = "idcuenta")
    private Cuenta cuenta;


    // Constructor
    public Reserva(Date horareserva, Cuenta cuenta)
    {
        this.horareserva = horareserva;
        this.cuenta = cuenta;
    }


    public Reserva(){;}


    // Getters
    public Integer getIdreserva(){
        return idreserva;
    }

    public Date getHorareserva() {
        return horareserva;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }


    // Setters
    public void setIdreserva(Integer idreserva){
        this.idreserva = idreserva;
    }
    
    public void setHorareserva(Date horareserva) {
        this.horareserva = horareserva;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
