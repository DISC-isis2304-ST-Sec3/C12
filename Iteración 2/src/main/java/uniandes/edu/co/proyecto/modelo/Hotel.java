package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")

public class Hotel {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhotel;

    private String nombrehotel;
    private Integer nithotel;


    // Constructor
    public Hotel(String nombrehotel, Integer nithotel)
    {
        this.nombrehotel = nombrehotel;
        this.nithotel = nithotel;
    }


    public Hotel(){;}


    // Getters
    public Integer getIdhotel(){
        return idhotel;
    }

    public String getNombrehotel() {
        return nombrehotel;
    }

    public Integer getNithotel() {
        return nithotel;
    }


    // Setters
    public void setIdhotel(Integer idhotel){
        this.idhotel = idhotel;
    }

    public void setNombrehotel(String nombrehotel) {
        this.nombrehotel = nombrehotel;
    }

    public void setNithotel(Integer nithotel) {
        this.nithotel = nithotel;
    }



    /*@Override
    public String toString() {
        return "Hotel{" +
                "idhotel=" + idhotel +
                ", nombrehotel='" + nombrehotel + '\'' +
                ", nithotel='" + nithotel + '\'' +
                // Imprime aquí cualquier otro campo que quieras mostrar
                '}';
        }*/

}
