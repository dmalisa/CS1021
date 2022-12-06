/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Rectangle
 * Name: malisad
 * Created 1/7/2021
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Rectangle purpose: create rectangles
 *
 * @author malisad
 * @version created on 1/7/2021 at 11:49 AM
 */
public class Rectangle extends Shape {

    protected final double height;
    protected final double width;

    /**
     * constructor for rectangle object
     *
     * @param x      the lower left corner x-value of the rectangle
     * @param y      the lower left corner y-value of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param color  the color of the rectangle
     */
    public Rectangle(double x, double y, double width, double height, Color color) {
        super(x, y, color);
        this.height = height;
        this.width = width;
    }

    /**
     *method that draws rectangle
     * @param plotter used to draw rectangle
     */
    @Override
    public void draw(WinPlotterFX plotter) {
    setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + width);
        plotter.drawTo(x, y + width);
        plotter.drawTo(x, y);
    }

}
