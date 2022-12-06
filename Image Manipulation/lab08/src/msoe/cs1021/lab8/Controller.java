/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class ImageIO
 * Name: malisad
 * Created 2/4/2021
 */
package msoe.cs1021.lab8;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * ImageIO purpose:
 *
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
public class Controller {

    @FXML
    ImageView imageView = new ImageView();
    File file;
    Image newImage;
    ImageIO imageIO = new ImageIO();
    Image image;
    FileChooser fileChooser = new FileChooser();

    /**
     * load method opens images
     * @param event nothing
     */
    @FXML
    public void load(ActionEvent event) {

        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showOpenDialog(null);

        if (file != null) {

            try {
                image = imageIO.read(file.toPath());
            } catch (FileNotFoundException e) {
                System.out.println("The file was not found");
            } catch (IllegalArgumentException e) {
                System.out.println("An inappropriate argument has been passed");
            } catch (IOException e) {
                System.out.println("I/O error has occurred");
            }
            imageView.setImage(image);
            newImage = image;

        } else {
            System.out.println("No file was chosen");
        }

    }

    /**
     * method to reload the image
     * @param event not used
     */
    @FXML
    public void reload(ActionEvent event) {
        if (file != null) {
            imageView.setImage(image);
        } else {
            System.out.println("No file was chosen");
        }
    }

    /**
     * method to save the images
     * @param event not used
     */
    @FXML
    public void save(ActionEvent event) {
        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                imageIO.write(newImage, file.toPath());
            } catch (IllegalArgumentException e) {
                System.out.println("Inappropriate argument passed");
            } catch (IOException e) {
                System.out.println("I/O error has occurred");
            }
        } else {
            System.out.println("No image was chosen");
        }
    }

    /**
     * method to turn image to grayscale
     * @param event not used
     */
    @FXML
    public void grayScale(ActionEvent event) {
        int height, width;
        Color color;
        double blue = 0.0, green = 0.0, red = 0.0;

        if (file != null) {
            height = (int) image.getHeight();
            width = (int) image.getWidth();
            WritableImage writableImage = new WritableImage(width, height);
            PixelWriter writer = writableImage.getPixelWriter();

            PixelReader reader = image.getPixelReader();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    color = reader.getColor(x, y);
                    writer.setColor(x, y, color.grayscale());
                }
            }
            imageView.setImage(writableImage);
            newImage = writableImage;
        } else {
            System.out.println("No image was chosen");
        }
    }

    /**
     * method to change image to negative
     * @param event not used
     */
    @FXML
    public void negative(ActionEvent event) {
        int height, width;
        Color color;
        double blue = 0.0, green = 0.0, red = 0.0;

        if (file != null) {
            height = (int) image.getHeight();
            width = (int) image.getWidth();
            WritableImage writableImage = new WritableImage(width, height);
            PixelWriter writer = writableImage.getPixelWriter();

            PixelReader reader = image.getPixelReader();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    color = reader.getColor(x, y);

                    if (color != null) {
                        blue = 1 - color.getBlue();
                        red = 1 - color.getRed();
                        green = 1 - color.getGreen();
                    }
                    Color grey = Color.color(red, green, blue);
                    writer.setColor(x, y, grey);
                }
            }
            imageView.setImage(writableImage);
            newImage = writableImage;
        } else {
            System.out.println("An image was not chosen");
        }
    }


}
