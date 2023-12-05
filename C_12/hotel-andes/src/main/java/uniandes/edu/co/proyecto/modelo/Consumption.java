package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Consumptions")
public class Consumption {
    @Id
    private String id;

    private Integer cost;

    private String date;

    @DocumentReference
    private List<Product> products;

    public Consumption() {
        super();
    }

    public Consumption(Integer cost, String date, List<Product> product) {
        super();
        this.cost = cost;
        this.date = date;
        this.products = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> product) {
        this.products = product;
    }

}
