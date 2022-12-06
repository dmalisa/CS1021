/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class msoe.cs1021.lab2.BakedIngredient
 * Name: denise
 * Created 12/13/2020
 */

package msoe.cs1021.lab2;




/**
 * Driver class that illustrates making evaporated milk by baking milk.
 */
public class EvaporatedMilk {
    /** The milk to be baked */
    private static final Ingredient MILK =
            new SimpleIngredient(103.0, 1, false, "Milk");

    /** Ratio of volume after evaporating to before */
    public static final double DEHYDRATION_FACTOR = 0.2;

    public static void main(String[] args) {
        Ingredient milk = MILK;
        Ingredient evaporatedMilk = new BakedIngredient(milk, DEHYDRATION_FACTOR);
        evaporatedMilk.printRecipe();
    }
}