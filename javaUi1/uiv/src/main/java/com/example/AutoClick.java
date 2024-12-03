package com.example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClick {
    static boolean b = true;
    public static void clickMouse(int k, int n) {
        try {
            Robot robot = new Robot();  
            b = true;        
            if (n == -1)
            {
                while (b)
                {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                
                    // Wait for k seconds before the next click
                    Thread.sleep(k * 1000); // Convert seconds to milliseconds
                }
            }
            else
            {
                for (int i = 0; i < n; i++) {
                    // Press and release the left mouse button
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                                
                    // Wait for k seconds before the next click
                    Thread.sleep(k * 1000); // Convert seconds to milliseconds
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}