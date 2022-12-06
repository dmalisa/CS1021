/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Triangle
 * Name: malisad
 * Created 1/12/2021
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Triangle purpose: claas that describes a triangle
 *
 * @author malisad
 * @version created on 1/12/2021 at 8:07 AM
 */
public class Triangle extends Shape {

    protected final double base;
    protected final double height;

    /**
     * constructor for shape class
     *
     * @param x starting x-coordinate for the shape
     * @param y starting y-coordinate for the shape
     * @param base base of triangles
     * @param height of the triangles
     * @param color the color of the shape
     */
    public Triangle(double x, double y, double base, double height, Color color) {
        super(x, y, color);
        this.base = base;
        this.height = height;
    }

    /**
     * class to draw triangles
     * @param plotter used to draw triangles
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x+height/2,y+height);
        plotter.drawTo(x,y);
    }
}
