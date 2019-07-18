package bus.station4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagerOptions {

    Scene scene;
    Stage stage;
    SceneAddTrips addTrips;
    SceneOne one;
    ManagingDrivers managingdrivers;
    SaveLists save;
    RemovingTrips removingTrips;

    public void prepareScene() {

        Button bAddTrips = new Button("Add Trips");
        Button bSetToDrivers = new Button("Set Trips To Drivers");
        Button bRemoveTrips = new Button("Remove Trips");
        Button back = new Button("Back To main Page");
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(bAddTrips, bSetToDrivers, bRemoveTrips, back);
        scene = new Scene(stack, 600, 400);

        bAddTrips.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                addTrips.prepareScene(save);

                stage.setScene(addTrips.getScene());

            }
        });
        bRemoveTrips.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                addTrips.prepareScene(save);

                stage.setScene(removingTrips.getScene());

            }
        });
        bSetToDrivers.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(managingdrivers.getScene());
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(one.getScene());

            }

        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setAddTrips(SceneAddTrips addTrips) {
        this.addTrips = addTrips;
    }

    public void setOne(SceneOne one) {
        this.one = one;
    }

    public void setManagingdrivers(ManagingDrivers managingdrivers) {
        this.managingdrivers = managingdrivers;
    }

    public void setSave(SaveLists save) {
        this.save = save;
    }

    public void setRemovingTrips(RemovingTrips removingTrips) {
        this.removingTrips = removingTrips;
    }

}
