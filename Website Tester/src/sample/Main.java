package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    /**
     *
     * @param primaryStage stage that will hold the scene
     * @throws IOException exception that could be throw
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Lab6.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Website Tester");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * main method for program
     * @param args passed into launch
     */
    public static void main(String[] args) {
        launch(args);
    }

}
