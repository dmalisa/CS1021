/*
 * Course: CS1021
 * Term Winter 2020-2021
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
package msoe.cs1021.lab9;

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
 *
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
public class Lab9 extends Application {

   public Stage firstStage;
   public Stage secondStage;

   public Lab9Controller c1;
   public FilterController c2;

    /**
     * start method
     *
     * @param primaryStage stage
     * @throws Exception for all types of exceptions
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage kernelStage = new Stage();
       firstStage = primaryStage;
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("Lab9.fxml"));
        Parent root1 = loader1.load();
        c1 = loader1.getController();
        c1.setModel(this);

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("Kernel.fxml"));
        Parent root2 =loader2.load();
        c2 = loader2.getController();

        c2.setC1(c1);
        secondStage = kernelStage;
        primaryStage.setTitle("Image Manipulator");
        primaryStage.setScene(new Scene(root1));

        kernelStage.setTitle("Filter Kernel");
        kernelStage.setScene(new Scene(root2));
        primaryStage.show();
    }

    /**
     * main method
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
