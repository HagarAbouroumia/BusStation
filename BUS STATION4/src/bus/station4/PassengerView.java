package bus.station4;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PassengerView {

    Scene scene;
    Stage stage;
    ScenePassengerProfile passengerProfile;
    ArrayList<Trips> newlist;

    Label source = new Label();
    Label destination = new Label();
    Label date = new Label();
    Label time = new Label();
    Label price = new Label();

  

    public void prepareScene() {
        Button bPasseneger = new Button("Passeneger");
        Label l1 = new Label("Employee");
        Button bManager = new Button("Managr");
        Button bDriver = new Button("Driver");
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll( bPasseneger, l1, bManager, bDriver);
         scene = new Scene(stack, 600, 400);
       // System.out.println(passengerProfile.getK());  
      

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPassengerProfile(ScenePassengerProfile passengerProfile) { // try
        this.passengerProfile = passengerProfile;
    }

}
