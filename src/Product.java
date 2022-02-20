/**
 * <h1>Product</h1>
 * La clase Product representa a un producto de una comanda.
 * Un producto puede pertenecer a diferentes comandas.
 * @author Daruny SC
 * @version 1.0.0
 * @since 2021-02-16
 */

public class Product {

    private int id;
    private String name;
    private String description;
    private int operator;
    private String date;
    private int cartId;
    private int quantity;
    private double ivaPercent;
    private double unitPrice;

    public Product(){
        this.id = 0;
        this.name = "noName";
        this.description = "noDescription";
        this.operator = 0;
        this.date = "noDate";
        this.cartId = 0;
        this.quantity = 0;
        this.ivaPercent = 0;
        this.unitPrice = 0.0;
    }

    public Product(int id, String name, String description, int operator, String date, int cartId, int quantity, double ivaPercent, double unitPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.operator = operator;
        this.date = date;
        this.cartId = cartId;
        this.quantity = quantity;
        this.ivaPercent = ivaPercent;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getIvaPercent() {
        return ivaPercent;
    }

    public void setIvaPercent(int ivaPercent) {
        this.ivaPercent = ivaPercent;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String toString() {
        return "Product{" +
                "id='" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", operator=" + operator +
                ", date='" + date + '\'' +
                ", cartId=" + cartId +
                ", quantity=" + quantity +
                ", ivaPercent=" + ivaPercent +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

