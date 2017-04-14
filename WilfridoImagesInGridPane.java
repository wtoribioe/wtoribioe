
/** This Assignment #6 Task 14.1 Displying Images in a GridPane object*/
/** Author Wilfrido Toribio Espinosa */

package wilfridoimagesingridpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class WilfridoImagesInGridPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a pane to hold the images views
        String Canada = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4qmI0t0di1jkY8VdeNVnCad5xVIjZHGFGzRNwbl8soUzWNcs1E7axSutWLQ";
        String DR = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRY_1q15arlqAJDJi6s5zn6ETBzI0DicY7It3aO68UfKaxZUEE_gwNOABo";
        String Barbado = "http://www.barbados.org/images/barbados-flag.png";
        String Jamica = "http://jis.gov.jm/media/flag-640x425.jpg";
	
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5,12.5,13.5,14.5));
        pane.setHgap(10.10);
        pane.setVgap(10.10);

	// Place nodes in the pane
	pane.add(new ImageView(new Image(Canada)), 0, 0);
	pane.add(new ImageView(new Image(DR)), 1, 0);
	pane.add(new ImageView(new Image(Barbado)), 0, 1);
	pane.add(new ImageView(new Image(Jamica)), 1, 1);
        
	// Create a scene and place it in the stage
	Scene scene = new Scene(pane);
	primaryStage.setTitle("Displaying Images"); 
	primaryStage.setScene(scene); 
	primaryStage.show(); 
        }

    //The main method is only needed for the IDE with limited JavaFX support.
    public static void main(String[] args) {
        Application.launch(args);
    }
}