package sample;

import edu.msoe.se1021.Lab6.WebsiteTester;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.rmi.ConnectException;
import java.util.Optional;


public class Lab6Controller {

    @FXML
    private TextField timeout;
    @FXML
    private TextField size;
    @FXML
    private TextField url;
    @FXML
    private TextField time;
    @FXML
    private TextField port;
    @FXML
    private TextField host;
    @FXML
    private TextArea pane;

    WebsiteTester tester = new WebsiteTester();

    /**
     * method that will implement all that
     * has to be done with the analyze button
     *
     */
    @FXML
    private void analyze() {

        Alert b = new Alert(Alert.AlertType.ERROR);
        Alert c = new Alert(Alert.AlertType.CONFIRMATION);

        String enteredUrl, size, time, host, port;
        enteredUrl = url.getText();

        if (enteredUrl.isEmpty()) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText("The URL entered in the text box is invalid");
            b.showAndWait();
        }
        try {
            tester.openURL(enteredUrl);
        } catch (MalformedURLException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
            url.clear();
        }

        try {
            tester.openConnection();
        } catch (MalformedURLException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
            url.clear();
        } catch (UnknownHostException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
        } catch (SocketTimeoutException e) {
            TextInputDialog textInputDialog = new TextInputDialog();
            c.setTitle("Timeout Dialog");
            c.setHeaderText("Wait longer");
            c.setContentText(e.getMessage());
            Optional<ButtonType> result = c.showAndWait();
            if (result.get() == ButtonType.OK) {
                textInputDialog.setHeaderText("Set extended timeout");
                textInputDialog.setContentText("There has been a timeout reaching the site." +
                        "Click OK to extend the timeout period?");
                textInputDialog.setContentText("Desired Timeout");

                Optional<String> r1 = textInputDialog.showAndWait();
                if (r1.isPresent()) {
                    timeout.setText(r1.get());
                }
            }
        } catch (IIOException e) {
            b.setHeaderText("Error Dialog");
            b.setContentText(e.getMessage());
            b.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            tester.downloadText();
        } catch (ConnectException e) {
            b.setTitle("Error Dialog");
            b.setContentText(e.getMessage());
            b.showAndWait();
        } catch (FileNotFoundException e) {
            b.setHeaderText("Error Dialog");
            b.setHeaderText("File Error");
            b.setContentText("Error: File not found on the server,\n" + e.getMessage());
            b.showAndWait();
        } catch (IOException e) {
            b.setTitle("Error Dialog");
            b.setHeaderText("URL Error");
            b.setContentText(e.getMessage());
            b.showAndWait();
        }


        size = Integer.toString(tester.getSize());
        this.size.setText(size);
        time = Long.toString(tester.getDownloadTime());
        this.time.setText(time);
        host = tester.getHostname();
        this.host.setText(host);
        port = Integer.toString(tester.getPort());
        this.port.setText(port);
        pane.setText(tester.getContent());


    }

    /**
     * method that deals with the
     * setting of timeout
     */
    @FXML
    private void setTimeout() {

        Alert a = new Alert(Alert.AlertType.ERROR);//creating alert for an error

        String timeEntered;
        timeEntered = timeout.getText();

        // try catch for NumberFormatException that could occur
        try {
            tester.setTimeout(timeEntered);
        } catch (NumberFormatException e) {
            a.setTitle("Timeout Error");
            a.setHeaderText("Invalid Timeout Error");
            a.setContentText(e.getMessage());
            a.showAndWait();
            timeEntered = timeout.getText();
        }

        timeout.setText(timeEntered);
    }

}
