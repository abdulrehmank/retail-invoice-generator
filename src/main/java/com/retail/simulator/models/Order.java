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
