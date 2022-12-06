/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class LabeledTriangle
 * Name: malisad
 * Created 1/12/2021
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * LabeledTriangle purpose: the class descibes a labeled triangle
 *
 * @author malisad
 * @version created on 1/12/2021 at 8:47 AM
 */
public class LabeledTriangle extends Triangle {

    private final String name;

    /**
     * constructor for shape class
     *
     * @param x starting x-coordinate for the shape
     * @param y starting y-coordinate for the shape
     * @param base of the triangles
     * @param height of the triangles
     * @param color  the color of the shape
     */
    public LabeledTriangle(double x, double y, double base, double height, Color color,String name) {
        super(x, y, base, height, color);
        this.name = name;
    }

    @Override
    public void draw(WinPlotterFX plotter) {
       setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + base, y);
        plotter.drawTo(x+height/2,y+height);
        plotter.drawTo(x,y);
        plotter.printAt(x,y,name);
    }
}
