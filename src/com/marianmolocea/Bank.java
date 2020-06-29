package com.marianmolocea;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Bank {
    Double[] acceptedCoins = {0.05D, 0.10D, 0.20D, 0.50D, 1.00D};
    final int[] INITIAL_COINS_QUANTITY = {20, 20, 20, 20, 10};
    int[] coinsQuantity = INITIAL_COINS_QUANTITY;

    public void restFloat() {
        coinsQuantity = INITIAL_COINS_QUANTITY;
    }

    public void addCoin(double coinValue) {
        coinsQuantity[Arrays.asList(acceptedCoins).indexOf(coinValue)] += 1;
    }

    public void removeCoins(double coinValue) {
        coinsQuantity[Arrays.asList(acceptedCoins).indexOf(coinValue)] -= 1;
    }
}
