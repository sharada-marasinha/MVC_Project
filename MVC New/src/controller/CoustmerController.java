package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Customer;
import tm.CoustomerTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CoustmerController implements Initializable {
    public JFXTextField txttitle;
    public JFXTextField txtname;
    public JFXTextField txtpostalcode;
    public JFXTextField txtprovince;
    public JFXTextField txtcity;
    public JFXTextField txtaddres;
    public JFXTextField txtid;
    public JFXButton btnScerch;
    public TableView<CoustomerTM> cusTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set valuse to table
        cusTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        cusTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
        cusTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("adress"));
        cusTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("name"));
        cusTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("province"));
        cusTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("city"));
        cusTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        //set valuse to coustomrtm form Coustomer model
        getAllcustomer();

        //selecting valus form table
        cusTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtid.setText(newValue.getId());
            txttitle.setText(newValue.getTitle());
            txtpostalcode.setText(newValue.getPostalCode());
            txtprovince.setText(newValue.getProvince());
            txtname.setText(newValue.getName());
            txtcity.setText(newValue.getCity());
            txtaddres.setText(newValue.getAdress());
        });

    }

    private void getAllcustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        ObservableList<CoustomerTM> coustomertm = FXCollections.observableArrayList();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getString(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7)));

            }
            for (Customer cous : customers
            ) {
                coustomertm.add(new CoustomerTM(cous.getCustid(), cous.getCusttitle(),
                        cous.getCustaddress(), cous.getCustname(), cous.getProvince(), cous.getCity(),
                        cous.getPostalcode()));
            }
            cusTable.setItems(coustomertm);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void btnadd(ActionEvent actionEvent) {
        Customer customer = new Customer(txtid.getText(), txttitle.getText(), txtname.getText(), txtaddres.getText(), txtcity.getText(), txtprovince.getText(), txtpostalcode.getText());
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  customer " + " VALUES(?,?,?,?,?,?,?)");
            preparedStatement.setObject(1, customer.getCustid());
            preparedStatement.setObject(2, customer.getCusttitle());
            preparedStatement.setObject(3, customer.getCustname());
            preparedStatement.setObject(4, customer.getCustaddress());
            preparedStatement.setObject(5, customer.getCity());
            preparedStatement.setObject(6, customer.getProvince());
            preparedStatement.setObject(7, customer.getPostalcode());
            int add = preparedStatement.executeUpdate();
            if (add > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
            }
            refresh();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnupdate(ActionEvent actionEvent) {
        Customer customer = new Customer(txtid.getText(), txttitle.getText(), txtname.getText(), txtaddres.getText(), txtcity.getText(), txtprovince.getText(), txtpostalcode.getText());
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer SET " + "cust_title=?,cust_name=?,cust_address=?,city=?,province=?,postalcode=? WHERE cust_id=?");
            preparedStatement.setObject(1, txttitle.getText());
            preparedStatement.setObject(2, txtname.getText());
            preparedStatement.setObject(3, txtaddres.getText());
            preparedStatement.setObject(4, txtcity.getText());
            preparedStatement.setObject(5, txtprovince.getText());
            preparedStatement.setObject(6, txtpostalcode.getText());
            preparedStatement.setObject(7, txtid.getText());

            int update = preparedStatement.executeUpdate();
            if (update > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated", ButtonType.OK).show();

            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refresh();
    }

    public void btnDelete(ActionEvent actionEvent) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customer WHERE cust_id=?");
            preparedStatement.setObject(1, txtid.getText());
            int delete = preparedStatement.executeUpdate();
            if (delete > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refresh();
    }

    public void idOnacton(ActionEvent actionEvent) {
        txttitle.requestFocus();
    }

    public void adressOnacton(ActionEvent actionEvent) {
        txtcity.requestFocus();
    }

    public void cityOnacton(ActionEvent actionEvent) {
        txtprovince.requestFocus();
    }

    public void provinceOnacton(ActionEvent actionEvent) {
        txtpostalcode.requestFocus();
    }

    public void nameOnacton(ActionEvent actionEvent) {
        txtaddres.requestFocus();
    }

    public void titleOnacton(ActionEvent actionEvent) {
        txtname.requestFocus();
    }

    private void clearText() {
        txtid.clear();
        txtaddres.clear();
        txtprovince.clear();
        txtpostalcode.clear();
        txtcity.clear();
        txtname.clear();
        txttitle.clear();
    }

    public void BtnDelete(MouseEvent mouseEvent) {
    }

    public void btnClrar(ActionEvent actionEvent) {
        clearText();
    }

    public void btnScerch(ActionEvent actionEvent) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE cust_id= ?");
            preparedStatement.setObject(1, txtid.getText());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                txttitle.setText(resultSet.getString(2));
                txtname.setText(resultSet.getString(3));
                txtaddres.setText(resultSet.getString(4));
                txtcity.setText(resultSet.getString(5));
                txtprovince.setText(resultSet.getString(6));
                txtpostalcode.setText(resultSet.getString(7));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

public void refresh(){
    cusTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
    cusTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("title"));
    cusTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("adress"));
    cusTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("name"));
    cusTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("province"));
    cusTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("city"));
    cusTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("postalCode"));


    getAllcustomer();


}
}


