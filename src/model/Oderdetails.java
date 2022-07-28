package model;

public class Oderdetails {
    private String oid;
    private String itemcode;
    private int orderqty;
    private double unitPrice;
    private String description;

    public Oderdetails() {
    }

    public Oderdetails(String oid, String itemcode, int orderqty, double unitPrice, String description) {
        this.oid = oid;
        this.itemcode = itemcode;
        this.orderqty = orderqty;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    @Override
    public String toString() {
        return "oderdetails{" +
                "oid='" + oid + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", orderqty=" + orderqty +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                '}';
    }
}
