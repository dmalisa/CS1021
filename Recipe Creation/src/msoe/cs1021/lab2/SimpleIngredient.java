/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class msoe.cs1021.lab2.SimpleIngredient
 * Name: denise
 * Created 12/10/2020
 */

package msoe.cs1021.lab2;


/**
 * Course: CS1021
 * Term Winter 2020-2021
 * msoe.cs1021.lab2.SimpleIngredient purpose:
 *
 * @author malisad
 * @version created on 12/10/2020 at 12:08 PM
 */
public class SimpleIngredient implements Ingredient {
    private final double calories;
    private final double cups;
    private final boolean isDry;
    private final String name;

    /**
     * constructor to initialise values
     * @param calories total calories in ingredients
     * @param cups number of cups in an ingredient
     * @param isDry whether an ingredient is dry or not
     * @param name of the ingredient
     */
    public SimpleIngredient(double calories, double cups, boolean isDry, String name) {
        this.calories = calories;
        this.cups = cups;
        this.isDry = isDry;
        this.name = name;
    }


    @Override
    public double getCalories() {
        return calories;
    }

    @Override
    public double getCups() {
        return cups;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDry() {
        return isDry;
    }

    @Override
    public void printRecipe() {
        String cupFormat;
        if (getCups() == 1) {
            cupFormat = " Cup";
        } else {
            cupFormat = " Cups";
        }
        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + cupFormat);
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories");
        System.out.println();
    }
}
