package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import model.Item;
import tm.ItemTM;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    public JFXTextField txtDescription;
    public JFXTextField txtHand;
    public JFXTextField txtType;
    public JFXTextField txtPrice;
    public JFXTextField txtSize;
    public JFXTextField txtCode;
    public TableView<ItemTM> itemTable;
    public TableColumn code;
    public TableColumn desc;
    public TableColumn size;
    public TableColumn qty;
    public TableColumn type;
    public TableColumn price;
    public JFXButton btnScerch;
    public Label lblId;
    public Label lblDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        code.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        size.setCellValueFactory(new PropertyValueFactory<>("packsize"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        type.setCellValueFactory(new PropertyValueFactory<>("itemtype"));
        price.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        getAllitem();
        generateOrderID();


        itemTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtCode.setText(newValue.getItemcode());
            txtDescription.setText(newValue.getDescription());
            txtHand.setText(String.valueOf(newValue.getQtyonhand()));
            txtType.setText(newValue.getItemtype());
            txtPrice.setText(String.valueOf(newValue.getUnitprice()));
            txtSize.setText(newValue.getPacksize());

        });
    }

        public void  generateOrderID() {
            String lastOrderID = null;
            try {
                PreparedStatement statement = DBConnection.getInstance().getConnection().
                        prepareStatement("SELECT orderid FROM orders ORDER BY orderid DESC LIMIT 1");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    lastOrderID = lastOrderID.split("A-Z")[1];
                    if (Integer.parseInt(lastOrderID) < 9) {
                        lastOrderID = "000" + (Integer.parseInt(lastOrderID) + 1);
                        lblId.setText(lastOrderID);

                    } else if (Integer.parseInt(lastOrderID) < 100) {
                        lastOrderID = "00" + (Integer.parseInt(lastOrderID) + 1);
                        lblId.setText(lastOrderID);
                    } else {
                        lblId.setText("001");
                    }
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }

        }


    private void getAllitem(){
        ArrayList<Item> items =new ArrayList<>();
        ObservableList<ItemTM> itemtm= FXCollections.observableArrayList();
        try {
            Connection connection =DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM item");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                items.add(new Item(resultSet.getString(1),resultSet.getString(2)
                        ,resultSet.getString(3), resultSet.getInt(4)
                        ,resultSet.getDouble(5),resultSet.getString(6)));

            }
            for (Item it: items){
                itemtm.add(new ItemTM(it.getItemcode(),it.getDescription(),
                        it.getPacksize(),it.getQtyonhand(), it.getUnitprice(), it.getItemtype()));
            }
            itemTable.setItems(itemtm);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void discription(ActionEvent actionEvent) {
        txtSize.requestFocus();
    }

    public void hand(ActionEvent actionEvent) {
        txtType.requestFocus();
    }

    public void type(ActionEvent actionEvent) {
        txtPrice.requestFocus();
    }

    public void size(ActionEvent actionEvent) {
        txtHand.requestFocus();
    }

    public void code(ActionEvent actionEvent) {
        txtDescription.requestFocus();
    }

    public void btnadd(ActionEvent actionEvent) {
        Item item = new Item(txtCode.getText(), txtDescription.getText(), txtSize.getText(), Integer.parseInt(txtHand.getText()), Double.parseDouble(txtPrice.getText()), txtType.getText());
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO item " + "VALUES (?,?,?,?,?,?)");
            preparedStatement.setObject(1, item.getItemcode());
            preparedStatement.setObject(2, item.getDescription());
            preparedStatement.setObject(3, item.getPacksize());
            preparedStatement.setObject(4, item.getQtyonhand());
            preparedStatement.setObject(5, item.getUnitprice());
            preparedStatement.setObject(6, item.getItemtype());
            int add = preparedStatement.executeUpdate();
            if (add > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refresh();
    }

    public void btnupdate(ActionEvent actionEvent) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE item SET " + "description=?,packSize=?,qtyonHand=?,unitPrice=?,item_type=? WHERE item_code=?");
            preparedStatement.setObject(1, txtDescription.getText());
            preparedStatement.setObject(2, txtSize.getText());
            preparedStatement.setObject(3, txtHand.getText());
            preparedStatement.setObject(4, txtPrice.getText());
            preparedStatement.setObject(5, txtType.getText());
            preparedStatement.setObject(6, txtCode.getText());
            int update = preparedStatement.executeUpdate();
            if (update > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refresh();
    }

    public void btnDelete(ActionEvent actionEvent) {

        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM item WHERE item_code=?");
            preparedStatement.setObject(1,txtCode.getText());
            int delete = preparedStatement.executeUpdate();
            if (delete>0){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted",ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING,"Try again",ButtonType.OK).show();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        refresh();


    }

    public void btnClrar(ActionEvent actionEvent) {
        clearText();
    }

    private void clearText() {
        txtDescription.clear();
        txtCode.clear();
        txtHand.clear();
        txtPrice.clear();
        txtSize.clear();
        txtType.clear();
    }
    public void refresh(){
        code.setCellValueFactory(new PropertyValueFactory<>("itemcode"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        size.setCellValueFactory(new PropertyValueFactory<>("packsize"));
        qty.setCellValueFactory(new PropertyValueFactory<>("qtyonhand"));
        type.setCellValueFactory(new PropertyValueFactory<>("itemtype"));
        price.setCellValueFactory(new PropertyValueFactory<>("unitprice"));

        getAllitem();


    }


    public void btnScerch(ActionEvent actionEvent) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM item WHERE item_code=?");
            preparedStatement.setObject(1,txtCode.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                txtDescription.setText(resultSet.getString(2));
                txtHand.setText(resultSet.getString(3));
                txtType.setText(resultSet.getString(4));
                txtSize.setText(resultSet.getString(5));
                txtPrice.setText(resultSet.getString(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void BtnDelete(MouseEvent mouseEvent) {
    }
}
