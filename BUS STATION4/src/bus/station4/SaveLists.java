/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class SaveLists {

    SceneTwoManager manager;
    ScenePassengerProfile ScenePassengerProfile;

    ArrayList<Trips> trips = new ArrayList<Trips>(); // the name of the class to know what to store 
    ArrayList<TripOfPassenger> tripOfPassengers = new ArrayList<TripOfPassenger>(); // the name of the class to know what to store 
    ArrayList<TripsForDrivers> drivers = new ArrayList<>();

    public ScenePassengerProfile getScenePassengerProfile() {
        return ScenePassengerProfile;
    }

    public ArrayList<TripsForDrivers> getDrivers() {
        return drivers;
    }

    public ArrayList<Trips> getTrips() { // to use this list in another class
        return trips;
    }

    public ArrayList<TripOfPassenger> getTripOfPassengers() {
        return tripOfPassengers;
    }

    public void saveTrips(Trips t) throws FileNotFoundException, IOException, ClassNotFoundException {
        //trips.clear();

        trips.add(t);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("newTrips.txt")); // opens the file to save in it 

        int size = trips.size(); // to know the size of the arraylsit 
        int i = 0;
        while (i < size) { // saves in file 

            Trips a = trips.get(i); // gets the trips in index i and put in a
            out.writeObject(a); // write in file 

            i++;
        }
    }

    public void saveTrips2(TripOfPassenger t, String Filename) throws FileNotFoundException, IOException, ClassNotFoundException {

        tripOfPassengers.clear();
        tripOfPassengers.add(t);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Filename));

        int size = tripOfPassengers.size();
        int i = 0;
        while (i < size) {

            TripOfPassenger a = tripOfPassengers.get(i);

            out.writeObject(a);

            i++;

        }
        // load2();
        out.close();
        check2();

    }

    public void saveTrips3(TripsForDrivers t, String Filename) throws FileNotFoundException, IOException, ClassNotFoundException {

        //drivers.clear();
        drivers.add(t);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Filename));

        int size = drivers.size();
        int i = 0;
        while (i < size) {

            TripsForDrivers a = drivers.get(i);

            out.writeObject(a);

            i++;

        }
       //loadMonier();
        out.close();
        check3();

    }

    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("newTrips.txt"));
        while (true) {
            int i = 0;
            try {
                trips.add((Trips) in.readObject());

            } catch (java.io.EOFException eofe) {
                break;
            }

        }
        // check();

    }

    public void load2() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("AddPassengerFile.txt"));
        while (true) {
            int i = 0;
            try {
                tripOfPassengers.add((TripOfPassenger) in.readObject());

            } catch (java.io.EOFException eofe) {
                break;
            }

        }
        // check2();

    }
    public void load3() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("newTripMonier.txt"));
        while (true) {
            int i = 0;
            try {
                drivers.add((TripsForDrivers) in.readObject());

            } catch (java.io.EOFException eofe) {
                break;
            }

        }
        // check2();

    }

  

    public void check() {
        int i = 0;
        int s = trips.size();
        System.out.println(trips.size());
        while (i < s) {
            System.out.println(trips.get(i).source);
            System.out.println(trips.get(i).destination);
            System.out.println(trips.get(i).date);
            System.out.println(trips.get(i).Time);
            System.out.println(trips.get(i).price);
            System.out.println(trips.get(i).returnDate);
            System.out.println(trips.get(i).returnTime);
            i++;

        }
    }

    public void check2() {
        int i = 0;
        int s = tripOfPassengers.size();
        System.out.println(tripOfPassengers.size());
        while (i < s) {
            System.out.println(tripOfPassengers.get(i).source);
            System.out.println(tripOfPassengers.get(i).destination);
            System.out.println(tripOfPassengers.get(i).date);
            System.out.println(tripOfPassengers.get(i).Time);
            System.out.println(tripOfPassengers.get(i).stops);
            System.out.println(tripOfPassengers.get(i).price);
            i++;

        }

    }

    public void check3() {
        int i = 0;
        int s = drivers.size();
        System.out.println(drivers.size());
        while (i < s) {
            System.out.println(drivers.get(i).source);
            System.out.println(drivers.get(i).destination);
            System.out.println(drivers.get(i).date);
            System.out.println(drivers.get(i).Time);
            System.out.println(drivers.get(i).type);

            i++;

        }

    }
}
