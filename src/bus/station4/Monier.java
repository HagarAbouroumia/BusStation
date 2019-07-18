/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Monier {

    Scene scene;
    Stage stage;
    SaveLists lists;
    LogicAuthentication logicAuthentication;
    ScenePassengerProfile passengerProfile;
    int i = 0;
    int k = 0;
    int count = 0;
    int countN2 = 0;
    int countP2 = 0;
    ArrayList<Trips> newlist;
    ArrayList<TripsForDrivers> newlistAdd;
    PassengerOptions passengerOptions;
    ManagerOptions managerOptions;

    public void setManagerOptions(ManagerOptions managerOptions) {
        this.managerOptions = managerOptions;
    }

    String OneWay = "One Way";
    String RoundTrip = "Round Trip";

    Label source = new Label();
    Label destination = new Label();
    Label date = new Label();
    Label time = new Label();
    Label seats = new Label();
    Label type = new Label();
    Label price = new Label();
    Label returnDate2 = new Label();
    Label returnTime2 = new Label();
    ComboBox comboBox = new ComboBox();
    ComboBox comboBox2 = new ComboBox();
    EventHandler<Event> eventHandler;

    public void prepareScene(SaveLists save) {
        lists = save;

        Label wsource = new Label("Source        ");
        Label wdestination = new Label("Destination       ");
        Label wdate = new Label("Date       ");
        Label wtime = new Label("Time       ");
        
        Label wType = new Label("Type Of Trip  ");

        Label label = new Label();
        Label finalPrice = new Label();

        Button next = new Button("next");
        Button prev = new Button("prev");

        Button book = new Button("Book");
        Button back = new Button("Back");
        comboBox.getItems().addAll("No Stop", "One Stop", "Many Stops");
        comboBox.setPromptText("Enter no.Stops");
        comboBox2.getItems().addAll("One Way", "Round Trip");
        comboBox2.setPromptText("Way");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(wsource, 0, 0);
        grid.add(wdestination, 1, 0);
        grid.add(wdate, 2, 0);
        grid.add(wtime, 3, 0);
        //grid.add(wseats, 4, 0);
        grid.add(wType, 5, 0);
        //  grid.add(wPrice, 6, 0);
        grid.add(source, 0, 1);
        grid.add(destination, 1, 1);
        grid.add(date, 2, 1);
        grid.add(time, 3, 1);
        // grid.add(seats, 4, 1);
        grid.add(type, 5, 1);


        grid.add(next, 0, 3);
        grid.add(prev, 9, 3);

        grid.add(book, 12, 1);
        grid.add(back, 12, 2);

        newlist = lists.getTrips();

        Trips trip = newlist.get(0);
        System.out.println(i); //cehck
        source.setText(trip.source);
        destination.setText(trip.destination);
        date.setText(trip.date);
        time.setText(trip.Time);
        // seats.setText(trip.seats);
        type.setText(trip.type);


        next.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = lists.getTrips();
                if (i >= newlist.size()) {
                    int j = newlist.size();
                    i = j - 2;
                }
                if (i < 0) {
                    i = 0;
                }

                ++i;

                if (i >= newlist.size()) {
                    i = newlist.size() - 1;
                    return;
                }

                Trips trip = newlist.get(i);
//            
                System.out.println(i); //cehck
                source.setText(trip.source);
                destination.setText(trip.destination);
                date.setText(trip.date);
                time.setText(trip.Time);
                //  seats.setText(trip.seats);
                type.setText(trip.type);
                //  price.setText(trip.price);

            }

        });
        prev.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = lists.getTrips();
                if (i >= newlist.size()) {
                    int j = newlist.size();
                    i = j - 1;
                }
                --i;
                if (i < 0) {
                    i = 0;
                    return;
                }

                Trips trip = newlist.get(i);
                System.out.println(i);
                source.setText(trip.source);
                destination.setText(trip.destination);
                date.setText(trip.date);
                time.setText(trip.Time);
                
                type.setText(trip.type);
                
            }

        });

        book.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                String n = "null";

                String value = "newTripMonier.txt";
                TripsForDrivers trips2 = new TripsForDrivers();

                Trips trip = newlist.get(i);
                //    Trips trip2 = newlist.get(k);
                trips2.setSource(trip.source);
                trips2.setDestination(trip.destination);
                trips2.setDate(trip.date);
                trips2.setTime(trip.Time);
                trips2.setType(trip.type);
            
                try {
                    lists.saveTrips3(trips2, value);

                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ScenePassengerProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
                newlist.remove(i);

            }

        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label.setText(" ");
                finalPrice.setText(" ");
                count = 0;
                countN2 = 0;
                countP2 = 0;
                stage.setScene(managerOptions.getScene()); 
            }

        });
        scene = new Scene(grid, 1700, 400);

    }

    public Scene getScene() {
        return scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLists(SaveLists lists) {
        this.lists = new SaveLists();
        this.lists = lists;
    }

    public void setPassengerOptions(PassengerOptions passengerOptions) {
        this.passengerOptions = passengerOptions;
    }

    public void setLogicAuthentication(LogicAuthentication logicAuthentication) {
        this.logicAuthentication = logicAuthentication;
    }

}
