/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class ShowFilterController
 * Name: malisad
 * Created 2/13/2021
 */
package msoe.cs1021.lab9;

import edu.msoe.cs1021.ImageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;


/**
 * Course: CS1021
 * Term Winter 2020-2021
 * ShowFilterController purpose:
 *
 * @author malisad
 * @version created on 2/13/2021 at 5:36 PM
 */
public class FilterController {


    @FXML
    private TextField firstNumber;
    @FXML
    private TextField secondNumber;
    @FXML
    private TextField thirdNumber;
    @FXML
    private TextField forthNumber;
    @FXML
    private TextField fifthNumber;
    @FXML
    private TextField sixthNumber;
    @FXML
    private TextField seventhNumber;
    @FXML
    private TextField eighthNumber;
    @FXML
    private TextField ninthNumber;

    Double[] enteredValues;
    double sum = 0.0;
    Lab9Controller c1;


    /**
     * method that implements the blend
     */
    @FXML
    public void blur() {
        firstNumber.setText("0");
        secondNumber.setText("1");
        thirdNumber.setText("0");
        forthNumber.setText("1");
        fifthNumber.setText("5");
        sixthNumber.setText("1");
        seventhNumber.setText("0");
        eighthNumber.setText("1");
        ninthNumber.setText("0");

    }

    /**
     * method that implements the sharpen
     */
    @FXML
    public void sharpen() {

        firstNumber.setText("0");
        secondNumber.setText("-1");
        thirdNumber.setText("0");
        forthNumber.setText("-1");
        fifthNumber.setText("5");
        sixthNumber.setText("-1");
        seventhNumber.setText("0");
        eighthNumber.setText("-1");
        ninthNumber.setText("0");

    }

    /**
     * applies the filters to the image
     *
     * @param event not used
     */
    @FXML
    public void apply(ActionEvent event) {

        Image originalImage = c1.getImage();

        if(c1.file != null) {
            try {
                enteredValues();
            } catch (NumberFormatException e) {
                System.out.println("Filter kernel is empty");
            }

            double[] kernel = new double[9];
            if (!(sum <= 0)) {
                for (int x = 0; x < 9; x++) {
                    kernel[x] = enteredValues[x] / sum;
                }
                Image blurredImage = ImageUtil.convolve(originalImage, kernel);
                c1.setImage(blurredImage);
            } else {
                System.out.println("sum of filter numbers is negative");
            }
        } else {
            System.out.println("No image was chosen");
        }
    }

    /**
     * values entered into the kernel
     * @throws NumberFormatException if something other than a number is passed in
     */
    private void enteredValues() throws NumberFormatException {

        double num1 = Double.parseDouble(firstNumber.getText());
        double num2 = Double.parseDouble(secondNumber.getText());
        double num3 = Double.parseDouble(thirdNumber.getText());
        double num4 = Double.parseDouble(forthNumber.getText());
        double num5 = Double.parseDouble(fifthNumber.getText());
        double num6 = Double.parseDouble(sixthNumber.getText());
        double num7 = Double.parseDouble(seventhNumber.getText());
        double num8 = Double.parseDouble(eighthNumber.getText());
        double num9 = Double.parseDouble(ninthNumber.getText());

        enteredValues = new Double[]{num1, num2, num3, num4, num5, num6, num7, num8, num9};
        for (Double values : enteredValues) {
            sum += values;
        }
    }

    /**
     * setting the primary controller in the second controller
     * @param c1 controller 1
     */
    public void setC1(Lab9Controller c1) {
        this.c1 = c1;
    }
}
