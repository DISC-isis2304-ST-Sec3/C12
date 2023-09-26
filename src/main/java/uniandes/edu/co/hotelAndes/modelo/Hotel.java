package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    private long nit;

    public Hotel(){;}

    public Hotel(long id, String nombre, long nit) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit=" + nit +
                '}';
    }
}
