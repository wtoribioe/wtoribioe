
/************************************************************
 * Wilfrido Toribio Espinosa                              *
 * 15.1a Assignment 7 - JavaFX Basics - Pick Four Cards 
 * 
 * **********************************************************
 */
package wilfridojavafxbasicpickfourcards;

import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;

public class WilfridoJavaFXBasicPickFourCards extends Application {
    String path = "wilfridojavafxbasicpickfourcards/image/card/";
    File[] files = new File(path).listFiles();
    @Override 
    public void start(Stage primaryStage) {
        // Create a VBox object
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
	vBox.setPadding(new Insets(4, 4, 4, 4));

	// Create a HBox object
	HBox hBox = new HBox(5);
	hBox.setAlignment(Pos.CENTER);
	hBox.setPadding(new Insets(4, 4, 4, 4));
	pickUpCards(hBox);
	Button btRefresh = new Button("Refresh");
	btRefresh.setOnAction(e -> pickUpCards(hBox));
	vBox.getChildren().addAll(hBox, btRefresh);

	// Create a scene and place it in the stage
	Scene scene = new Scene(vBox);
	primaryStage.setTitle("Assignment 7 -JavaFX Basics- Pick Four Cards"); 
	primaryStage.setScene(scene); 
	primaryStage.show(); 
	}
        //Method to randomly pick up 4 cards from the Deck of 52
	private void pickUpCards(HBox pane) throws IllegalArgumentException {
            pane.getChildren().clear();
            
            // ArrayList of integer to the hold 52 Cards of the deck
            ArrayList<Integer> cardsDeck = new ArrayList<>();
            for (int i = 0; i < 52; i++) {
		cardsDeck.add(i + 1);
            }
            // Randomly Shuffling Cards from the Deck 
            java.util.Collections.shuffle(cardsDeck);
            
            // Managing Exception error if the Cards Desk image file path is wrong one
        try {
            // Adding nodes to pane
            for (int i = 0; i < 4; i++) {
		pane.getChildren().add(new ImageView(new Image(path +
                    cardsDeck.get(i) + ".png")));
            }
        }
        catch (IllegalArgumentException ex) {
                System.out.println("Invalid File Path or resource not found");
        }
    }
}
