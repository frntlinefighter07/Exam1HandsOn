/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam1handson;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Benji
 */
public class Exam1HandsOn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       //Create panes
       VBox pane = new VBox(10);
       HBox holder = new HBox(10);
       VBox textF = new VBox(10);
       VBox labl = new VBox(10);
       HBox btnHolder = new HBox(10);
       
       //Create the controls
       Label usDollars = new Label("US Dollars");
       Label canDollars = new Label("Canadian Dollars");
       TextField usD = new TextField();
       TextField canD = new TextField();
       Button converter = new Button("Convert");
       
       //Customize the controls
       canD.setEditable(false);
       converter.setAlignment(Pos.BOTTOM_RIGHT);
       converter.setOnAction(e -> convert(Double.parseDouble(usD.getText()), canD));
       //Add controls to pane
       labl.getChildren().addAll(usDollars, canDollars);
       textF.getChildren().addAll(usD, canD);
       holder.getChildren().addAll(labl, textF);
       btnHolder.getChildren().add(converter);
       btnHolder.setAlignment(Pos.CENTER_RIGHT);
       pane.getChildren().add(holder);
       pane.getChildren().add(btnHolder);
       
       Scene scene = new Scene(pane, 275, 200);
       primaryStage.setTitle("Currency Converter");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void convert(double amount, TextField text)
    {
        double convertedAmount;
        
        convertedAmount = amount *1.5;
        String amountString = Double.toString(convertedAmount);
        text.setText(amountString);
    }
}
