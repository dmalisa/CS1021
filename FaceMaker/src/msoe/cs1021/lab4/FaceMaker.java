/*
 * Course: CS1021 - FIXME
 * Winter FIXME
 * Lab 4 - Inheritance with Shapes
 * Name: FIXME
 * Created: FIXME
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This class draws a face out of a bunch of rectangles.
 *
 * @author taylor
 * @version 20191216
 */
public class FaceMaker extends Application {
    public static final int WINDOW_SIZE = 800;
    public static final int GRID_INCREMENT = WINDOW_SIZE / 10;
    public static final int HEAD_SIZE = 700;
    private static int choice;


    /**
     * Launches the JavaFX application
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        menu();
        System.out.println("Which shape would you like to use to generate a face?");
        choice = Integer.parseInt(input.nextLine());
        if (choice > 6){
            choice = (int) (5 * Math.random() + 1);
        }
        launch(args);
    }

    /**
     * Use the Shape class and its descendants to draw a face.
     *
     * @param stage Default stage given to a JavaFX program. Unused.
     */
    @Override
    public void start(Stage stage) {
        WinPlotterFX plotter = new WinPlotterFX();
        plotter.setWindowTitle("Face Maker");
        plotter.setWindowSize(WINDOW_SIZE, WINDOW_SIZE);
        plotter.setBackgroundColor(Color.BLACK.getRed(), Color.BLACK.getGreen(),
                Color.BLACK.getBlue());
        final boolean showGrid = true;
        plotter.setGrid(showGrid, GRID_INCREMENT, GRID_INCREMENT, Color.GRAY);
        Shape head = createHead();
        Shape leftEye = createLeftEye();
        Shape rightEye = createRightEye();
        Shape nose = createNose();
        Shape mouth = createMouth();

        head.draw(plotter);
        leftEye.draw(plotter);
        rightEye.draw(plotter);
        nose.draw(plotter);
        mouth.draw(plotter);

        plotter.showPlotter();
    }

    /**
     * Creates and returns a shape representing the head
     *
     * @return shape representing the head
     */
    private Shape createHead() {
        final int xLeft = (WINDOW_SIZE - HEAD_SIZE) / 2;
        final int yBottom = (WINDOW_SIZE - HEAD_SIZE) / 2;
        final String head = "head";
        if (choice == 1) {
            return new Rectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if (choice == 2) {
            return new Circle(xLeft, yBottom, HEAD_SIZE, Color.WHITE);
        } else if (choice == 3) {
            return new Triangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE);
        } else if (choice == 4) {
            return new LabeledRectangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, head);
        } else if (choice == 5) {
            return new LabeledTriangle(xLeft, yBottom, HEAD_SIZE, HEAD_SIZE, Color.WHITE, head);
        } else return randomShape();
    }

    /**
     * Creates and returns a shape representing the right eye
     *
     * @return shape representing the right eye
     */
    private Shape createRightEye() {
        final double scaleFactor = 0.15;
        final double size = scaleFactor * HEAD_SIZE;
        final double yBottom = WINDOW_SIZE / 2 + size * 3 / 2;
        final double xLeft = WINDOW_SIZE / 2 + size;
        final String rightEye = "right eye";

        if (choice == 1) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 2) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        } else if (choice == 3) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 4) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, rightEye);
        } else if (choice == 5) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, rightEye);
        } else return randomShape();
    }

    /**
     * Creates and returns a shape representing the left eye
     *
     * @return shape representing the left eye
     */
    private Shape createLeftEye() {
        final double scaleFactor = 0.15;
        final double size = scaleFactor * HEAD_SIZE;
        final double yBottom = WINDOW_SIZE / 2 + size * 3 / 2;
        final double xLeft = WINDOW_SIZE / 2 - size * 2;
        final String leftEye = "left eye";

        if (choice == 1) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 2) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        } else if (choice == 3) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 4) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, leftEye);
        } else if (choice == 5) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, leftEye);
        } else return randomShape();

    }

    /**
     * Creates and returns a shape representing the nose
     *
     * @return shape representing the nose
     */
    private Shape createNose() {
        final double scaleFactor = 0.2;
        final double size = scaleFactor * HEAD_SIZE;
        final double xLeft = WINDOW_SIZE / 2 - size / 2;
        final double yBottom = (WINDOW_SIZE) / 2;
        final String noseName = "nose";

        if (choice == 1) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 2) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        } else if (choice == 3) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 4) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, noseName);
        } else if (choice == 5) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, noseName);
        } else return randomShape();

    }

    /**
     * Creates and returns a shape representing the mouth
     *
     * @return shape representing the mouth
     */
    private Shape createMouth() {
        final double scaleFactor = 0.3;
        final double size = scaleFactor * HEAD_SIZE;
        final double xLeft = WINDOW_SIZE / 2 - size / 2;
        final double yBottom = (WINDOW_SIZE) / 2 - size * 3 / 2;
        final String mouthName = "mouth";

        if (choice == 1) {
            return new Rectangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 2) {
            return new Circle(xLeft, yBottom, size, Color.WHITE);
        } else if (choice == 3) {
            return new Triangle(xLeft, yBottom, size, size, Color.WHITE);
        } else if (choice == 4) {
            return new LabeledRectangle(xLeft, yBottom, size, size, Color.WHITE, mouthName);
        } else if (choice == 5) {
            return new LabeledTriangle(xLeft, yBottom, size, size, Color.WHITE, mouthName);
        } else return randomShape();
    }

    /**
     * menu for user to
     * choose from
     */
    private static void menu() {
        System.out.println("Which shape would you like to use to generate a face?");
        System.out.println("1.Rectangle — draws face using rectangles\n" +
                "2.Circle — draws face using circles for each facial component\n" +
                "3.Triangle — draws face using triangles for each facial component\n" +
                "4.Labeled Rectangle — draws face using labeled rectangles for each facial component\n" +
                "5.Labeled Triangle — draws face using labeled triangles for each facial component\n" +
                "6.Random — draws face using one of the previous shapes for each facial component\n");
    }

    /**
     * to generate random face shapes
     * @return a random shape for each
     * component of face
     */
    private Shape randomShape() {
        choice = (int) (5 * Math.random() + 1);
        if (choice == 1) {
            return createHead();
        }
        choice = (int) (5 * Math.random() + 1);
        if (choice == 2) {
            return createLeftEye();
        }
        choice = (int) (5 * Math.random() + 1);
        if (choice == 3) {
            return createRightEye();
        }
        choice = (int) (5 * Math.random() + 1);
        if (choice == 4) {
            return createNose();
        }
        choice = (int) (5 * Math.random() + 1);
        if (choice == 5) {
            return createMouth();
        } else return null;
    }

}
