/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class msoe.cs1021.lab2.BakedIngredient
 * Name: denise
 * Created 12/13/2020
 */

package msoe.cs1021.lab2;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * msoe.cs1021.lab2.BakedIngredient purpose:
 *
 * @author malisad
 * @version created on 12/13/2020 at 5:56 PM
 */
public class BakedIngredient implements Ingredient {
    private final Ingredient bakedIngredient;
    private final double expansionFactor;

    /**
     * constructor where values are initialised
     * @param bakedIngredient the ingredient being passed
     * @param expansionFactor the factor by which cups is expanded
     */
    public BakedIngredient(Ingredient bakedIngredient, double expansionFactor) {
        this.bakedIngredient = bakedIngredient;
        this.expansionFactor = expansionFactor;
    }

    @Override
    public double getCalories() {
        return bakedIngredient.getCalories();
    }

    @Override
    public double getCups() {
        return bakedIngredient.getCups() * expansionFactor;
    }

    @Override
    public String getName() {
        return bakedIngredient.getName();
    }

    @Override
    public boolean isDry() {
        return true;
    }

    @Override
    public void printRecipe() {
        String cupFormat;
        if(getCups() == 1){
            cupFormat = " Cup";
        } else {
            cupFormat = " Cups";
        }

        System.out.println("====================================================");
        System.out.println("Baked " + getName());
        System.out.println("====================================================");
        System.out.println("Ingredient to be baked: " + getName());
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + " " + cupFormat);
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories\n");
        bakedIngredient.printRecipe();
    }
}



