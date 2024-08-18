package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Customer;

import java.util.List;

public class SearchCustomerFormController {

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
    void btnClearOnAction(ActionEvent event) {
        searchField.setText("Id :");
        idLbl.setText("Name :");
        nameLbl.setText(null);
        addressLbl.setText(null);
        numberLbl.setText(null);
        dobLbl.setText(null);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
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


}
