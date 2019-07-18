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

public class PassengerOptions {

    Scene scene;
    Stage stage;
    ScenePassengerProfile passengerProfile;
    SceneOne sceneOne;
    SaveLists save;
    PassengerInformation passengerInformation;

    public void prepareScene() {
       
        Button bTripDetails = new Button("Your Trip Details");
        Button bChooseTrip = new Button("Choose a Trip");
        Button back = new Button("Back To main Page");
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(bTripDetails, bChooseTrip, back);
        scene = new Scene(stack, 600, 400);

        bChooseTrip.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(passengerProfile.getScene()); // will go to the menu

            }

        });
        bTripDetails.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                passengerInformation.prepareScene(save);
                stage.setScene(passengerInformation.getScene()); // will go to the menu

            }

        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(sceneOne.getScene()); // will go to the menu

            }

        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPassengerProfile(ScenePassengerProfile passengerProfile) {
        this.passengerProfile = passengerProfile;
    }

    public void setSceneOne(SceneOne sceneOne) {
        this.sceneOne = sceneOne;
    }

    public void setSave(SaveLists save) {
        this.save = save;
    }

    public void setPassengerInformation(PassengerInformation passengerInformation) {
        this.passengerInformation = passengerInformation;
    }

}
