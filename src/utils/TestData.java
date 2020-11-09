package utils;

import controllers.GameController;
import controllers.PlayerController;
import controllers.TopLevelController;
import model.Game;
import model.Player;

public class TestData {

    public TestData() {
    }

    public void loadData() {
        DataImportAndExport objectIO = new DataImportAndExport();

        GameController games = new GameController();
        PlayerController players = new PlayerController();
        TopLevelController controller = new TopLevelController(games,players);

        Player player = new Player("Dubious");
        Player player2 = new Player("Smiddy");

        players.addPlayer(player);
        players.addPlayer(player2);

        Game game = new Game(players.getPlayers(), Game.Result.WIN);
        games.addGame(game);

        objectIO.writeObjectToFile(controller,TopLevelController.getDATAFILEPATH());
    }
}
