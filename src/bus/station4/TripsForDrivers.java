/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class TripsForDrivers implements Serializable {

    String source;
    String destination;
    String date;
    String Time;
    String type;

    public TripsForDrivers(String source, String destination, String date, String Time, String type) {
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.Time = Time;
        this.type = type;
    }

    public TripsForDrivers() {
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

    public void setType(String type) {
        this.type = type;
    }

}
