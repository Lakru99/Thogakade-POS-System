package controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.application.PlatformImpl.exit;


public class DashFormController {
    private JFXButton btnExit;

    @FXML
    void btnAddCustomerAction(ActionEvent event) throws IOException {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/addCustomerForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteCustomerAction(ActionEvent event) {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/deleteCustomer.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSearchCustomerAction(ActionEvent event) {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/searchCustomer.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateCustomerAction(ActionEvent event) {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/UpdateCustomerForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnViewCustomerAction(ActionEvent event) {
        Stage stage =new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/viewCustomerForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnExitCustomerAction(ActionEvent event) {
        exit();
    }
}
