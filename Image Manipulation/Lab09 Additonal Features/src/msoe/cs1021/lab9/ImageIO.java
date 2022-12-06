/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class ImageIO
 * Name: malisad
 * Created 2/4/2021
 */
package msoe.cs1021.lab9;

import edu.msoe.cs1021.ImageUtil;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    Scanner in;

    /**
     * constructor
     */
    public ImageIO() {
    }

    /**
     * reads regular images
     *
     * @param path of image
     * @return image
     * @throws IllegalArgumentException error in input
     * @throws IOException              error in the file
     */
    public Image read(Path path) throws IllegalArgumentException, IOException {
        String pathForImage, extension = "";
        pathForImage = path.toFile().getName();
        int index = pathForImage.lastIndexOf('.');
        if (index > 0) {
            extension = pathForImage.substring(index + 1);
        }
        if (extension.equals("msoe") || extension.equals("jpg") || extension.equals("png")
                || extension.equals("bmsoe")) {
            if (extension.equals("msoe")) {
                readMSOE(path);
            } else if (extension.equals("bmsoe")) {
                readBMSOE(path);
            } else {
                image = ImageUtil.readImage(path);
            }
        } else {
            System.out.println("file type not supported");
        }
        return image;
    }

    /**
     * @param image image being saved
     * @param path  of image
     * @throws IllegalArgumentException if there is an error in input
     * @throws IOException              if an error occurs
     */
    public void write(Image image, Path path) throws IllegalArgumentException, IOException {
        String pathForImage, extension = "";
        pathForImage = path.toFile().getName();
        int index = pathForImage.lastIndexOf('.');
        if (index > 0) {
            extension = pathForImage.substring(index + 1);
        }
        if (extension.equals("msoe") || extension.equals("jpg") || extension.equals("png")
                || extension.equals("bmsoe")) {
            if (extension.equals("msoe")) {
                writeMSOE(image, path);
            } else if (extension.equals("bmsoe")) {
                writeBMSOE(image, path);
            } else {
                ImageUtil.writeImage(path, image);
            }
        }
    }

    /**
     * method that reads msoe image files
     *
     * @param path of file
     * @throws IOException excepection
     */
    private void readMSOE(Path path) throws IOException {
        String imageType;
        String dimension;
        int width;
        int height;

        Color color;
        List<String> pixels = new ArrayList<>();

        in = new Scanner(path);
        imageType = in.nextLine();

        if (imageType.equals("MSOE")) {

            dimension = in.nextLine();
            String[] dimensions = dimension.split(" ");
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
     *
     * @param image msoeimage
     * @param path  path path of file
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

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PixelReader reader = image.getPixelReader();
                color = reader.getColor(x, y);
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
     *
     * @param color color
     * @return hex string of colour
     */
    private static String colorHex(Color color) {

        int red = (int) (color.getRed() * 255);
        String redString = Integer.toHexString(red);

        int blue = (int) (color.getBlue() * 255);
        String blueString = Integer.toHexString(blue);

        int green = (int) (color.getGreen() * 255);
        String greenString = Integer.toHexString(green);

        return "#" + redString.toUpperCase() + greenString.toUpperCase()
                + blueString.toUpperCase();
    }

    /**
     * method that reads an image saved as a bmsoe file
     * @param path path of the image being read
     * @throws IOException if a wrong input has been entered
     */
    private void readBMSOE(Path path) throws IOException {
        String imageType;
        int width;
        int height;

        FileInputStream inputStream = new FileInputStream(path.toString());
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        ArrayList<Character> characters = new ArrayList<>();
        characters.add((char) dataInputStream.readByte());
        characters.add((char) dataInputStream.readByte());
        characters.add((char) dataInputStream.readByte());
        characters.add((char) dataInputStream.readByte());
        characters.add((char) dataInputStream.readByte());

        imageType = Character.toString(characters.get(0)) + characters.get(1) + characters.get(2)
                + characters.get(3) + characters.get(4);

        if (imageType.equals("BMSOE")) {
            width = dataInputStream.readInt();
            height = dataInputStream.readInt();
            WritableImage bmsoe = new WritableImage(width, height);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    PixelWriter writer = bmsoe.getPixelWriter();
                    Color color = intToColor(dataInputStream.readInt());
                    writer.setColor(x, y, color);
                }
            }
            dataInputStream.close();
            inputStream.close();
            image = bmsoe;
        } else {
            System.out.println("first line of the file chosen is not = BMSOE");
        }
    }

    /**
     * method to write a bmsoe file
     * @param image passed in to be written as a bmsoe file
     * @param path path of the image being written as a bmsoe
     * @throws IOException for when an invalid inout is passed in
     */
    private void writeBMSOE(Image image, Path path) throws IOException {

        FileOutputStream outputStream = new FileOutputStream(path.toString());
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        dataOutputStream.writeBytes("BMSOE");
        dataOutputStream.writeInt((int) image.getWidth());
        dataOutputStream.writeInt((int) image.getHeight());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                PixelReader reader = image.getPixelReader();
                Color color = reader.getColor(x, y);
                dataOutputStream.writeInt(colorToInt(color));
            }

        }
        dataOutputStream.close();
        outputStream.close();
    }

    /**
     * method that changes an int to colour
     * @param color the colour being changed
     * @return the int in colour form
     */
    private static Color intToColor(int color) {
        double red = ((color >> 16) & 0x000000FF) / 255.0;
        double green = ((color >> 8) & 0x000000FF) / 255.0;
        double blue = (color & 0x000000FF) / 255.0;
        double alpha = ((color >> 24) & 0x000000FF) / 255.0;
        return new Color(red, green, blue, alpha);
    }

    /**
     * method that changes a colour to an int
     * @param color the colour being changed
     * @return the color in int form
     */
    private static int colorToInt(Color color) {
        int red = ((int) (color.getRed() * 255)) & 0x000000FF;
        int green = ((int) (color.getGreen() * 255)) & 0x000000FF;
        int blue = ((int) (color.getBlue() * 255)) & 0x000000FF;
        int alpha = ((int) (color.getOpacity() * 255)) & 0x000000FF;
        return (alpha << 24) + (red << 16) + (green << 8) + blue;
    }

}


