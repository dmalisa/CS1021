/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class ImageIO
 * Name: malisad
 * Created 2/4/2021
 */
package msoe.cs1021.lab8;

import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * ImageIO purpose:
 *
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
public class ImageIO {

    Image image;

    /**
     * constructor
     */
    public ImageIO() {
    }

    /**
     * reads regular images
     * @param path of image
     * @return image
     * @throws IllegalArgumentException error in input
     * @throws IOException error in the file
     */
    public Image read(Path path) throws IllegalArgumentException, IOException {
        String pathForImage, extension = "";
        pathForImage = path.toFile().getName();
        int index = pathForImage.lastIndexOf('.');
        if (index > 0) {
            extension = pathForImage.substring(index + 1);
        }
        if (extension.equals("msoe") || extension.equals("jpg") || extension.equals("png")) {
            if (extension.equals("msoe")) {
                readMSOE(path);
            } else {
                image = ImageUtil.readImage(path);
            }
        } else {
          System.out.println("file type ot supported");
       }
        return image;
    }

    /**
     *
     * @param image image being saved
     * @param path of image
     * @throws IllegalArgumentException if there is an error in input
     * @throws IOException if an error occurs
     */
    public void write(Image image, Path path) throws IllegalArgumentException, IOException {
        String pathForImage, extension = "";
        pathForImage = path.toFile().getName();
        int index = pathForImage.lastIndexOf('.');
        if (index > 0) {
            extension = pathForImage.substring(index + 1);
        }
        if (extension.equals("msoe") || extension.equals("jpg") || extension.equals("png")) {
            if (extension.equals("msoe")) {
                writeMSOE(image, path);
            } else {
                ImageUtil.writeImage(path, image);
            }
        }
    }

    /**
     * method that reads msoe image files
     * @param path of file
     * @throws IOException excepection
     */
    private void readMSOE(Path path) throws IOException {
        String imageType, dimension;
        int width, height;

        Color color;
        List<String> pixels = new ArrayList<>();

        Scanner in = new Scanner(path);
        imageType = in.nextLine();

        if (imageType.equals("MSOE")) {

            dimension = in.nextLine();
            String[] dimensions = dimension.split("\\s+");
            width = Integer.parseInt(dimensions[0]);
            height = Integer.parseInt(dimensions[1]);
            WritableImage msoe = new WritableImage(width, height);

            while (in.hasNextLine()) {
                pixels.add(in.nextLine());
            }
            for (int y = 0; y < height; y++) {
                String[] pixel = pixels.get(y).split("  ");
                for (int x = 0; x < width; x++) {
                    PixelWriter writer = msoe.getPixelWriter();
                    color = Color.web(pixel[x]);
                    writer.setColor(x, y, color);
                }
            }
            image = msoe;
        }
    }

    /**
     * method to write an msoe file
     * @param image msoeimage
     * @param path path path of file
     * @throws FileNotFoundException if the file isn't found
     */
    private void writeMSOE(Image image, Path path) throws FileNotFoundException {

        PrintWriter writer;
        Color color;
        String hexValue;

        writer = new PrintWriter(new File(String.valueOf(path)));
        writer.write("MSOE\r\n");
        String width = Integer.toString((int) image.getWidth());
        String height = Integer.toString((int) image.getHeight());
        writer.write(width + " " + height + "\r\n");

        for(int y = 0; y<image.getHeight();y++){
            for (int x = 0; x < image.getHeight();x++){
                PixelReader reader = image.getPixelReader();
                color = reader.getColor(x,y);
                hexValue = colorHex(color);
                writer.write(hexValue + "  ");
            }
            writer.write("\r\n");
        }
        writer.close();
    }

    /**
     * Inspired from
     * https://stackoverflow.com/questions/17925318/how-to-get-hex-web-string-from-javafx-colorpicker-color
     * @param color color
     * @return hex string of colour
     */
    private String colorHex(Color color) {

        int red = (int) (color.getRed()*255);
        String redString = Integer.toHexString(red);

        int blue = (int) (color.getBlue()*255);
        String blueString = Integer.toHexString(blue);

        int green = (int) (color.getGreen()*255);
        String greenString = Integer.toHexString(green);

        return "#" + redString.toUpperCase() + greenString.toUpperCase()
                + blueString.toUpperCase();
    }
}
