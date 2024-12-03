package com.example;

import java.util.ArrayList;
import java.util.List;

class StructOfData {
    int x;
    int y;
    long delay;
    int button;  // 1 for left-click, 2 for right-click

    StructOfData(int x, int y, long delay, int button) {
        this.x = x;
        this.y = y;
        this.delay = delay;
        this.button = button;
    }

    void printer() {
        String buttonType = (button == 1) ? "Left Click" : "Right Click";  // Determine button type
        System.out.println(x + ":" + y + " @ " + delay + "ms | Button: " + buttonType);
    }
}

public class ClickData {
    static ArrayList<StructOfData> ar = new ArrayList<StructOfData>();

    // Method to add recorded click data (including button type)
    public static void putData(int i, int j, long time, int button) {
        ar.add(new StructOfData(i, j, time, button));  // Store x, y, delay, and button type
    }

    // Method to print all recorded click data
    public static void printData() {
        for (StructOfData i : ar) {
            i.printer();
        }
    }

    // Method to get the recorded click data (returns the list)
    public static List<StructOfData> getData() {
        return ar;  // Returns the list of recorded clicks
    }

    public static void clearData() {
        ar.clear();
    }
}
