/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyest;

import TDAs.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author erwin
 */
public class ProyEst extends Application {

    @Override
    public void start(Stage primaryStage) {
        PaneOrganizer rootContenedor = new PaneOrganizer(primaryStage);
        StackPane root = rootContenedor.getRoot();        
        Scene scene = new Scene(root, 300, 250);
        //scene.getStylesheets().add("proyest/stylesHome.css");
        primaryStage.setTitle("Musical Chairs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LCDE<Integer> lista = new LCDE();
        lista.addFirst(3);
        lista.addFirst(2);
        lista.addFirst(0);
        lista.add(1, 1);
      
       
        System.out.println(lista);
        System.out.println(lista.set(1, 2));
        System.out.println(lista);
       
        launch(args);
    }

}
