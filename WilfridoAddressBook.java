
/** This Assignment #8 Task 17.9 Displying Images in a GridPane object*/
/** Author Wilfrido Toribio Espinosa */

package wilfridoaddressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WilfridoAddressBook extends Application {
    // Text fileds nodes
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();
    
    // Buttons nodes
    private Button btAdd = new Button("Add");
    private Button btFirst = new Button("First");
    private Button btNext = new Button("Next");
    private Button btPrev = new Button("Prev");
    private Button btLast = new Button("Last");
    private Button btUpdate = new Button("Update");
    private static final char DEFAULT_SEPARATOR = ',';
    private static int index = 1;
    
    // Arrays List 
    ArrayList<String> bookList = new ArrayList<>();
    ArrayList<ContactBook> contactList = new ArrayList<>(Arrays.asList());
    java.io.File file = new java.io.File("AddressBook.csv");
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // The GrodPane to hold all Labels and Text nodes UI-Control
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        
         // Set of UI Text fileds
        gridPane.add(new Label("Full Name:"), 0, 0);
        gridPane.add(tfName, 1, 0);
        gridPane.add(new Label("Street:"), 0, 1);
        gridPane.add(tfStreet , 1, 1);
        gridPane.add(new Label("City:"), 0, 2);
        gridPane.add(tfCity, 1, 2);
        gridPane.add(new Label("State:"), 2, 2);
        gridPane.add(tfState, 3, 2);
        gridPane.add(new Label("Zip:"), 4, 2);
        gridPane.add(tfZip, 5, 2);
       
        //Buttons nodes
        Button btAdd = new Button("Add");
        Button btFirst = new Button("First");
        Button btNext = new Button("Next");
        Button btPrev = new Button("Prev");
        Button btLast = new Button("Last");
        Button btUpdate = new Button("Update");
       
        //Horizontal Box to hold all the buttons 
        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(btAdd,btFirst,btNext,btPrev,btLast,btUpdate);
        hBox.setAlignment(Pos.CENTER);
       
        //BorderPane to Organize in side the GridPane and the Horizontal Box
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox); //borderPane.setTop(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);
      
        // Create listeners to handle the button events
        // For the Previous and Next button you might need to click them several times to make work 
        btAdd.setOnAction(e -> {
            try {
                addContact();
                ObjectFile(file);
            } catch (IOException ex) {
                System.out.println("I/O Exception Eroros");
            } catch (Exception ex) {
                System.out.println("Exception Eroros");
            }
        });
        btFirst.setOnAction(e -> {
            try {
            firstContact();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index Out Of Bounds Exception Eroros");
            }
                });
        btNext.setOnAction(e -> {
            try {
            nextContact(++index);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index Out Of Bounds Exception Eroros");
            }
                });
        btPrev.setOnAction(e -> {
            try {
            previousContact(--index);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index Out Of Bounds Exception Eroros");
            }
                });  
        btLast.setOnAction(e -> {
            try {
            lastContact();
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Index Out Of Bounds Exception Eroros");
            }
                });
        btUpdate.setOnAction(e -> {
            try {
                updateContact(index);
                ObjectFile(file);
            } catch (IOException ex) {
                System.out.println("I/O Exception Eroros");
            } catch (Exception ex) {
                System.out.println("Exception Eroros");
            }
        });
        Scene scene = new Scene(borderPane,650, 150);
        primaryStage.setTitle("AddressBook!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
     public  void refreshContact() {
        // Cleaning the UI Text fileds
        tfName.setText(" ");
        tfStreet.setText(" ");
        tfCity.setText(" ");
        tfState.setText(" ");
        tfZip.setText(" ");
    }
    public  void addContact() throws IOException {    
        //The file object
        java.io.File file = new java.io.File("AddressBook.csv");
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        
        String line = tfName.getText() + DEFAULT_SEPARATOR + tfStreet.getText() + DEFAULT_SEPARATOR + tfCity.getText() + DEFAULT_SEPARATOR + 
                tfState.getText()+ DEFAULT_SEPARATOR + tfZip.getText();
        bookList.add(line);
        
        System.out.println(bookList);
        
        //Writing the local file
        for (String temp : bookList) {
            output.println(temp);
        }
        //Close file
        output.close();
        System.out.println("Is it absolute? " + file.getAbsolutePath());
        System.out.println("The file has " + file.length() + " bytes");
        refreshContact();
 }
    public  void firstContact() throws IndexOutOfBoundsException {
        tfName.setText(contactList.get(0).getFullName());
        tfStreet.setText(contactList.get(0).getStreet());
        tfCity.setText(contactList.get(0).getCity());
        tfState.setText(contactList.get(0).getState());
        tfZip.setText(contactList.get(0).getZip());
    }
    public  void nextContact(int index) throws IndexOutOfBoundsException{
        if (index > contactList.size() -1){
            index = 0;
        }
        tfName.setText(contactList.get(index).getFullName());
        tfStreet.setText(contactList.get(index).getStreet());
        tfCity.setText(contactList.get(index).getCity());
        tfState.setText(contactList.get(index).getState());
        tfZip.setText(contactList.get(index).getZip());
    }
    public  void previousContact(int index) throws IndexOutOfBoundsException{
        if ((index < 0 ) || (index > contactList.size() -1 )) {
            index = 0;
        }
        tfName.setText(contactList.get(index).getFullName());
        tfStreet.setText(contactList.get(index).getStreet());
        tfCity.setText(contactList.get(index).getCity());
        tfState.setText(contactList.get(index).getState());
        tfZip.setText(contactList.get(index).getZip());
    }
    public  void lastContact() throws IndexOutOfBoundsException{
        int index = contactList.size() -1;
        tfName.setText(contactList.get(index).getFullName());
        tfStreet.setText(contactList.get(index).getStreet());
        tfCity.setText(contactList.get(index).getCity());
        tfState.setText(contactList.get(index).getState());
        tfZip.setText(contactList.get(index).getZip());
    }
    public  void updateContact(int index) throws IOException {
        //The file object
        java.io.File file = new java.io.File("AddressBook.csv");
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        
        String line = tfName.getText() + DEFAULT_SEPARATOR + tfStreet.getText() + DEFAULT_SEPARATOR + tfCity.getText() + DEFAULT_SEPARATOR + 
            tfState.getText()+ DEFAULT_SEPARATOR + tfZip.getText();
        
        //Writing in the ArrayList
        bookList.add(line);
        
        System.out.println(bookList);
        
        // Writing the file in local disk
        for (String temp : bookList) {
            output.println(temp);
        }
        //Close file
        output.close();
        System.out.println("Is it absolute? " + file.getAbsolutePath());
        System.out.println("The file has " + file.length() + " bytes");
        refreshContact();
    }
     public void ObjectFile(File file) throws IOException {
        String line = "";
        String csvSplitBy = ","; //regular expressions ("\\s+")

        try (BufferedReader br = new BufferedReader(new FileReader("AddressBook.csv"))) {
            while ((line = br.readLine()) != null) {
                // Use comma as separator
                String[] string = line.split(csvSplitBy);
                contactList.add(new ContactBook(string[0],string[1],string[2],string[3],string[4]));
                System.out.println("Name: " + string[0] + ", " + "Street: " +  string[1] + ", "
                    + "City: " + string[2] + ", " +  "State: " + string[3] + ", " + "Zip: " + string[4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}