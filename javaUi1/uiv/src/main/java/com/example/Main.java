package com.example;

public class Main {
    public static void main(String[] args) {
        App a = new App();
        a.runUI();
        StartBackend s = new StartBackend();
        s.startBackend();
    }
}