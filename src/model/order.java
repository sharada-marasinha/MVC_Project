package model;

public class order {
    private String orderid;
    private String custid;
    private Double orderdate;
    private Double price;

    public order() {

    }

    public order(String orderid, String custid, Double orderdate, Double price) {
        this.setOrderid(orderid);
        this.setCustid(custid);
        this.setOrderdate(orderdate);
        this.setPrice(price);
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

    public Double getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Double orderdate) {
        this.orderdate = orderdate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
