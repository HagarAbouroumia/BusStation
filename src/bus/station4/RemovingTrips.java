package bus.station4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RemovingTrips {

    Scene scene;
    Stage stage;
    ArrayList<Trips> newlist;
    SaveLists list;
    int i = 0;
    ManagerOptions managerOptions;

    Label source = new Label();
    Label destination = new Label();
    Label date = new Label();
    Label time = new Label();
    Label type = new Label();
    Label price = new Label();
    Label title = new Label();
    Button remove = new Button("Remove Trip");
    Button back = new Button("Back");
    Button next = new Button("Next");
    Button pevious = new Button("Previous");

    public void prepareScene(SaveLists save) {
        list = save;

        newlist = list.getTrips();
        Label wType = new Label("Type Of Trip     ");
        Label wsource = new Label("Source           ");
        Label wdestination = new Label("Destination      ");
        Label wdate = new Label("Date             ");
        Label wtime = new Label("Time             ");
        Label wPrice = new Label("Price            ");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(wsource, 0, 0);
        grid.add(wdestination, 1, 0);
        grid.add(wdate, 2, 0);
        grid.add(wtime, 3, 0);

        grid.add(wType, 4, 0);
        grid.add(wPrice, 5, 0);
        grid.add(source, 0, 1);
        grid.add(destination, 1, 1);
        grid.add(date, 2, 1);
        grid.add(time, 3, 1);

        grid.add(type, 4, 1);
        grid.add(price, 5, 1);

        grid.add(next, 0, 3);
        grid.add(pevious, 5, 3);
        grid.add(remove, 8, 3);

        grid.add(back, 7, 3);

        Trips trip = newlist.get(0);
        System.out.println(i); //cehck
        source.setText(trip.source);
        destination.setText(trip.destination);
        date.setText(trip.date);
        time.setText(trip.Time);
        type.setText(trip.type);
        price.setText(trip.price);
        next.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = list.getTrips();
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

                type.setText(trip.type);
                price.setText(trip.price);

            }

        });
        pevious.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                newlist = list.getTrips();
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
                price.setText(trip.price);

            }

        });
        remove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Trips t = new Trips();

                newlist.remove(i);

            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int i;

                stage.setScene(managerOptions.getScene());

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

    public void setManagerOptions(ManagerOptions managerOptions) {
        this.managerOptions = managerOptions;
    }

}
