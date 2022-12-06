
/*
 * Course: CS1021
 * Term Winter 2020-2021
 * File header contains class ImageIO
 * Name: malisad
 * Created 2/4/2021
 */
package msoe.cs1021.lab9;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Course: CS1021
 * Term Winter 2020-2021
 * ImageIO purpose: lab9 first controller
 *
 * @author malisad
 * @version created on 2/4/2021 at 3:26 PM
 */
public class Lab9Controller {

    @FXML
    ImageView imageView = new ImageView();
    @FXML
    private Button showFilter;

    File file;
    private Image updated;
    private Image image;
    ImageIO imageIO = new ImageIO();
    FileChooser fileChooser = new FileChooser();
    Lab9 lab9;


    /**
     * load method opens images
     *
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
            updated = image;

        } else {
            System.out.println("No file was chosen");
        }

    }

    /**
     * method to reload the image
     *
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
     *
     * @param event not used
     */
    @FXML
    public void save(ActionEvent event) {
        file = new File("images");
        fileChooser.setInitialDirectory(file);
        file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try {
                imageIO.write(updated, file.toPath());
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
     *
     * @param event not used
     */
    @FXML
    public void grayScale(ActionEvent event) {

        if (file != null) {
            updated = transformImage(image, ((y, color) -> color.grayscale()));
        } else {
            System.out.println("No image was chosen");
        }
        imageView.setImage(updated);
    }

    /**
     * method to change image to negative
     *
     * @param event not used
     */
    @FXML
    public void negative(ActionEvent event) {
        final int NUM = 1;
        if (file != null) {

            updated = transformImage(image, (y, color) -> {
                double blue, green, red;
                blue = NUM - color.getBlue();
                red = NUM - color.getRed();
                green = NUM - color.getGreen();

                return Color.color(red, green, blue);
            });
        } else {
            System.out.println("An image was not chosen");
        }
        imageView.setImage(updated);
    }

    /**
     * method to make an image red
     *
     * @param event not used
     */
    @FXML
    public void red(ActionEvent event) {

        if (file != null) {
            updated = transformImage(image, (y, color) -> {
                double blue;
                double green;
                double red;
                blue = color.getBlue() * 0;
                green = color.getGreen() * 0;
                red = color.getRed();

                return Color.color(red, green, blue);
            });
        } else {
            System.out.println("An image was not chosen");
        }
        imageView.setImage(updated);
    }

    /**
     * method to transform an image to redgrey
     *
     * @param event not used
     */
    @FXML
    public void redGray(ActionEvent event) {

        if (file != null) {

            updated = transformImage(image, (y, color) -> {

                double blue;
                double green;
                double red;

                if (y % 2 == 0) {
                    blue = color.getBlue() * 0;
                    red = color.getRed();
                    green = color.getGreen() * 0;

                    return Color.color(red, green, blue);
                } else {
                    return color.grayscale();
                }
            });

        } else {
            System.out.println("An image was not chosen");
        }
        imageView.setImage(updated);

    }

    /**
     * method to respond to the clicking of the show filter button
     * which displays the filter kernel stage
     *
     * @param event not used
     */
    @FXML
    public void showFilter(ActionEvent event) {
        if (lab9.secondStage.isShowing()) {
            lab9.secondStage.hide();
            showFilter.setText("Show Filter");
        } else if (!lab9.secondStage.isShowing()) {
            lab9.secondStage.show();
            showFilter.setText("Hide Filter");
        }

    }

    /**
     * Method that implements repeated function of each image transformation
     *
     * @param image     image being transformed
     * @param transform transformation
     * @return the transformation done
     */
    private static Image transformImage(Image image, Transformable transform) {

        int height = (int) image.getHeight();
        int width = (int) image.getWidth();
        Color color;
        Color transformedColor;

        PixelReader reader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(width, height);
        PixelWriter writer = writableImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                color = reader.getColor(x, y);
                transformedColor = transform.apply(y, color);
                writer.setColor(x, y, transformedColor);

            }
        }
        image = writableImage;
        return image;
    }

    /**
     * method that gets the updated image
     *
     * @return the updated image
     */
    public Image getImage() {
        return updated;
    }

    /**
     * method to set the image
     * so that it is retrievable by the filter controller
     *
     * @param image the image being set
     */
    public void setImage(Image image) {
        if (file != null) {
            updated = image;
            imageView.setImage(updated);
        } else {
            System.out.println("No file was selected");
        }
    }

    /**
     * set the model for lab9
     *
     * @param model being set
     */
    public void setModel(Lab9 model) {
        lab9 = model;
    }
}
