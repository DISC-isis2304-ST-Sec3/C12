package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection="Services")
public class Service {
    @Id
    private String id;

    private String name;

    private String schedule;

    private Integer capacity;

    private String type;

    @DocumentReference
    private List<Product> products;

    private List<Reservations> reservations;


    public Service(String name, String schedule, Integer capacity, String type, List<Product> products,
            List<Reservations> reservations) {
        super();
        this.name = name;
        this.schedule = schedule;
        this.capacity = capacity;
        this.type = type;
        this.products = products;
        this.reservations = reservations;
    }


    public Service() {
        super();
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSchedule() {
        return schedule;
    }


    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }


    public Integer getCapacity() {
        return capacity;
    }


    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public List<Product> getProducts() {
        return products;
    }


    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public List<Reservations> getReservations() {
        return reservations;
    }


    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    
   
}
