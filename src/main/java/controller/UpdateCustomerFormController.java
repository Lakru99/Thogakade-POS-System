package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Customer;

import java.util.List;

public class UpdateCustomerFormController {

    @FXML
    private JFXTextField searchField;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXTextField idField;

    @FXML
    private JFXTextField nameField;

    @FXML
    private JFXTextField addressField;

    @FXML
    private JFXTextField numberField;

    @FXML
    private JFXTextField dobField;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        searchField.setText(null);
        idField.setText(null);
        nameField.setText(null);
        addressField.setText(null);
        numberField.setText(null);
        //dobField.setText(null);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        searchCustomer();
    }
    public void searchCustomer(){
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);
            if (searchField.getText().equals(cus.getNumber())){
                idField.setText(cus.getId());
                nameField.setText(cus.getName());
                addressField.setText(cus.getAddress());
                numberField.setText(cus.getNumber());
                //.setText(String.valueOf(cus.getDob()));
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);
            if (searchField.getText().equals(cus.getNumber())){
                cus.setId(idField.getText());
                cus.setName(nameField.getText());
                cus.setAddress(addressField.getText());
                cus.setNumber(numberField.getText());

            }
        }
    }

}
