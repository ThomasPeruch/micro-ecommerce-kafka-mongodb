package com.tperuch.commons.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "order_raw")
public class OrderEntity {

    @Id
    private String id;
    private LocalDateTime receivedAt;
    private  String customerName;
    private List<ItemEntity> items;

    public OrderEntity() {
    }

    public OrderEntity(String id, LocalDateTime receivedAt, String customerName, List<ItemEntity> items) {
        this.id = id;
        this.receivedAt = receivedAt;
        this.customerName = customerName;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id='" + id + '\'' +
                ", receivedAt=" + receivedAt +
                ", customerName='" + customerName + '\'' +
                ", items=" + items +
                '}';
    }
}