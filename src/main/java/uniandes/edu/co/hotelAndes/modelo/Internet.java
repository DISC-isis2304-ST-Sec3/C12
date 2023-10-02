package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "internet")
public class Internet extends Servicio {
    private int anchoBanda;

    public Internet(){;}

    public Internet(int anchoBanda) {
        super();
        this.anchoBanda = anchoBanda;
    }

    
    public int getAnchoBanda() {
        return anchoBanda;
    }

    public void setAnchoBanda(int anchoBanda) {
        this.anchoBanda = anchoBanda;
    }


    @Override
    public String toString() {
        return "Internet{" +
                "anchoBanda=" + anchoBanda +
                "} " + super.toString();
    }

}

