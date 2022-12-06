/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Point
 * Name: malisad
 * Created 1/28/2021
 */
package msoe.cs1021.lab7;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Point purpose:
 *
 * @author malisad
 * @version created on 1/28/2021 at 11:37 AM
 */
public class Point extends Shape {

    /**
     * plotter class constructor
     * @param x coordinate
     * @param y coordinate
     * @param color colour of pen for shape
     * @throws IllegalArgumentException if a wrong parameter value is put
     */
    public Point(double x, double y, Color color) throws IllegalArgumentException {
        super(x, y, color);
    }

    /**
     * draws point
     * @param plotter used to draw the shape
     */
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.drawPoint(x, y);
    }
}
