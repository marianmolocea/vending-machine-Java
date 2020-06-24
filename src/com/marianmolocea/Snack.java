package com.marianmolocea;

public class Snack {
    String name;
    double price;
    int quantity;
    final int INITIAL_QUANTITY = 10;

    public Snack(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = INITIAL_QUANTITY;
    }

    public void decreaseQuantity(byte soldQuantity) {
        this.quantity -= soldQuantity;
    }

    public void resetQuantity() {
        this.quantity = INITIAL_QUANTITY;
    }

    public String outOfStock() {
        return "*** OUT OF STOCK ***";
    }
}
