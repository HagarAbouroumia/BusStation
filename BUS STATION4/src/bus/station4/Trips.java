package bus.station4;

import java.io.Serializable;

public class Trips implements Serializable {// any class ill save its object ill use serializable 

    static final long serialVersionUID = -3187781949325173237L;
    String source;
    String destination;
    String date;
    String Time;
    String price; // seats
    String stops;
    String seats;
    String type;
    String returnDate;
    String returnTime;

    public Trips(String source, String destination, String date, String Time, String price, String stops, String seats, String type, String returnDate, String returnTime) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.Time = Time;
        this.price = price;
        this.stops = stops;
        this.seats = seats;
        this.type = type;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
    }

    public Trips() {
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

}
