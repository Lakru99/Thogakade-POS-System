package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashFormController {

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

    }

    @FXML
    void btnSearchCustomerAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateCustomerAction(ActionEvent event) {

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

}
