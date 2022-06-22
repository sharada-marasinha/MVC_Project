package model;

public class item {
    private String itemcode;
    private String description;
    private String packsize;
    private Integer qtyonhand;
    private Double unitprice;
    private String itemtype;

    public item() {
    }

    public item(String itemcode, String description, String packsize, Integer qtyonhand, Double unitprice, String itemtype) {
        this.setItemcode(itemcode);
        this.setDescription(description);
        this.setPacksize(packsize);
        this.setQtyonhand(qtyonhand);
        this.setUnitprice(unitprice);
        this.setItemtype(itemtype);
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPacksize() {
        return packsize;
    }

    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    public Integer getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(Integer qtyonhand) {
        this.qtyonhand = qtyonhand;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    @Override
    public String toString() {
        return "item{" +
                "itemcode='" + itemcode + '\'' +
                ", description='" + description + '\'' +
                ", packsize='" + packsize + '\'' +
                ", qtyonhand=" + qtyonhand +
                ", unitprice=" + unitprice +
                ", itemtype='" + itemtype + '\'' +
                '}';
    }
}
