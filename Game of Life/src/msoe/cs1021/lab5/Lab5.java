/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Lab5
 * Name: malisad
 * Created 1/14/2021
 */
package msoe.cs1021.lab5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Lab5 purpose: contains the components to make the
 * application display and register the FXML components.
 *
 * @author malisad
 * @version created on 1/14/2021 at 12:01 PM
 */
public class Lab5 extends Application {

    private final Pane gamePane = new Pane();
    private final Label alive = new Label("alive: ");
    private final Label dead = new Label("dead: ");
    private final TextField firstText = new TextField();
    private final TextField secondText = new TextField();
    private final Button randomize = new Button("randomize");
    private final Button iteration = new Button("iteration");
    public LifeGrid lifeGrid;

    VBox vBox = new VBox();
    HBox hBox = new HBox(6);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        Scene scene = new Scene(pane);

        createContents(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        randomize.setOnAction(this::response);
        iteration.setOnAction(this::response);
        gamePane.setOnMouseClicked(this::playerClicks);
    }

    private void createContents(FlowPane pane) {
        hBox.getChildren().addAll(randomize,iteration,alive,firstText,dead,secondText);
       lifeGrid = new LifeGrid(gamePane,850,500);
       vBox.getChildren().addAll(gamePane,hBox);
       vBox.setAlignment(Pos.CENTER);
       pane.getChildren().addAll(vBox);
       pane.setAlignment(Pos.CENTER);

    }

    /**
     * method that contains the actions
     * performed when the buttons are pressed
     * @param e the action event
     */
    private void response(ActionEvent e){
        if (e.getSource() == randomize) {
            lifeGrid.randomize();
            firstText.setText(Integer.toString(lifeGrid.alive()));
            secondText.setText(Integer.toString(lifeGrid.dead()));
        }
        if (e.getSource() == iteration){
            lifeGrid.iterate();
            firstText.setText(Integer.toString(lifeGrid.alive()));
            secondText.setText(Integer.toString(lifeGrid.dead()));
        }
    }

    /**
     * method that makes cells negative or
     * positive when clicked by user
     * @param e mouseclick event
     */
    private void playerClicks(MouseEvent e){
        firstText.setText(Integer.toString(lifeGrid.getAliveCells()));
        secondText.setText(Integer.toString(lifeGrid.getDeadCells()));
    }











}
