package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Products")
public class Product {
    @Id
    private String id;

    private String name;

    private Integer cost;

    private String type;

   
    public Product() {
        super();
    }

    public Product(String name, Integer cost, String type, Service services_idService) {
        super();
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id_product) {
        this.id = id_product;
    }

    

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

}
