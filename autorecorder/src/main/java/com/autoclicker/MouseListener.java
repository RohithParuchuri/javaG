package com.autoclicker;

import java.util.Date;

import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;


public class MouseListener implements NativeMouseInputListener {
    
    long lastClickTime = 0;
    
    public void nativeMousePressed(NativeMouseEvent e) {
        System.out.println("Mouse Pressed: " + e.getButton());
        long currClickTime = new Date().getTime();
        long t = 0;
        if (lastClickTime != 0)
        {
            t = lastClickTime - currClickTime;
        }
        ClickData.putData(e.getX(), e.getY(), t);
        lastClickTime = currClickTime;
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        System.out.println("Mouse Released: " + e.getButton());
    }    
}
