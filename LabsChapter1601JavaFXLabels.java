/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter16021avafxlabels;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class LabsChapter1601JavaFXLabels extends Application {
    @Override
    public void start(Stage primaryStage) {
        String filePath = "https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwijwuuWxpzTAhUg0IMKHczWBFgQjRwIBw&url=http%3A%2F%2Fwww.worldatlas.com%2Fwebimage%2Fcountrys%2Fnamerica%2Fcaribb%2Fdominicanrepublic%2Fdoflags.htm&psig=AFQjCNGXWPtjGs4RwJcN8iJoKMFbf8I2uQ&ust=1492005077451189";
        ImageView us = new ImageView(new Image(filePath));
        
        Label lb1 = new Label("US\n50 States", us);
        lb1.setStyle("-fx-border-color: green: -fx-border-width: 2");
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        lb1.setTextFill(Color.RED);
        
        Label lb2 = new Label("Circle", new Circle(50,50,25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);
                
        Label lb3 = new Label("Rectangle", new Rectangle(10,10,50,25));
        lb3.setContentDisplay(ContentDisplay.RIGHT);
                
        Label lb4 = new Label("Ellipse", new Ellipse(50,50,50,25));
        lb4.setContentDisplay(ContentDisplay.LEFT);
        
        Ellipse ellipse = new Ellipse(50,50,50,25);
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, new Label("JavaFX"));
        Label lb5 = new Label("A pane inside a label",stackPane);
        lb5.setContentDisplay(ContentDisplay.LEFT);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);
        
        HBox pane = new HBox(20);
        pane.getChildren().addAll(lb1,lb2,lb3,lb4,lb5);
        
        Scene scene = new Scene(pane,650,350);
        primaryStage.setTitle("Label with Graphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
