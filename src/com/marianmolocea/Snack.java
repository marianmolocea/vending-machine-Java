package com.marianmolocea;

public class Snack {
    String name;
    double price;
    byte quantity = 10;

    public Snack(String _name, double _price) {
        name = _name;
        price = _price;
    }

    public void decreaseQuantity(byte soldQuantity) {
        quantity -= soldQuantity;
    }

    public void resetStock() {
        quantity = 10;
    }

    public String outOfStock() {
        return "*** OUT OF STOCK ***";
    }
}
