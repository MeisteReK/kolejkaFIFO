public class Order {
    private String orderId;
    private String productName;
    private int quantity;

    public Order(String orderId, String productName, int quantity) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Gettery i Settery
    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
