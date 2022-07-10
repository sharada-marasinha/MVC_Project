package tm;

public class ItemTM {
    private String itemcode;
    private String description;
    private String packsize;
    private int qtyonhand;
    private double unitprice;
    private String itemtype;

    public ItemTM() {
    }

    public ItemTM(String itemcode, String description, String packsize, int qtyonhand, double unitprice, String itemtype) {
        this.itemcode = itemcode;
        this.description = description;
        this.packsize = packsize;
        this.qtyonhand = qtyonhand;
        this.unitprice = unitprice;
        this.itemtype = itemtype;
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

    public int getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(int qtyonhand) {
        this.qtyonhand = qtyonhand;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
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
        return "ItemTM{" +
                "itemcode='" + itemcode + '\'' +
                ", description='" + description + '\'' +
                ", packsize='" + packsize + '\'' +
                ", qtyonhand=" + qtyonhand +
                ", unitprice=" + unitprice +
                ", itemtype='" + itemtype + '\'' +
                '}';
    }
}
