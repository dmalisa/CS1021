/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class WavGenerator
 * Name: denise
 * Created 12/3/2020
 */
package msoe.cs1011.lab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * WavGenerator purpose:
 *
 * @author malisad
 * @version created on 12/3/2020 at 12:15 PM
 */
public class WavGenerator {

    private static Scanner input = new Scanner(System.in);
    private static String optionChosen; // the option chosen by the user

    public static void main(String[] args) {
        option(input);
    }

    private static void menu() {
        System.out.println("Menu: \n0: program exit\n1: reversing audio files." +
                "\n2: creates a wave note");
    }

    private static void option(Scanner input) {

        String option;

        do {
            menu();
            System.out.println("Please choose an option between: 0,1,2");
            option = input.nextLine();
            System.out.println(" you picked option " + option);

            optionChosen = (option);
            choice();
        } while (!(option.equals("0")));


    }

    private static void choice() {
        String fileName;
        double frequency;


        if (optionChosen.equals("1")) {

            ArrayList<Double> reversed = new ArrayList<>(); // array for reversed file samples
            ArrayList<Double> originalSamples; // array for original samples

            System.out.println("Please enter a file name");
            fileName = input.nextLine();


            WavFile newWave = new WavFile(fileName + ".wav");
            WavFile output = new WavFile(fileName + "Rev.wav", newWave.getNumChannels(), // waveout
                    newWave.getNumFrames(), newWave.getValidBits(), newWave.getSampleRate());

            originalSamples = newWave.getSamples();

            for (int x = originalSamples.size() - 1; x > -1; x--) {
                reversed.add(originalSamples.get(x));
            }
            output.setSamples(reversed);
            output.close();
            option(input);
        }

        if (optionChosen.equals("2")) {
            System.out.println("Please enter a file name and a frequency (enter the frequency in a newline)");
            fileName = input.nextLine();
            frequency = Integer.parseInt(input.nextLine());

            WavFile output = new WavFile(fileName + ".wav", 1, 8000, 8, 8000);

            ArrayList<Double> newWave = new ArrayList<>(); // array for tone created

            for (double i = 0; i < output.getSampleRate(); i++) {
                double sampleRate = output.getSampleRate();
                double toneCreated = Math.sin(2 * Math.PI * i * (frequency / sampleRate));
                newWave.add(toneCreated);
            }
            output.setSamples(newWave);
            output.close();
            option(input);
        }
    }

}
