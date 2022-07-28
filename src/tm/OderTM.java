package tm;

public class OderTM {
    private String oid;
    private String itemcode;
    private int orderqty;
    private double unitPrice;
    private String description;
    private double total;

    public OderTM() {
    }

    public OderTM(String oid, String itemcode, int orderqty, double unitPrice, String description, double total) {
        this.setOid(oid);
        this.setItemcode(itemcode);
        this.setOrderqty(orderqty);
        this.setUnitPrice(unitPrice);
        this.setDescription(description);
        this.setTotal(total);
    }

    /*public OderTM(String text, String desc, String itemCode, int qty, double price, double total) {
    }
*/
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OderTM{" +
                "oid='" + oid + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", orderqty=" + orderqty +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", total=" + total +
                '}';
    }
}
