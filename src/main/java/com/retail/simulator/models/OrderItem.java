package com.retail.simulator.models;

import java.util.Date;

public class OrderItem {

    private int id;
    private Product product;
    private int quantity;
    private double unitPrice;
    private double subTotal;
    private Date createdOn;
    private Date updatedOn;

    public OrderItem(int id, Product product, int quantity, double unitPrice, double subTotal) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
    }

    public Product getProduct() {
        return product;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subTotal=" + subTotal +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
