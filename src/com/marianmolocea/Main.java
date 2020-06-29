package com.marianmolocea;

public class Main {
    static SnaksMenu menu = new SnaksMenu();
    public static void main(String[] args) {
        while(menu.activeSession) {
            menu.snacksMenu();
        }
    }




}
