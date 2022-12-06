/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class msoe.cs1021.lab2.Mix
 * Name: denise
 * Created 12/10/2020
 */

package msoe.cs1021.lab2;



import java.util.ArrayList;
import java.util.List;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * msoe.cs1021.lab2.Mix purpose:
 *
 * @author malisad
 * @version created on 12/10/2020 at 3:58 PM
 */
public class Mix implements Ingredient {

    private final List<Ingredient> ingredients = new ArrayList<>();
    private final String name;

    /**
     * constructor to initialise the name
     * @param name of an ingredient
     */
    public Mix(String name){
        this.name = name;
    }

    /**
     * method to add ingredients to the array
     * @param ingredient to be added into the array
     */
    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    /**
     * method to determine if an ingredient is dry
     * @return whether an ingredient is dry or not
     */
    public boolean hasDryIngredient(){
        for (Ingredient ingredient : ingredients){
            if(ingredient.isDry()){
                return true;
            }
        }
        return false;
    }

    /**
     * method to determine if a method is dry
     *@return  whether an ingredient is wet or not
     */
    public boolean hasWetIngredient(){
        for (Ingredient ingredient : ingredients){
            if (!ingredient.isDry()){
                return true;
            }
        }
        return false;
    }

    @Override
    public double getCalories() {
        double totalCalories = 0;
        for (Ingredient ingredient : ingredients){
            totalCalories += ingredient.getCalories();
        }
        return totalCalories;
    }

    @Override
    public double getCups() {
        double totalVolume = 0;
        for (Ingredient ingredient : ingredients){
            totalVolume += ingredient.getCups();
        }
        return totalVolume;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean isDry(){
        return !hasWetIngredient();
    }

    @Override
    public void printRecipe(){

        String cupFormat;
        if(getCups() == 1){
            cupFormat = " Cup ";
        } else {
            cupFormat = " Cups ";
        }

        System.out.println("====================================================");
        System.out.println(getName());
        System.out.println("====================================================");
        System.out.println("Dry Ingredients: ");
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isDry()) {
                if (name.equals("Cookies")){
                    System.out.println(" "+ Math.round(ingredient.getCups())
                            + " " + cupFormat + " " + ingredient.getName());
                } else if (name.equals("Cake")){
                    System.out.println(" Baked " + ingredient.getName());
                } else if (name.equals("Batter")){
                    System.out.println(" "+ (ingredient.getCups())
                            + " " + cupFormat + " " + ingredient.getName());
                } else if(name.equals("Frosting")){
                    System.out.println(" "+ Math.round(ingredient.getCups())
                            + cupFormat + " " + ingredient.getName());
                } else {
                    System.out.println(" " + ingredient.getName());
                }
            }
        }
        System.out.println();
        System.out.println("Wet Ingredients: ");
        for (Ingredient ingredient : ingredients) {
            if (!(ingredient.isDry())){
                if (name.equals("Cookies")){
                    System.out.println(" "+ Math.round(ingredient.getCups())
                            + " " + cupFormat + " " + ingredient.getName());
                } else if(name.equals("Cake") || name.equals("Batter")){
                    System.out.println(ingredient.getCups() + cupFormat + ingredient.getName());
                } else {
                    System.out.println(" " + ingredient.getName());
                }
            }
        }
        System.out.println();
        System.out.println("Cups: " + CUP_FORMAT.format(getCups()) + cupFormat);
        System.out.println("Energy: " + Math.round(getCalories()) + " Calories");
        System.out.println();
        for (Ingredient ingredient : ingredients){
            ingredient.printRecipe();
        }
        System.out.println();
    }


}
