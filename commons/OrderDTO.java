public class OrderDTO {
    private String orderId;
    private String customerName;
    private String product;
    private int quantity;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String customerName, String product, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}