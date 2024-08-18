package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private DatePicker dob;

    @FXML
    private JFXTextField txtContact;

    private ObservableList<String> titleList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleList.add("Mr.");
        titleList.add("Mrs.");
        titleList.add("Miss.");
        cmbTitle.setItems(titleList);
    }

    private void clearFields(){
        txtId.setText(null);
        txtName.setText(null);
        txtAddress.setText(null);
        cmbTitle.setItems(titleList);
        txtContact.setText(null);
        dob.setValue(null);
    }

    @FXML
    void btnAddAction(ActionEvent event) {

        System.out.println(new Customer(txtId.getText(), cmbTitle.getValue(), txtName.getText(), txtAddress.getText(), txtContact.getText(),dob.getValue()));

        List<Customer> customerList = DBConnection.getInstance().getConnection();

        customerList.add(new Customer(txtId.getText(), cmbTitle.getValue(), txtName.getText(), txtAddress.getText(), txtContact.getText(),dob.getValue()));

        clearFields();
    }



    @FXML
    void btnClearAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnExitAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }



}
