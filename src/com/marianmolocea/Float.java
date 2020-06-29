package com.marianmolocea;

import java.util.Arrays;

public class Float {
    Double[] acceptedCoins = {0.05D, 0.10D, 0.20D, 0.50D, 1.00D};
    final int[] INITIAL_COINS_QUANTITY = {20, 20, 20, 20, 10};
    int[] coinsQuantity = INITIAL_COINS_QUANTITY;

    public void restFloat() {
        coinsQuantity = INITIAL_COINS_QUANTITY;
    }

    public void addCoins(double coinValue) {

    }
}
