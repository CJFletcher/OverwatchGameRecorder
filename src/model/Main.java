package model;

import controllers.GameController;
import controllers.PlayerController;
import controllers.TopLevelController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import utils.DataImportAndExport;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static PlayerController players;
    private static GameController games;
    private static Parent root;
    private static TopLevelController controller;
    private static Player currentPlayer;

    public static Stage getStage() {
        return primaryStage;
    }

    public static PlayerController getPlayers() {
        return players;
    }

    public static void setPlayers(PlayerController players) {
        Main.players = players;
    }

    public static GameController getGames() {
        return games;
    }

    public static void setGames(GameController games) {
        Main.games = games;
    }

    public static Parent getRoot() {
        return root;
    }

    public static void setRoot(Parent root) {
        Main.root = root;
    }

    public static TopLevelController getController() {
        return controller;
    }

    public static void setController(TopLevelController controller) {
        Main.controller = controller;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        Main.currentPlayer = currentPlayer;
    }

    public static void saveData() {
        DataImportAndExport objectIO = new DataImportAndExport();
        objectIO.writeObjectToFile(controller, TopLevelController.getDATAFILEPATH());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DataImportAndExport objectIO = new DataImportAndExport();


        //Uncomment this to load in test data
        //TestData td = new TestData();
        //td.loadData();

        controller = (TopLevelController) objectIO.readObjectFromFile(TopLevelController.getDATAFILEPATH());

        players = controller.getPlayerController();
        games = controller.getGameController();

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/gameRecord.fxml"));
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Overwatch Game Recorder");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

    }
}
