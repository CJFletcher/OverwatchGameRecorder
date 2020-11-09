package fxmlControllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import model.Game;
import model.Main;
import model.Player;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static fxmlControllers.SceneCreator.openScene;

public class GameRecord implements Initializable {

    private ArrayList<Player> selectedPlayers;

    @FXML private Button winButton;
    @FXML private Button tieButton;
    @FXML private Button lossButton;
    @FXML private BorderPane borderPane1;
    @FXML private TableView table;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn winColumn;
    @FXML private TableColumn tieColumn;
    @FXML private TableColumn lossColumn;
    @FXML private MenuItem saveMenuItem;


    public ArrayList<Player> getSelectedPlayers() {
        return selectedPlayers;
    }

    public void setSelectedPlayers(ArrayList<Player> selectedPlayers) {
        this.selectedPlayers = selectedPlayers;
    }

    @FXML private void addCheckBox(){
        TableColumn select = new TableColumn("Played in last game?");
        select.setMinWidth(200);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Player, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Player, CheckBox> arg0) {
                Player player = arg0.getValue();
                CheckBox checkBox = new CheckBox();
                checkBox.selectedProperty().setValue(player.isSelected());

                checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                                        Boolean old_val, Boolean new_val) {

                        player.setSelected(new_val);
                    }
                });
                return new SimpleObjectProperty<CheckBox>(checkBox);
            }
        });
        table.getColumns().addAll(select);
    }

    @FXML private void addWinRatio() {
        TableColumn select = new TableColumn("Win/Loss Ratio");
        select.setMinWidth(100);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Player, Float>, ObservableValue<Float>>() {

            @Override
            public ObservableValue<Float> call(
                    TableColumn.CellDataFeatures<Player, Float> arg0) {
                Player player = arg0.getValue();
                return new SimpleObjectProperty<Float>(player.getWinLossRatio()*100);
            }
        });
        table.getColumns().addAll(select);
    }

    @FXML private void populateTableView() {
        table.getItems().clear();
        for (Player player : Main.getPlayers().getPlayers()) {
            table.getItems().add(player);
        }
    }

    private void populateSelectedPlayers(){
        this.setSelectedPlayers(new ArrayList<>());
        for (Player p:Main.getPlayers().getPlayers()) {
            if (p.isSelected()){
                this.getSelectedPlayers().add(p);
            }
        }
    }

    @FXML
    private void recordWin(ActionEvent actionEvent) {
        populateSelectedPlayers();
        new Game(this.selectedPlayers, Game.Result.WIN);
        populateTableView();
    }

    @FXML
    private void recordTie(ActionEvent actionEvent) {
        populateSelectedPlayers();
        new Game(this.selectedPlayers, Game.Result.TIE);
        populateTableView();
    }

    @FXML
    private void recordLoss(ActionEvent actionEvent) {
        populateSelectedPlayers();
        new Game(this.selectedPlayers, Game.Result.LOSS);
        populateTableView();
    }

    @FXML
    private void saveData(ActionEvent actionEvent) {
        Main.saveData();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //populatePlayerDetails();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        winColumn.setCellValueFactory(new PropertyValueFactory<>("Wins"));
        tieColumn.setCellValueFactory(new PropertyValueFactory<>("Ties"));
        lossColumn.setCellValueFactory(new PropertyValueFactory<>("Losses"));

        addWinRatio();
        addCheckBox();
        populateTableView();
    }
}
