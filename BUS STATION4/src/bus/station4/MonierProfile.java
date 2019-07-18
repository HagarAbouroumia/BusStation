package bus.station4;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MonierProfile {

    int i = 0;
    Scene scene;
    Stage stage;
    ArrayList<TripsForDrivers> newlist;
    SaveLists list;
    TripOfPassenger tripOfPassenger;
    PassengerOptions passengerOptions;
    ManagingDrivers drivers;
    SceneOne one;

    Label source = new Label();
    Label destination = new Label();
    Label date = new Label();
    Label time = new Label();
    Label type = new Label();
    Label way = new Label();
    Label price = new Label();
    Label rDtae = new Label();
    Label rTime = new Label();
    Label title = new Label("Monier's Trip");
    Button cancel = new Button("Cancel Your Trip");
    Button back = new Button("Back");
    Button next = new Button("Next");
    Button prev = new Button("Prev");

    public void prepareScene(SaveLists save) {
        list = save;

        newlist = list.getDrivers();
        Label wType = new Label("Type Of Trip     :");
        Label wsource = new Label("Source           :");
        Label wdestination = new Label("Destination      :");
        Label wdate = new Label("Date             :");
        Label wtime = new Label("Time             :");

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

        grid.add(type, 1, 1);
        grid.add(source, 1, 2);
        grid.add(destination, 1, 3);
        grid.add(date, 1, 4);
        grid.add(time, 1, 5);
        grid.add(way, 1, 6);
        grid.add(rDtae, 1, 7);
        grid.add(rTime, 1, 8);
        grid.add(price, 1, 9);
        grid.add(back, 4, 11);
        grid.add(next, 0, 11);
        grid.add(prev, 2, 11);
        TripsForDrivers trip = newlist.get(0);

        source.setText(trip.source);
        destination.setText(trip.destination);
        date.setText(trip.date);
        time.setText(trip.Time);

        type.setText(trip.type);

        next.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = list.getDrivers();
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

                TripsForDrivers trip = newlist.get(i);

                System.out.println(i);
                source.setText(trip.source);
                destination.setText(trip.destination);
                date.setText(trip.date);
                time.setText(trip.Time);

                type.setText(trip.type);

            }

        });
        prev.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = list.getDrivers();
                if (i >= newlist.size()) {
                    int j = newlist.size();
                    i = j - 1;
                }
                --i;
                if (i < 0) {
                    i = 0;
                    return;
                }

                TripsForDrivers trip = newlist.get(i);
                System.out.println(i);
                source.setText(trip.source);
                destination.setText(trip.destination);
                date.setText(trip.date);
                time.setText(trip.Time);

                type.setText(trip.type);

            }

        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.setScene(one.getScene());

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

    public void setOne(SceneOne one) {
        this.one = one;
    }

}
