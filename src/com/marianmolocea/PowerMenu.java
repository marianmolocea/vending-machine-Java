package com.marianmolocea;

import java.util.Scanner;

public class PowerMenu {

    static Scanner input = new Scanner(System.in);
    static boolean adminSession = true;

    public static void displayMenu(Bank bank) {
        adminSession = true;
        while(adminSession) {
            System.out.println("*** ADMIN MENU ***");
            System.out.println("1.\t Total profit / losses");
            System.out.println("2.\t Total money in the machine");
            System.out.println("3.\t Withdraw all profits");
            System.out.println("4.\t Exit Admin Menu");
            System.out.print("Select your option: ");
            int selectedOption = input.nextInt();

            adminOptions(selectedOption, bank);
        }
    }

    public static void adminOptions(int option, Bank bank) {
        switch (option) {
            case 1:
                bank.totalSales();
                break;
            case 2:
                bank.totalMoney();
                break;
            case 3:
                bank.restFloat();
                break;
            case 4:
                adminSession = false;
                break;
            default:
                System.out.println("\u001B[31mPlease enter a valid option!\u001B[0m");
        }
    }
}
