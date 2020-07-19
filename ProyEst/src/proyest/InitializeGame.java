/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyest;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author PITA ESTRELLA JORGE BRYAN
 */
public class InitializeGame {

    private Label label;
    private Scene scene;
    private ComboBox comboBox;
    private GridPane gridPane;
    private Button saveBtn, returnBtn;

    public InitializeGame(Stage stage) {
        this.label = new Label("Número de personas: ");
        this.saveBtn = new Button("Guardar");
        this.returnBtn = new Button("Regresar");
        this.comboBox = new ComboBox();
        this.gridPane = new GridPane();
        gridPane.add(label, 1, 1);
        gridPane.add(comboBox, 3, 1);
        gridPane.add(saveBtn, 1, 2);
        gridPane.add(returnBtn, 3, 2);
        this.scene = new Scene(gridPane, 300, 225);
        gridPane.setAlignment(Pos.CENTER);
        events(stage);
    }

    public Scene getScene() {
        return scene;
    }

    public void events(Stage stage) {
        returnBtn.setOnAction(e -> {
            PaneOrganizer rootContenedor = new PaneOrganizer(stage);
            StackPane root = rootContenedor.getRoot();
            Scene scene = new Scene(root, 300, 250);
            stage.setTitle("Musical Chairs");
            stage.setScene(scene);
            stage.show();
        });
    }

}
