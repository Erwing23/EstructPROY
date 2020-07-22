/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyest;

import entities.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PITA ESTRELLA JORGE BRYAN
 */
public class InitializeGame {

    private final Label label;
    private final Scene scene;
    private final ComboBox<Integer> comboBox;
    private final GridPane gridPane;
    private final Button saveBtn;
    private final Button returnBtn;
    public static Game game;

    public InitializeGame(Stage stage) {
        this.label = new Label("Número de personas: ");
        this.saveBtn = new Button("Guardar");
        this.returnBtn = new Button("Regresar");
        this.comboBox = new ComboBox();
        this.comboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8);
        this.comboBox.setVisibleRowCount(3);
        this.gridPane = new GridPane();
        gridPane.add(label, 1, 1);
        gridPane.add(comboBox, 3, 1);
        gridPane.add(saveBtn, 1, 2);
        gridPane.add(returnBtn, 3, 2);
        this.scene = new Scene(gridPane, 300, 225);
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(25);
        gridPane.setVgap(50);
        events(stage);
    }

    public Scene getScene() {
        return scene;
    }

    public void events(Stage stage) {
        returnBtn.setOnAction((ActionEvent e) -> {
            PaneOrganizer rootContenedor = new PaneOrganizer(stage);
            StackPane root = rootContenedor.getRoot();
            Scene s = new Scene(root, 300, 250);
            stage.setTitle("Musical Chairs");
            stage.setScene(s);
            stage.show();
            rootContenedor.setGame(InitializeGame.game);
        });

        saveBtn.setOnAction((ActionEvent e) -> {

            try {
                InitializeGame.game = new Game(this.comboBox.getValue());
                
            } catch (NullPointerException exc) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("ATENCIÓN: ");
                alert.setTitle("Error");
                alert.setContentText("Debe seleccionar un numero");
                alert.showAndWait();
            }
        });

    }


}
