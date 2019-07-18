/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class SceneAddTrips {

    Stage stage;
    Scene scene;
    SaveLists saveTrips;
    SceneOne one;
    int count = 0;

    public void prepareScene(SaveLists save) {
        saveTrips = save;
        Label label = new Label();
        label.setText("Enter the Trips Information");
        TextField tSource = new TextField();
        tSource.setPromptText("Source"); // same as Label
        TextField tDestination = new TextField();
        tDestination.setPromptText("Destination"); // same as Label
        TextField tDate = new TextField();
        tDate.setPromptText("Date"); // same as Label
        TextField tTime = new TextField();
        tTime.setPromptText("Time"); // same as Label
        TextField tprice = new TextField();
        tprice.setPromptText("Price"); // same as Label
        TextField tType = new TextField();
        tType.setPromptText("Type Of The Trip"); // same as Label
        TextField tSeats = new TextField();
        tSeats.setPromptText("Seats"); // same as Label
        TextField tReturnDate = new TextField();
        tReturnDate.setPromptText("Return Date"); // same as Label
        TextField tReturnTime = new TextField();
        tReturnTime.setPromptText("Return Time"); // same as Label
        Button add = new Button("Add");
        Button back = new Button("Back to main page");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(5);
        grid.setHgap(10);
        grid.add(label, 0, 0);
        grid.add(tSource, 0, 1);
        grid.add(tDestination, 0, 2);
        grid.add(tDate, 0, 3);
        grid.add(tTime, 0, 4);
        grid.add(tSeats, 0, 5);
        grid.add(tType, 0, 6);
        grid.add(tprice, 0, 7);
        grid.add(tReturnDate, 0, 8);
        grid.add(tReturnTime, 0, 9);
        grid.add(add, 0, 10);
        grid.add(back, 0, 11);

        scene = new Scene(grid, 500, 500);

        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (count != 0) {

                    return;

                }
                //saveTrips = new SaveLists();
                Trips trips2 = new Trips(); // creating nrew trip
                trips2.setSource(tSource.getText());
                trips2.setDestination(tDestination.getText());
                trips2.setDate(tDate.getText());
                trips2.setTime(tTime.getText());
                trips2.setSeats(tSeats.getText());
                trips2.setType(tType.getText());
                trips2.setPrice(tprice.getText());
                trips2.setReturnDate(tReturnDate.getText());
                trips2.setReturnTime(tReturnTime.getText());

                try {
                    saveTrips.saveTrips(trips2); // object of saveList thats calls the method that saves the trips 

                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SceneAddTrips.class.getName()).log(Level.SEVERE, null, ex);
                }
                count++;

            }

        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                count = 0;
                stage.setScene(one.getScene());

            }

        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setSave(SaveLists save) {
        this.saveTrips = new SaveLists();
        this.saveTrips = saveTrips;
    }

    public void setOne(SceneOne one) {
        this.one = one;
    }

}
