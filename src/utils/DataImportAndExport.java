package utils;

import controllers.PlayerController;
import model.Game;
import model.Player;

import java.io.*;
import java.util.ArrayList;

public class DataImportAndExport {

    private static final String FP = "./src/data/test";

    public static void main(String args[]) {

        DataImportAndExport objectIO = new DataImportAndExport();

        Player player = new Player("Dubious");
        Player player2 = new Player("Ross");

        ArrayList<Player> playerArrayList =  new ArrayList<>();
        playerArrayList.add(player);
        playerArrayList.add(player2);

        Game game1 = new Game(playerArrayList, Game.Result.TIE);
        Game game2 = new Game(playerArrayList, Game.Result.LOSS);

        PlayerController playerController = new PlayerController();
        playerController.addPlayer(player);
        playerController.addPlayer(player2);

        objectIO.writeObjectToFile(playerController,FP);
        PlayerController playerController1 = (PlayerController) objectIO.readObjectFromFile(FP);

        System.out.println(playerController1.getPlayers().get(0).getName());

        for (Game g:playerController1.getPlayers().get(0).getGames()) {
            System.out.println(g.getResult());
        }

        System.out.println(playerController1.getPlayers().get(1).getName());

        for (Game g:playerController1.getPlayers().get(1).getGames()) {
            System.out.println(g.getResult());
        }
    }

    public void writeObjectToFile(Object serObj, String filePath) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object readObjectFromFile(String filePath) {

        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
