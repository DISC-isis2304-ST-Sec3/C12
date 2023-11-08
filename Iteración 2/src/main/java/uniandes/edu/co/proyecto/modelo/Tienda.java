package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="tiendas")

public class Tienda {

    // Atributos
    @Id //PK
    private Integer idservicio;

    private String tipo;
    

    // Constructor
    public Tienda(Integer idservicio, String tipo)
    {
        this.idservicio = idservicio;
        this.tipo = tipo;
    }


    public Tienda(){;}


    // Getters
    public Integer getIdservicio(){
        return idservicio;
    }

    public String getTipo()
    {
        return this.tipo;
    }


    // Setters
    public void setIdservicio(Integer idservicio)
    {
        this.idservicio = idservicio;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

}
