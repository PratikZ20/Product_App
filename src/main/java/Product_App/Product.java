package Product_App;
//DTO
public class Product {

    private int productId;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(int productId, String productName, double productPrice, int productQuantity) {
        this.productId=productId;
        this.productName=productName;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
    }
    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Price: " + productPrice +
                ", Quantity: " + productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
