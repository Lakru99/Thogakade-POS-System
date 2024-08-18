package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class ViewCustomerFormController implements Initializable {

    @FXML
    private TableView<Customer> customerTbl;


    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableColumn<?, ?> colDOB;
    @FXML
    private JFXButton btnExit;

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));

        loadTable();
    }

    private void loadTable(){
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        customerList.forEach(obj->{
            customerObservableList.add(obj);
        });

        customerTbl.setItems(customerObservableList);

    }
    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTable();
    }


}
