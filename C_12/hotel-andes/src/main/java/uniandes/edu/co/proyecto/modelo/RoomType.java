package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "RoomTypes")
public class RoomType {
    
    @Id
    private String id;

    private String name;

    private Integer capacity;

    private Integer priceNight;

    private List<RoomElement> roomElements;

    public RoomType() {
        super();
    }

    public RoomType(String name, Integer capacity, Integer priceNight, List<RoomElement> roomElements) {
        super();
        this.name = name;
        this.capacity = capacity;
        this.priceNight = priceNight;
        this.roomElements = roomElements;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(Integer priceNight) {
        this.priceNight = priceNight;
    }

    public List<RoomElement> getRoomElements() {
        return roomElements;
    }

    public void setRoomElements(List<RoomElement> roomElements) {
        this.roomElements = roomElements;
    }

    

   
}
