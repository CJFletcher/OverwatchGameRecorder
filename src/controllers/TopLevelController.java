package controllers;

import java.io.Serializable;

public class TopLevelController implements Serializable {
    private GameController gameController;
    private PlayerController playerController;
    private final static String DATAFILEPATH = "./src/data/data.dat";

    public TopLevelController(GameController gameController, PlayerController playerController) {
        this.gameController = gameController;
        this.playerController = playerController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    public static String getDATAFILEPATH() {
        return DATAFILEPATH;
    }

}
