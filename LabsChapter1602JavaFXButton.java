 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labschapter1602javafxbutton;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LabsChapter1602JavaFXButton extends Application {
    protected Text text = new Text(50,50,"Java Programming");
    protected BorderPane getPane() {
        String filePath = "https://www.google.ca/url?sa=i&rct=j&q=&esrc=s&source=imgres&cd=&cad=rja&uact=8&ved=0ahUKEwijwuuWxpzTAhUg0IMKHczWBFgQjRwIBw&url=http%3A%2F%2Fwww.worldatlas.com%2Fwebimage%2Fcountrys%2Fnamerica%2Fcaribb%2Fdominicanrepublic%2Fdoflags.htm&psig=AFQjCNGXWPtjGs4RwJcN8iJoKMFbf8I2uQ&ust=1492005077451189";
        HBox paneForButtons = new HBox(20);
        Button btLeft = new Button("Left", new ImageView(filePath));
        Button btRight = new Button("Right", new ImageView(filePath));
        paneForButtons.getChildren().addAll(btLeft,btRight);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");
        
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);
        
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);
        
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        
        return pane;
    }
    
    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getPane(), 450, 250);
        
        primaryStage.setTitle("Butrton Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
