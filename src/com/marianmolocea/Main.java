package com.marianmolocea;

public class Main {

    static SnaksMenu menu = new SnaksMenu();

    public static void main(String[] args) {

        Bank fl = new Bank();
        fl.addCoin(1.00D);

        while(menu.activeSession) {
            menu.snacksMenu();
        }
    }
}
