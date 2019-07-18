package bus.station4;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class BUSSTATION4 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException, FileNotFoundException, ClassNotFoundException {

        SceneOne newScene = new SceneOne(); //obj from the scene i am going to 
        SceneTwoPassenger passenger = new SceneTwoPassenger(); //obj from the scene i am going to 
        SceneTwoManager manager = new SceneTwoManager(); //obj from the scene i am going to 
        SceneTwoDriver driver = new SceneTwoDriver(); //obj from the scene i am going to 
        SceneAddTrips addTrips = new SceneAddTrips();
        Validation V = new Validation();
        SaveLists save = new SaveLists(); // to take from the class 
        LogicAuthentication logicAuthentication = new LogicAuthentication();
        ManagerOptions managerOptions = new ManagerOptions();
        Monier monier = new Monier();
        MonierProfile monierProfile = new MonierProfile();

        save.load();
        save.load2();
        save.load3();

        //save.load3();
        PassengerView passengerView = new PassengerView();
        ScenePassengerProfile passengerProfile = new ScenePassengerProfile();
        ManagingDrivers managingDrivers = new ManagingDrivers();
        PassengerOptions passengerOptions = new PassengerOptions();
        PassengerInformation passengerInformation = new PassengerInformation();
        RemovingTrips removingTrips = new RemovingTrips();
        passengerView.setPassengerProfile(passengerProfile); // try

        // manager.setAddTrips(addTrips);
        newScene.setStage(primaryStage); // the same stage 
        passenger.setStage(primaryStage); // the same stage 
        manager.setStage(primaryStage); // the same stage 
        driver.setStage(primaryStage); // the same stage 
        addTrips.setStage(primaryStage);
        passengerProfile.setStage(primaryStage);  // i forgot to set the stage for it 
        passengerView.setStage(primaryStage);
        managerOptions.setStage(primaryStage);
        managingDrivers.setStage(primaryStage);
        passengerOptions.setStage(primaryStage);
        passengerInformation.setStage(primaryStage);
        removingTrips.setStage(primaryStage);
        monier.setStage(primaryStage);
        monierProfile.setStage(primaryStage);

        newScene.prepareScene();
        driver.prepareScene();
        manager.prepareScene();
        passenger.prepareScene();
        addTrips.prepareScene(save);
        passengerProfile.prepareScene(save);
        passengerView.prepareScene();
        managerOptions.prepareScene();
        managingDrivers.prepareScene();
        passengerOptions.prepareScene();
        passengerInformation.prepareScene(save);
        removingTrips.prepareScene(save);
        monier.prepareScene(save);
        monierProfile.prepareScene(save);

        newScene.setDriver(driver);
        newScene.setManager(manager);
        newScene.setPassenger(passenger);
        newScene.setAddTrips(addTrips);
        newScene.setSave(save);
        managerOptions.setAddTrips(addTrips);
        managerOptions.setOne(newScene);
        managerOptions.setManagingdrivers(managingDrivers);
        managerOptions.setSave(save);
        managerOptions.setRemovingTrips(removingTrips);

        passengerOptions.setPassengerProfile(passengerProfile);
        passengerOptions.setSceneOne(newScene);
        passengerOptions.setSave(save);
        passengerOptions.setPassengerInformation(passengerInformation);
        manager.setV(V);
        manager.setOne(newScene);
        manager.setManagerOptions(managerOptions);
        driver.setV(V);
        driver.setOne(newScene);
        driver.setMonierProfile(monierProfile);
        passenger.setV(V);
        passenger.setPassengerOptions(passengerOptions);
        passenger.setOne(newScene);

        passengerProfile.setLists(save);
        addTrips.setOne(newScene);

        addTrips.setStage(primaryStage);
        passengerProfile.setLists(save);

        passengerProfile.setPassengerOptions(passengerOptions);
        passengerProfile.setLogicAuthentication(logicAuthentication);

        logicAuthentication.setLists(save);

        passengerInformation.setList(save);
        passengerInformation.setPassengerOptions(passengerOptions);

        removingTrips.setList(save);
        removingTrips.setManagerOptions(managerOptions);

        monier.setLists(save);
        monier.setManagerOptions(managerOptions);

        managingDrivers.setMonier(monier);
        monierProfile.setOne(newScene);

        primaryStage.setScene(newScene.getScene());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
