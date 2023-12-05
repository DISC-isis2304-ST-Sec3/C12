package uniandes.edu.co.proyecto.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document(collection = "Rooms")

public class Room {
    @Id
    private String id;

    private Integer numRoom;

    private Boolean disponibility;

    @DocumentReference
    private RoomType type;

    public Room() {
        super();
    }

    public Room(Boolean disponibility, Integer numRoom, RoomType roomTypes_idType) {
        super();
        this.numRoom=numRoom;
        this.disponibility = disponibility;
        type = roomTypes_idType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Integer getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(Integer numRoom) {
        this.numRoom = numRoom;
    }

    public Boolean getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(Boolean disponibility) {
        this.disponibility = disponibility;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType roomTypes_idType) {
        type = roomTypes_idType;
    }

}
