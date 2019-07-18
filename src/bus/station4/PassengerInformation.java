package bus.station4;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PassengerInformation {

    Scene scene;
    Stage stage;
    ArrayList<TripOfPassenger> newlist;
    SaveLists list;
    TripOfPassenger tripOfPassenger;
    PassengerOptions passengerOptions;
    PassengerInformation information;
    Label source = new Label();
    Label destination = new Label();
    Label date = new Label();
    Label time = new Label();
    Label type = new Label();
    Label way = new Label();
    Label price = new Label();
    Label rDtae = new Label();
    Label rTime = new Label();
    Label title = new Label();
    Label tran = new Label();

    Button cancel = new Button("Cancel Your Trip");
    Button back = new Button("Back");
    String l = "limousine";

    public void prepareScene(SaveLists save) {
        list = save;

        newlist = list.getTripOfPassengers();
        Label wType = new Label("Type Of Trip     :");
        Label wsource = new Label("Source           :");
        Label wdestination = new Label("Destination      :");
        Label wdate = new Label("Date             :");
        Label wtime = new Label("Time             :");
        Label wWay = new Label("Way            :");
        Label wrDate = new Label("returning Date   :");
        Label wrTime = new Label("returning Time   :");
        Label wPrice = new Label("Price            :");
        Label wtran = new Label("Transportation   :");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(title, 5, 0);
        grid.add(wType, 0, 1);
        grid.add(wsource, 0, 2);
        grid.add(wdestination, 0, 3);
        grid.add(wdate, 0, 4);
        grid.add(wtime, 0, 5);
        grid.add(wWay, 0, 6);
        grid.add(wrDate, 0, 7);
        grid.add(wrTime, 0, 8);
        grid.add(wPrice, 0, 9);
        grid.add(wtran, 0, 10);
        grid.add(type, 1, 1);
        grid.add(source, 1, 2);
        grid.add(destination, 1, 3);
        grid.add(date, 1, 4);
        grid.add(time, 1, 5);
        grid.add(way, 1, 6);
        grid.add(rDtae, 1, 7);
        grid.add(rTime, 1, 8);
        grid.add(price, 1, 9);
        grid.add(tran, 1, 10);
        grid.add(back, 5, 11);
        //   grid.add(cancel, 6, 11);
        int x = newlist.size();
        System.out.println(x);
        if (x > 0) {
            TripOfPassenger trip = newlist.get(0);
            System.out.println(); //cehck
            source.setText(trip.source);
            destination.setText(trip.destination);
            date.setText(trip.date);
            time.setText(trip.Time);
            type.setText(trip.Type);
            way.setText(trip.way);
            rDtae.setText(trip.returnDate);
            rTime.setText(trip.returnTime);
            price.setText(trip.price);
            tran.setText(trip.transportation);

            title.setText("Your Trip Details");
        } else {
            title.setText("No trips Yet");
        }

        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(passengerOptions.getScene()); // will go to the menu
            }

        });

        scene = new Scene(grid, 1000, 600);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setList(SaveLists list) {
        this.list = list;
    }

    public void setPassengerOptions(PassengerOptions passengerOptions) {
        this.passengerOptions = passengerOptions;
    }

}
