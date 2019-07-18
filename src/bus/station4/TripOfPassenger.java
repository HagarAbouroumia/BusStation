package bus.station4;

import java.io.Serializable;

public class TripOfPassenger implements Serializable {// any class ill save its object ill use serializable 

    static final long serialVersionUID = -6817142998821502872L;
    String source;
    String destination;
    String date;
    String Time;
    String price;
    String Type;
    String stops;
    String way;
    String returnDate;
    String returnTime;
    String transportation;

    public TripOfPassenger(String source, String destination, String date, String Time, String price, String Type, String stops, String way, String returnDate, String returnTime, String transportation) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.Time = Time;
        this.price = price;
        this.Type = Type;
        this.stops = stops;
        this.way = way;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.transportation = transportation;
    }

    public TripOfPassenger() {
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

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

}
