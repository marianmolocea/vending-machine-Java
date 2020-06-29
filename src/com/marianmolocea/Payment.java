package com.marianmolocea;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Payment {

    public static void makePayment(Snack item, byte quantity) {
        double[] acceptedCoins = {0.05D, 0.10D, 0.20D, 0.50D, 1.00D};
        double amountPayed = 0D;
        double amountToBePayed = item.price * (int) quantity;
        Bank change = new Bank();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\u001B[32mAccepted coins: £0.05, £0.10, £0.20, £0.50, £1 \u001B[0m");
        while(amountPayed < amountToBePayed) {
            System.out.println(
                "Total left to pay: " +
                "\u001B[36m£" +
                (Math.round((amountToBePayed - amountPayed) * 100D) / 100D) +
                "\u001B[0m"
            );

            // Get the coin input
            System.out.print("Enter coin: ");
            double coin = scanner.nextDouble();

            if(DoubleStream.of(acceptedCoins).anyMatch(el -> el == coin)) {
                amountPayed += coin;
                change.addCoin(coin);
            }
            else System.out.println("\u001B[31mCoin not Accepted\u001B[0m");
        }

        if(amountPayed > amountToBePayed && (amountToBePayed - amountPayed) < 0.05D)
            System.out.println(
                "Please collect your \u001B[33m" +
                item.name.trim() +
                "\u001B[0m and your change: \u001B[33m£" +
                (Math.round((amountPayed - amountToBePayed) * 100D) / 100D) +
                "\u001B[0m"
            );
        else
            System.out.println("Please collect your \u001B[33m" + item.name.trim() + "\u001B[0m!");

    }
}
