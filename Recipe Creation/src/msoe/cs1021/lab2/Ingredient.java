/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class msoe.cs1021.lab2.BakedIngredient
 * Name: denise
 * Created 12/13/2020
 */
package msoe.cs1021.lab2;

import java.text.DecimalFormat;

/**
 * interface for methods used in the baking project
 */
public interface Ingredient {
    /**
     *used to format the amount of cups
     */
    DecimalFormat CUP_FORMAT = new DecimalFormat("##.##");

    /**
     * gets the calories for ingredients
     * @return the total number of calories in individual ingredients
     */
    double getCalories();

    /** the amount of cups of that ingredient
     *@return the number of cups used for each ingredient
     */
    double getCups();

    /**
     * gets the name of the ingredient used
     * @return the name of the ingredients
     */
    String getName();

    /**
     * used to determine whether an ingredient is wet or dry
     * @return whether the ingredient is dry
     */
    boolean isDry();

    /**
     * prints the recipe
     */
    void printRecipe();

}
