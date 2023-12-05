package uniandes.edu.co.proyecto.modelo;



public class Reservations {
   
    private String date;

    private String startHour;

    private String finishHour;



    public Reservations() {
        super();
    }

    public Reservations(String date, String startHour, String finishHour) {
        super();
        this.date = date;
        this.startHour = startHour;
        this.finishHour = finishHour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }

   

   
}
