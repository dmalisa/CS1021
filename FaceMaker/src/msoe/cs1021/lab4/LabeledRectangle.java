/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class LabeledRectangle
 * Name: malisad
 * Created 1/12/2021
 */
package msoe.cs1021.lab4;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * LabeledRectangle purpose: class that describes a labled rectangle
 *
 * @author malisad
 * @version created on 1/12/2021 at 7:01 AM
 */
public class LabeledRectangle extends Rectangle {

    private final String name;

    /**
     * constructor for rectangle object
     *
     * @param x      the lower left corner x-value of the rectangle
     * @param y      the lower left corner y-value of the rectangle
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @param color  the color of the rectangle
     */
    public LabeledRectangle(double x, double y, double width, double height, Color color, String name) {
        super(x, y, width, height, color);
        this.name = name;
    }

    /**
     * used to draw labeled rectangle
     * @param plotter used to draw rectangle
     */
    @Override
    public void draw(WinPlotterFX plotter) {
        setPenColor(plotter);
        plotter.drawPoint(x, y);
        plotter.drawTo(x + width, y);
        plotter.drawTo(x + width, y + width);
        plotter.drawTo(x, y + width);
        plotter.drawTo(x,y);
        plotter.printAt(x,y,name);
    }

}
