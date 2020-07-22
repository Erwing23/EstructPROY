/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyest;

import TDAs.LCDE;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author laptop
 */
public class VentanaPrincipal {

    ScrollPane root;

    public VentanaPrincipal(int numParticipantes) {
        createContent(numParticipantes);
    }

    private void createContent(int numParticipantes) {
        //Llenamos la lista con imagenes de las personas y la lista de sillas
        LCDE<ImageView> personas = new LCDE<>();
        LCDE<StackPane> sillas = new LCDE<>();
        int p = 1;
        for (int i = 0; i < numParticipantes; i++) {
            Image personasn = new Image(getClass().getResourceAsStream("/image/p" + p + ".png"));
            ImageView view = new ImageView(personasn);
            view.setFitHeight(80);
            view.setFitWidth(80);
            personas.add(i, view);
            p++;
            if (p == 4) {
                p = 1;
            }
            if (i < numParticipantes - 1) {
                Image silla = new Image(getClass().getResourceAsStream("/image/silla.png"));
                ImageView views = new ImageView(silla);
                views.setFitHeight(120);
                views.setFitWidth(120);
                StackPane s = new StackPane();
                s.getChildren().add(views);
                sillas.add(i, s);
            }
        }
        //Pantalla Principal
        root = new ScrollPane();
        VBox V1 = new VBox();
        StackPane p1 = new StackPane();
        GridPane GP = new GridPane();
        
       // Image silla = new Image(getClass().getResourceAsStream("/image/silla.png"));
       // ImageView views = new ImageView(silla);
        //views.setFitHeight(120);
        //views.setFitWidth(120);
        //Image persona = new Image(getClass().getResourceAsStream("/image/p1.png"));
        //ImageView viewp1 = new ImageView(persona);
        //viewp1.setFitHeight(80);
        //viewp1.setFitWidth(80);
        VBox juego = new VBox();
        juego.setAlignment(Pos.CENTER);
        //p1.getChildren().addAll(views, viewp1);
        Button bstart = new Button("Iniciar");
        Button bganar = new Button("GANAR");
         Button badelante = new Button("Adelante");
        Button batras = new Button("Atras");
       // bganar.setDisable(true);
       // V1.getChildren().add(p1);
        V1.getChildren().add(juego);
        V1.getChildren().addAll(bstart, bganar,badelante,batras);
        for (int i = 0; i < personas.size(); i++) {
            V1.getChildren().add(personas.get(i));
            GP.add(personas.get(i), i, i);
        }
        GP.setAlignment(Pos.CENTER);
        V1.getChildren().add(GP);
        V1.setMinWidth(1000);
        V1.setAlignment(Pos.CENTER);

        root = new ScrollPane(V1);
        bstart.setOnAction(e -> {

            juego.getChildren().clear();
            GridPane inicio = new GridPane();
            if (personas.size() == 2) {

                inicio.add(personas.get(0), 0, 1);
                inicio.add(sillas.get(0), 1, 1);
                inicio.add(personas.get(1), 2, 1);
                inicio.setAlignment(Pos.CENTER);
                juego.getChildren().add(inicio);

            } else if (personas.size() == 3) {
                inicio.add(personas.get(0), 2, 0);
                inicio.add(personas.get(2), 0, 1);
                inicio.add(sillas.get(0), 1, 1);
                inicio.add(sillas.get(1), 3, 1);
                inicio.add(personas.get(1), 4, 1);
                inicio.setAlignment(Pos.CENTER);
                juego.getChildren().add(inicio);

            } else if (personas.size() == 4) {
                inicio.add(personas.get(0), 2, 0);
                inicio.add(personas.get(1), 4, 1);
                inicio.add(sillas.get(0), 1, 1);
                inicio.add(sillas.get(1), 3, 1);
                inicio.add(personas.get(2), 2, 3);
                inicio.add(sillas.get(2), 2, 2);
                inicio.add(personas.get(3), 0, 1);
                inicio.setAlignment(Pos.CENTER);
                juego.getChildren().add(inicio);

            } else {
                //Numero de participantes Par
                System.out.println(personas.size());
                System.out.println(personas.size() %2);
                if (personas.size() % 2 == 0) {
                     int iteraciones = (personas.size()/2)+2;
                     for (int i = 0; i < iteraciones; i++) {
                         if (i==0) {
                            inicio.add(personas.get(0), 0, 2);
                         }else if(i==personas.size()/2){
                             System.out.println("Silla");
                              inicio.add(sillas.get(personas.size()-2), i, 2);
                         }else if (i== (personas.size()/2)+1) {
                              System.out.println("Persona Final?");
                              inicio.add(personas.get(personas.size()/2), i, 2);
                         }else{
                             System.out.println("Finales?");
                            inicio.add(personas.get(i), i, 0);
                            inicio.add(sillas.get(i*2-2), i, 1);
                            inicio.add(sillas.get(i*2-1), i, 3);
                            inicio.add(personas.get(personas.size()-i), i, 4);
                         
                         }
                        
                    }
                      inicio.setAlignment(Pos.CENTER);
                    juego.getChildren().add(inicio);
                        
                } else {
                    //Numero de participantes impar
                    int iteraciones = ((personas.size() - 1) / 2) + 1;
                    for (int i = 0; i < iteraciones; i++) {
                        if (i==0) {
                            inicio.add(personas.get(0), 0, 2);
                        } else{
                            
                             inicio.add(personas.get(i), i, 0);
                            inicio.add(sillas.get(i*2-2), i, 1);
                            inicio.add(sillas.get(i*2-1), i, 3);
                            inicio.add(personas.get(personas.size()-i), i, 4);
                            
                        }                      
                        
                                                
                        
                    }
                     inicio.setAlignment(Pos.CENTER);
                    juego.getChildren().add(inicio);
                    
                }
               
            }
           // bstart.setDisable(true);
            //bganar.setDisable(false);
        });
        bganar.setOnAction(e -> {
            personas.removeLast();
            //bstart.setDisable(false);
            //bganar.setDisable(true);
        });
          badelante.setOnAction(e -> {
           personas.moverAdelante();
        });
           batras.setOnAction(e -> {
           personas.moverAtras();
        });

    }

    public ScrollPane getRoot() {
        return root;
    }

}
