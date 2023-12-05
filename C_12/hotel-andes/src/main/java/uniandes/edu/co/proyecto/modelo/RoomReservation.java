package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "RoomsReservations")
public class RoomReservation {
    @Id
    private String id;

    private String entryDate;

    private String departureDate;

    private Integer numPeople;

    private Boolean checkIn;

    private Boolean checkOut;

    @DocumentReference
    private Room room;

    @DocumentReference
    private User user;

    @DocumentReference
    private List<Consumption> consumptions;



    public RoomReservation() {
        super();
    }

      public RoomReservation(String entryDate, String departureDate, Integer numPeople, Boolean checkIn, Boolean checkOut,
            Room room, User user, List<Consumption> consumptions) {
        super();
        this.entryDate = entryDate;
        this.departureDate = departureDate;
        this.numPeople = numPeople;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.room = room;
        this.user = user;
        this.consumptions = consumptions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(Integer numPeople) {
        this.numPeople = numPeople;
    }

    public Boolean getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Boolean checkIn) {
        this.checkIn = checkIn;
    }

    public Boolean getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
    }

    public Room getRoom() {
        return room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }


    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }


    

}
