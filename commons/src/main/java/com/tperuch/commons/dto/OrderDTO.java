package com.tperuch.commons.dto;


public class OrderDTO {
    private String customerName;
    private String product;
    private int quantity;

    public OrderDTO() {
    }

    public OrderDTO(String customerName, String product, int quantity) {
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                ", customerName='" + customerName + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

