package model;

public class order {
    private String orderid;
    private String custid;
    private double orderdate;
    private double price;

    public order() {

    }

    public order(String orderid, String custid, double orderdate, double price) {
        this.orderid = orderid;
        this.custid = custid;
        this.orderdate = orderdate;
        this.price = price;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public double getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(double orderdate) {
        this.orderdate = orderdate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderid='" + orderid + '\'' +
                ", custid='" + custid + '\'' +
                ", orderdate=" + orderdate +
                ", price=" + price +
                '}';
    }
}
