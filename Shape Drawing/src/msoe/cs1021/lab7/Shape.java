/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Shape
 * Name: malisad
 * Created 1/28/2021
 */
package msoe.cs1021.lab7;

import edu.msoe.winplotterfx.WinPlotterFX;
import javafx.scene.paint.Color;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Shape purpose:
 *
 * @author malisad
 * @version created on 1/28/2021 at 9:16 AM
 */
public abstract class Shape {

    private Color color;
    protected final double x;
    protected final double y;

    /**
     * constructor for shape class
     * @param x starting x-coordinate for the shape
     * @param y starting y-coordinate for the shape
     * @param color the color of the shape
     */
    public Shape(double x,double y,Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(WinPlotterFX plotter);

    /**
     * used to set pen color
     * @param plotter used to set color
     */
    public void setPenColor(WinPlotterFX plotter){
        plotter.setPenColor(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
     * method to set color
     * @param color sets color
     */
    public void setColor(Color color){
        this.color = color;
    }














}
