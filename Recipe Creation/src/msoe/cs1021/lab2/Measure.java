/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class Measure
 * Name: denise
 * Created 12/14/2020
 */
package msoe.cs1021.lab2;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * Measure purpose:
 *
 * @author malisad
 * @version created on 12/14/2020 at 5:14 PM
 */
public class Measure implements Ingredient {

    private final int numerator;
    private final int denominator;
    private final Ingredient measuredIngredient;

    /**
     * constructor to initialise values
     * @param numerator of the fraction
     * @param denominator of the fraction
     * @param measuredIngredient the ingredient that has been measured
     */
    public Measure(int numerator, int denominator, Ingredient measuredIngredient){
        this.numerator = numerator;
        this.denominator = denominator;
        this.measuredIngredient = measuredIngredient;
    }

    /**
     * method initialises denominator to 1 if nothing is passed in
     * @param numerator of the fraction
     * @param measuredIngredient the ingredient that has been measured
     */
    public Measure(int numerator, Ingredient measuredIngredient){
        this.numerator = numerator;
        denominator = 1;
        this.measuredIngredient = measuredIngredient;
    }


    @Override
    public double getCalories() {
        double result;
        result = ((double) numerator / denominator) *
                (measuredIngredient.getCalories() / measuredIngredient.getCups());
        return result;
    }

    @Override
    public double getCups() {
        double vol;
        vol = ((double) numerator / denominator);
        return vol;
    }

    @Override
    public String getName() {
        return measuredIngredient.getName();
    }

    @Override
    public boolean isDry() {
        return measuredIngredient.isDry();
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
        System.out.println(" " + Math.round(getCups()) + cupFormat + " " + getName());
        System.out.println("====================================================");
        System.out.println("Measured ingredient: " + getName());
        System.out.println(formatQuantity());
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories");
        System.out.println();
        measuredIngredient.printRecipe();

    }

    private String formatQuantity(){
        String cupFormat;
        if(getCups() == 1){
            cupFormat = " Cup";
        } else {
            cupFormat = " Cups";
        }

        return "Quantity: " + CUP_FORMAT.format(getCups()) + cupFormat +
                " (" + (getCups()) + cupFormat + " )";
    }
}


