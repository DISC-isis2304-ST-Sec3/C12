package uniandes.edu.co.proyecto.modelo;




public class RoomElement {


    private String name;

    private Integer cost;

    public RoomElement() {
        super();
    }


    public RoomElement(String name, Integer cost) {
        super();
        this.name = name;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
