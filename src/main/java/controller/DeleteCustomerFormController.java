package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Customer;

import java.util.List;

public class DeleteCustomerFormController {

    @FXML
    private JFXTextField searchField;

    @FXML
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label addressLbl;

    @FXML
    private Label numberLbl;

    @FXML
    private Label dobLbl;

    @FXML
    private JFXButton btnExit;

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        searchCustomer();
    }
    public void searchCustomer(){
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);

            if (searchField.getText().equals(cus.getNumber())){
                idLbl.setText(cus.getId());
                nameLbl.setText(cus.getName());
                addressLbl.setText(cus.getAddress());
                numberLbl.setText(cus.getNumber());
                dobLbl.setText(String.valueOf(cus.getDob()));
            }
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (int i=0; i<customerList.size(); i++ ){
            Customer cus = customerList.get(i);

            if (searchField.getText().equals(cus.getNumber())){
                customerList.remove(cus);
            }
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        searchField.setText("Search Phone Number");
        idLbl.setText("ID : ");
        nameLbl.setText("Name : ");
        addressLbl.setText("Address : ");
        numberLbl.setText("Number : ");
        dobLbl.setText("Birthday");
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }





}
