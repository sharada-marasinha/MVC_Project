package controller;

import db.DBConnection;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class dashBordController  {
    public AnchorPane loadformContext;
    public AnchorPane dashboardsContext;
    public ImageView sideformContext;
    public Label lbltime;
    public Label lbldate;

    public void initialize(){
        initClock();
    }

    public void btnCoustmer(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/coustmer.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.loadformContext.getChildren().clear();
        this.loadformContext.getChildren().add(load);
    }
    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lbltime.setText(LocalDateTime.now().format(formatter));

            SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lbldate.setText(formatter2.format(date));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }

    public void btnOrder(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/order.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.loadformContext.getChildren().clear();
        this.loadformContext.getChildren().add(load);
    }


    public void btnItem(ActionEvent actionEvent) throws IOException {
        URL resource=this.getClass().getResource("../view/item.fxml");

        assert resource != null;

        Parent load = (Parent) FXMLLoader.load(resource);
        this.loadformContext.getChildren().clear();
        this.loadformContext.getChildren().add(load);
    }
    /*public void generateOrderId(){

        String lastOrderId = null;

        try {
            PreparedStatement statement = DBConnection.getInstance().getConnection().
                    prepareStatement("SELECT OrderId FROM orders ORDER BY OrderId DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lastOrderId = resultSet.getString(1);
            }

            if (lastOrderId != null) {
                lastOrderId = lastOrderId.split("[A-Z]")[1];
                if (Integer.parseInt(lastOrderId) < 9) {
                    lastOrderId = "O00" + (Integer.parseInt(lastOrderId) + 1);
                    lblOrder.setText(lastOrderId);
                } else if (Integer.parseInt(lastOrderId) < 100) {
                    lastOrderId = "O0" + (Integer.parseInt(lastOrderId) + 1);
                    lbOrder.setText(lastOrderId);
                }
            } else {
                lbOrder.setText("O001");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

}



