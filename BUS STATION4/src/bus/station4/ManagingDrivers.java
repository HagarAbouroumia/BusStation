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

public class ManagingDrivers {

    Scene scene;
    Stage stage;
    Monier monier;

    public void prepareScene() {

        Button monierr = new Button("Monier");
        Button yhia = new Button("Yhia");
        Button essam = new Button("Essam");
        VBox vb = new VBox(25);
        vb.setPadding(new Insets(30, 30, 30, 30));
        StackPane stack = new StackPane();
        stack.getChildren().add(vb);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(monierr);
        scene = new Scene(stack, 600, 400);

        monierr.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(monier.getScene());
            }
        });
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setMonier(Monier monier) {
        this.monier = monier;
    }

}
