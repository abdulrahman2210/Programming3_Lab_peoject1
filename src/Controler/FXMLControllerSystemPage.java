/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLControllerSystemPage implements Initializable {

    @FXML
    private Button buttonLogOut;
    @FXML
    private Button buttonConvert;
    @FXML
    private Label labelTitel;
    @FXML
    private Label labelUsd;
    @FXML
    private Label labelNis;
    @FXML
    private Label labelTo;
    @FXML
    private TextField textFieldUsd;
    @FXML
    private TextField textFieldNis;
    @FXML
    private Label labelInvalid;
    
//    public Prog3_SystemPage prog3_SystemPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void buttonLogOutAction(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        stage.close();

    }

    @FXML
    private void buttonConvertAction(ActionEvent event) {
            try {
            if (!(textFieldUsd.getText().equals(""))) {
                textFieldNis.setText(convertNIS(textFieldUsd.getText()) + " ₪");
                labelInvalid.setText("");
            }
            else if (!(textFieldNis.getText().equals(""))) {
                textFieldUsd.setText(convertUSD(textFieldNis.getText())+ " $");
                labelInvalid.setText("");
            }
        } catch (Exception e) {
                labelInvalid.setText("Inavlid Number!");
        }
    }

    public String convertUSD(String s) {
        double x = Double.parseDouble(s);
        double z = x / 3.53;
        DecimalFormat df = new DecimalFormat();
        return df.format(z);
    }
    public String convertNIS(String s) {
        double x = Double.parseDouble(s);
        double z = x * 3.53;
        DecimalFormat df = new DecimalFormat();
        return df.format(z);
    }
}
