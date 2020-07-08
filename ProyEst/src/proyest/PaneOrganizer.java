/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyest;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author PITA ESTRELLA JORGE BRYAN
 */
public class PaneOrganizer {
    private VBox boxVertical;
    private StackPane root;
    private Label Title;
    private Button startBtn, inicializarBtn;
    
    public PaneOrganizer(){
        createContent();
    }
    
    public void createContent(){
        this.root =new StackPane();
        this.Title = new Label("Musical Chairs");
        Title.setId("titulo");
        this.startBtn =new Button("EMPEZAR");
        startBtn.setId("botones");
        this.inicializarBtn = new Button("INICIALIZAR");
        startBtn.setMaxWidth(100);
        inicializarBtn.setMaxWidth(100);
        this.boxVertical = new VBox();
        boxVertical.setSpacing(10);
        boxVertical.setAlignment(Pos.CENTER);
        boxVertical.getChildren().addAll(Title,startBtn,inicializarBtn);
        root.getChildren().add(boxVertical);
        
    }
    
    public StackPane getRoot(){
        return this.root;
    }
    
}
