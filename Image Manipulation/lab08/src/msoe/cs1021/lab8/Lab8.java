/*
 * Course: CS1021
 * Term Winter 2020-2021
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
package msoe.cs1021.lab8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Lab8 purpose:
 * contains start and main methods
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
public class Lab8 extends Application {

    /**
     * start method
     * @param primaryStage stage
     * @throws Exception for all types of exceptions
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("lab8.fxml"));
        primaryStage.setTitle("Image Manipulator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
