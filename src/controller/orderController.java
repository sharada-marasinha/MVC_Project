package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tm.OderTM;

import java.net.URL;
import java.util.ResourceBundle;

public class orderController implements Initializable {

    @FXML
    private JFXTextField txtCustID;

    @FXML
    private TableView<?> plaseOrderTable;

    @FXML
    private TableColumn tbItemCode;

    @FXML
    private TableColumn tbDscription;

    @FXML
    private TableColumn tbQtyonHand;

    @FXML
    private TableColumn tbPrice;

    @FXML
    private TableColumn tbTotal;

    @FXML
    private Label lblTotal;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private Label lblOrderId;

    @FXML
    private Label lblDate;

    @FXML
    void btnAdd(ActionEvent event) {
        String desc = tbDscription.getText();
        String itemCode = tbItemCode.getText();
        int qty = Integer.parseInt(tbQtyonHand.getText());
        double price = Double.parseDouble(tbPrice.getText());
        Object value = tbItemCode.getText();
        double total = qty * price;
        System.out.println(value);



       /* OderTM oderTM = new OderTM(
                txtItemCode.getText(),
                txtQty,

        );*/



    }

    @FXML
    void btnClose(ActionEvent event) {

    }

    @FXML
    void btnPlaseOrder(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        tbDscription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tbItemCode.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        tbQtyonHand.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        tbTotal.setCellValueFactory(new PropertyValueFactory<>("total"));


    }
}
