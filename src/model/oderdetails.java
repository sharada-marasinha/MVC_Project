package model;

public class oderdetails {
    private String oid;
    private String itemcode;
    private int orderqty;
    private double discount;

    public oderdetails() {
    }

    public oderdetails(String oid, String itemcode, int orderqty, double discount) {
        this.oid = oid;
        this.itemcode = itemcode;
        this.orderqty = orderqty;
        this.discount = discount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "oderdetails{" +
                "oid='" + oid + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", orderqty=" + orderqty +
                ", discount=" + discount +
                '}';
    }
}
