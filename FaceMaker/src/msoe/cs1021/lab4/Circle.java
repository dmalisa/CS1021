/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Circle
 * Name: malisad
 * Created 1/11/2021
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Circle purpose: create circle face
 *
 * @author malisad
 * @version created on 1/11/2021 at 9:30 AM
 */
public class Circle extends Shape {

    private final double RADIUS;

    /**
     *
     * @param x origin
     * @param y origin
     * @param radius the radius of the radius
     * @param color the color of the shape
     */
    public Circle(double x, double y, double radius, Color color) {
        super(x, y, color);
        this.RADIUS = radius;
    }

    /**
     *
     * @param x the origin
     * @param y the origin
     * @param width of plane
     * @param height of plane
     * @param color color of shape
     * @param radius of the circle
     */
    public Circle(double x, double y, double width, double height, Color color, double radius) {
        super(x, y, color);
        RADIUS = radius;
    }

    /**
     * used to draw circles
     * @param plotter used to draw circles
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
     //   plotter.drawPoint(x, y);
        for (int degrees = 0; degrees < 361; degrees++) {
            plotter.moveTo((RADIUS / 2) * Math.cos(Math.toRadians(degrees)) + x,
                    (RADIUS / 2) * Math.sin(Math.toRadians(degrees)) + y);
            plotter.drawTo((RADIUS / 2) * Math.cos(Math.toRadians(degrees)) + x,
                    (RADIUS / 2) * Math.sin(Math.toRadians(degrees)) + y);
        }
    }
}
