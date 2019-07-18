package bus.station4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScenePassengerProfile {

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
    ArrayList<TripOfPassenger> newlistAdd;
    PassengerOptions passengerOptions;
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
    ComboBox comboBox3 = new ComboBox();
    EventHandler<Event> eventHandler;

    public void prepareScene(SaveLists save) {
        lists = save;

        Label wsource = new Label("Source        ");
        Label wdestination = new Label("Destination       ");
        Label wdate = new Label("Date       ");
        Label wtime = new Label("Time       ");
        Label wseats = new Label("No. of Seats      ");
        Label wType = new Label("Type Of Trip  ");
        Label wPrice = new Label("Price    ");
        Label wReturnDate2 = new Label("Date    ");
        Label wReturnTime2 = new Label("Time    ");
        Label label = new Label();
        Label finalPrice = new Label();
        Label labe2 = new Label();
        Button next = new Button("next");
        Button prev = new Button("prev");
        Button next2 = new Button("next");
        Button prev2 = new Button("prev");
        Button book = new Button("Book");
        Button back = new Button("Back");
        comboBox.getItems().addAll("No Stop", "One Stop", "Many Stops");
        comboBox.setPromptText("Enter no.Stops");
        comboBox3.setPromptText("Type of Transportation");
        comboBox2.getItems().addAll("One Way", "Round Trip");
        comboBox3.getItems().addAll("Bus", "MiniBus","limousine");
        comboBox2.setPromptText("Way");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(wsource, 0, 0);
        grid.add(wdestination, 1, 0);
        grid.add(wdate, 2, 0);
        grid.add(wtime, 3, 0);
        grid.add(wseats, 4, 0);
        grid.add(wType, 5, 0);
        grid.add(wPrice, 6, 0);
        grid.add(source, 0, 1);
        grid.add(destination, 1, 1);
        grid.add(date, 2, 1);
        grid.add(time, 3, 1);
        grid.add(seats, 4, 1);
        grid.add(type, 5, 1);
        grid.add(price, 6, 1);
        grid.add(comboBox, 7, 0);
        grid.add(comboBox2, 9, 0);
        grid.add(comboBox3, 10, 0);
        grid.add(wReturnDate2, 0, 6);
        grid.add(wReturnTime2, 1, 6);
        grid.add(returnDate2, 0, 7);
        grid.add(returnTime2, 1, 7);
        grid.add(next, 0, 3);
        grid.add(prev, 9, 3);
        grid.add(next2, 0, 8);
        grid.add(prev2, 1, 8);
        grid.add(book, 12, 1);
        grid.add(back, 12, 2);
        grid.add(label, 12, 5);
        grid.add(labe2, 0, 5);
        grid.add(finalPrice, 12, 6);
        newlist = lists.getTrips();

        Trips trip = newlist.get(0);
        System.out.println(i); //cehck
        source.setText(trip.source);
        destination.setText(trip.destination);
        date.setText(trip.date);
        time.setText(trip.Time);
        seats.setText(trip.seats);
        type.setText(trip.type);
        price.setText(trip.price);
        labe2.setText("Returning Information");
        returnDate2.setText(trip.returnDate);
        returnTime2.setText(trip.returnTime);

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
                seats.setText(trip.seats);
                type.setText(trip.type);
                price.setText(trip.price);

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
                seats.setText(trip.seats);
                type.setText(trip.type);
                price.setText(trip.price);

            }

        });
        next2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                countN2++;
                newlist = lists.getTrips();
                if (k >= newlist.size()) {
                    int j = newlist.size();
                    k = j - 2;
                }
                if (k < 0) {
                    k = 0;
                }

                ++k;

                if (k >= newlist.size()) {
                    k = newlist.size() - 1;
                    return;
                }
                Trips trip = newlist.get(k);
                returnDate2.setText(trip.returnDate);
                returnTime2.setText(trip.returnTime);

            }

        });
        prev2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                countP2++;
                newlist = lists.getTrips();
                if (k >= newlist.size()) {
                    int j = newlist.size();
                    k = j - 1;
                }
                --k;
                if (k < 0) {
                    k = 0;
                    return;
                }

                Trips trip = newlist.get(k);
                returnDate2.setText(trip.returnDate);
                returnTime2.setText(trip.returnTime);

            }

        });
        book.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                String n = "null";
                if (count != 0) {
                    return;
                }

                boolean isMyComboBoxEmpty = comboBox.getSelectionModel().isEmpty();
                boolean isMyComboBox2Empty = comboBox2.getSelectionModel().isEmpty();
                boolean isMyComboBox3Empty = comboBox3.getSelectionModel().isEmpty();
                String stop = (String) comboBox.getValue();
                String way = (String) comboBox2.getValue();

                if (isMyComboBoxEmpty == true || isMyComboBox2Empty == true || isMyComboBox3Empty == true ) {
                    label.setText("Incomplete Info.");
                    count = 0;
                    return;
                }
                if (comboBox2.getValue().equals(OneWay)) {
                    if (countN2 > 0 || countP2 > 0) {
                        label.setText("Warning! You choose One Way Trip");
                        count = 0;
                        return;
                    }
                }
                if (comboBox2.getValue().equals(RoundTrip)) {
                    if (countN2 == 0 && countP2 == 0) {
                        label.setText("Warning! Choose The Returning Information");
                        count = 0;
                        return;
                    }
                }
                String value = "AddPassengerFile.txt";
                TripOfPassenger trips2 = new TripOfPassenger();

                Trips trip = newlist.get(i);
                Trips trip2 = newlist.get(k);
                trips2.setSource(trip.source);
                trips2.setDestination(trip.destination);
                trips2.setDate(trip.date);
                trips2.setTime(trip.Time);
                trips2.setType(trip.type);
                String take = logicAuthentication.checkPrice(stop, newlist.get(i));
                trips2.setStops((String) comboBox.getValue());
                trips2.setWay((String) comboBox2.getValue());
                trips2.setTransportation((String) comboBox3.getValue());
                if (comboBox2.getValue().equals(RoundTrip)) {
                    trips2.setReturnDate(trip2.returnDate);
                    trips2.setReturnTime(trip2.returnTime);
                    trips2.setPrice(logicAuthentication.checkPriceForWay(way, take));
                } else {
                    trips2.setPrice(logicAuthentication.checkPrice(stop, newlist.get(i)));
                }
                try {
                    lists.saveTrips2(trips2, value);

                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ScenePassengerProfile.class.getName()).log(Level.SEVERE, null, ex);
                }

                //   System.out.println(logicAuthentication.checkPrice(stop, newlist.get(i)));
//                logicAuthentication.checkPrice(stop, newlist.get(i));
                label.setText("Your Trips has been saved , you can Edit your trip from the View Trip Icon");
                finalPrice.setText("Total Amount to paid " + trips2.price);
                count++;
                //  stage.setScene(passengerView.getScene()); // will go to the menu
            }

        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label.setText(" ");
                finalPrice.setText(" ");
                count = 0;
                countN2 = 0;
                countP2 = 0;
                stage.setScene(passengerOptions.getScene()); // will go to the menu
            }

        });
        scene = new Scene(grid, 1700, 400);

    }

//    public void p() {
//        System.out.println(i);
//    }
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
