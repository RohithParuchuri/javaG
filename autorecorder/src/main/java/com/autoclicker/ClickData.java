package com.autoclicker;

import java.util.ArrayList;

class StructOfData
{
    int x;
    int y;
    long delay;
    StructOfData(int x, int y, long delay)
    {
        this.x = x;
        this.y = y;
        this.delay = delay;
    }
    void printer()
    {
        System.out.println(x+":"+y+"@"+delay+"ms");
    }
}

public class ClickData {
    static ArrayList<StructOfData> ar = new ArrayList<StructOfData>();
    public static void putData(int i, int j, long time)
    {
        ar.add(new StructOfData(i, j, time));
    }
    public static void printData()
    {
        for (StructOfData i: ar)
        {
            i.printer();
        }
    }
}
