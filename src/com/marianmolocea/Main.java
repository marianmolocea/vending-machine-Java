package com.marianmolocea;

public class Main {

    static SnaksMenu menu = new SnaksMenu();
    static Bank bank = new Bank();

    public static void main(String[] args) {

        // Loop over the snacks menu and execute the methods chained within.
        while(menu.activeSession) {
            menu.snacksMenu(bank);
        }
    }
}
