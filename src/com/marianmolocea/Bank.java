package com.marianmolocea;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Bank {
    Double[] acceptedCoins = {0.05, 0.10, 0.20, 0.50, 1.00};
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

    public void dispenseChange(double change) {
        double changeToDispense = change;
        System.out.println("\033[0;36m***** CHANGE DISPENSED *****");
        for(int i = acceptedCoins.length - 1; i >= 0; i--) {
            if(changeToDispense > 0) {
                while (coinsQuantity[i] != 0 && (changeToDispense / acceptedCoins[i] >= 1)) {
                    removeCoins(acceptedCoins[i]);
                    changeToDispense = (Math.round((changeToDispense - acceptedCoins[i]) * 100D)) / 100D;
                    System.out.println("\t\t\t£" + acceptedCoins[i]);
                }
            }
        }
        System.out.println("****************************\u001B[0m");
    }
}
