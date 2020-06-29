package com.marianmolocea;

public class Main {

    static SnaksMenu menu = new SnaksMenu();
    static Bank bank = new Bank();

    public static void main(String[] args) {

        while(menu.activeSession) {
            menu.snacksMenu(bank);
        }
    }
}
