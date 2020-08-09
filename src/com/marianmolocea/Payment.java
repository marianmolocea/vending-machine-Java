package com.marianmolocea;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class Payment {

    public static void makePayment(Snack item, byte quantity, Bank bank) {
        double[] acceptedCoins = {0.05D, 0.10D, 0.20D, 0.50D, 1.00D};
        double amountPayed = 0D;
        double amountToBePayed = item.price * (int) quantity;
        Scanner scanner = new Scanner(System.in);
        boolean activeSession = true;

        System.out.println("\u001B[32mAccepted coins: £0.05, £0.10, £0.20, £0.50, £1 \u001B[0m");

        //Handle the coin input
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

            //Check if the input coin is an accepted coin
            if(DoubleStream.of(acceptedCoins).anyMatch(el -> el == coin)) {
                amountPayed += coin;
                bank.addCoin(coin);
            }else if (coin == 0) {
                activeSession = false;
                break;
            }
            else System.out.println("\u001B[31mCoin not Accepted\u001B[0m");
        }

        // Handle the change dispense
        if(amountPayed > amountToBePayed && (amountToBePayed - amountPayed) < 0.05D && activeSession) {
            double changeToDispense = (Math.round((amountPayed - amountToBePayed) * 100D) / 100D);
            System.out.println(
                "Please collect your \u001B[33m" +
                item.name.trim() +
                "\u001B[0m and your change: \u001B[33m£" +
                changeToDispense +
                "\u001B[0m"
            );
            bank.dispenseChange(changeToDispense);
        }

        else if (activeSession)
            System.out.println("Please collect your \u001B[33m" + item.name.trim() + "\u001B[0m!");

    }
}
