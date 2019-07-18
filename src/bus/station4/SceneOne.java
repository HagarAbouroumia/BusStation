package bus.station4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneOne {

    Stage stage;
    Scene scene;

    SceneTwoDriver driver;
    SceneTwoManager manager;
    SceneTwoPassenger passenger;
    SceneOne one;

    SaveLists save;
    SceneAddTrips addTrips;

    public void setSave(SaveLists save) {
        this.save = save;
    }

    public void prepareScene() {

        Label l = new Label("Passenger");
        Button bPasseneger = new Button("Passeneger");
        Label l1 = new Label("Employee");
        Button bManager = new Button("Managr");
        Button bDriver = new Button("Driver");
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(l, bPasseneger, l1, bManager, bDriver);

        bPasseneger.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                passenger.prepareScene();
                stage.setScene(passenger.getScene()); // will go to the menu

            }
        });

        bManager.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                manager.prepareScene();
                stage.setScene(manager.getScene());
            }
        });

        bDriver.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                driver.prepareScene();
                stage.setScene(driver.getScene()); // will go to the menu
            }
        });

        scene = new Scene(stack, 600, 400);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setDriver(SceneTwoDriver driver) {
        this.driver = driver;
    }

    public void setManager(SceneTwoManager manager) {
        this.manager = manager;
    }

    public void setPassenger(SceneTwoPassenger passenger) {
        this.passenger = passenger;
    }

    public void setAddTrips(SceneAddTrips addTrips) {
        this.addTrips = addTrips;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
