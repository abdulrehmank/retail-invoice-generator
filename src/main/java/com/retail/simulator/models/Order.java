package com.retail.simulator.models;

import java.util.List;

public class Order {

    private long id;
    private User user;
    private double amount;
    private double discount;
    List<OrderItem> orderItems;

    public Order(long id, User user, double amount, double discount, List<OrderItem> orderItems) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.discount = discount;
        this.orderItems = orderItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", amount=" + amount +
                ", discount=" + discount +
                ", orderItems=" + orderItems +
                '}';
    }
}
