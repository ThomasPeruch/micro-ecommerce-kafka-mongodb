package com.tperuch.commons.dto;

import java.util.List;

public class OrderDTO {
    private String customerName;
    private List<ItemDTO> items;

    public OrderDTO() {
    }

    public OrderDTO(String customerName, List<ItemDTO> items, int quantity) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                ", customerName='" + customerName + '\'' +
                ", product='" + items + '\'' +
                '}';
    }
}

