package com.marianmolocea;

import java.util.Scanner;

public class SnaksMenu {
    Snack crisps = new Snack("Crisps\t\t", 0.75D);
    Snack mars = new Snack("Mars Bar\t", 0.70D);
    Snack cola = new Snack("Coca Cola zero", 1.00D);
    Snack eugenia = new Snack("Eugenia\t\t", 0.50D);
    Snack water = new Snack("Water\t\t", 0.85D);

    Snack[] snacks = {crisps, mars, cola, eugenia, water};
    Scanner scanner = new Scanner(System.in);
    boolean activeSession = true;

    public void snacksMenu(Bank bank) {
        //Display the snacks menu
        System.out.println("NR\tSNACK\t\t\t\tPRICE\t\tQTY");
        for(byte i = 0; i <= snacks.length - 1; i++) {
            System.out.println(
                (i+1) + "\t" +
                snacks[i].name + "\t\t" + "£" +
                snacks[i].price + "\t\t" +
                (snacks[i].quantity > 0 ? snacks[i].quantity : snacks[i].outOfStock())
            );
        }

        //Request user option.
        System.out.print("Please select your option: ");
        int selectedItem = scanner.nextInt();

        if(selectedItem > 0 && selectedItem <= snacks.length) {
            // Get the quantity from user
            System.out.print("Please select the quantity: ");
            byte itemQuantity = scanner.nextByte();
            byte quantity = selectQuantity(itemQuantity, (byte) snacks[selectedItem - 1].quantity);

            //Handle the payment and dispense the items
            Payment.makePayment(snacks[selectedItem - 1], quantity, bank);

            //Decrease the stock.
            snacks[selectedItem - 1].decreaseQuantity(quantity);
        }
        else if (selectedItem == 10976) {
            System.out.println("Power Menu");
            bank.totalSales();
        }
        else
            System.out.println("\u001B[31mYour selection is invalid!\u001B[0m");

        System.out.println("Would you like to buy anything else? \n [1] YES | [0] NO");
        byte session = scanner.nextByte();

        if(session == 0) {
            activeSession = false;
        }
    }

    public static byte selectQuantity(byte quantity, byte inStock) {
        if (quantity <= 1)
            return 1;
        else if (quantity > inStock) {
            System.out.println("Only " + inStock + " items in stock");
            return inStock;
        }
        else
            return quantity;
    }
}
