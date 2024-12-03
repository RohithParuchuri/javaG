package com.example;

import java.util.Date;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {
    long lastClickTime = 0;

    public void nativeMousePressed(NativeMouseEvent e) {
        if (StartBackend.isRecording()) {  // Only record and print if recording is active
            System.out.println("Mouse Pressed: " + e.getButton());

            long currClickTime = new Date().getTime();
            long t = 0;
            if (lastClickTime != 0) {
                t = currClickTime - lastClickTime;  // Calculate delay between clicks
            }

            // Record the click with button type (1 for left-click, 2 for right-click)
            ClickData.putData(e.getX(), e.getY(), t, e.getButton()); 

            lastClickTime = currClickTime;
        }
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        if (StartBackend.isRecording()) {  // Only print if recording is active
            System.out.println("Mouse Released: " + e.getButton());
        }
    }
}
