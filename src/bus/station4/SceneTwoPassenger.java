/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.station4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SceneTwoPassenger {

    Stage stage;
    Scene scene;
    Validation v;
    //ScenePassengerProfile passengerProfile;
    SceneOne one;
    PassengerOptions passengerOptions;
    

    public void prepareScene() {
        TextField username = new TextField();
        PasswordField userpassword = new PasswordField();
        Label userLabel = new Label("Username");
        Label passLabel = new Label("Password");
        Label validationLabel = new Label();
        Button login = new Button("Log in");
        Button back = new Button("Back");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(60, 60, 60, 60));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(userLabel, 0, 0);
        grid.add(username, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(userpassword, 1, 1);
        grid.add(login, 0, 2);
        grid.add(back, 0, 3);
        grid.add(validationLabel, 1, 2);

        login.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
               
                String usernane = username.getText();  // get password from user
                String password = userpassword.getText();  // get password from user
                 boolean valid = v.validate(usernane, password);
                if (valid) {
                stage.setScene(passengerOptions.getScene()); // will go to the menu
                } else {

                validationLabel.setText("Incorrect username or password");
                validationLabel.setFont(Font.font("Verdana", 15));
          }
            }
        });
        
         back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                stage.setScene(one.getScene());

            }

        });

        scene = new Scene(grid, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setV(Validation v) {
        this.v = v;
    }

  

    public void setOne(SceneOne one) {
        this.one = one;
    }

    public void setPassengerOptions(PassengerOptions passengerOptions) {
        this.passengerOptions = passengerOptions;
    }
    
    
}
