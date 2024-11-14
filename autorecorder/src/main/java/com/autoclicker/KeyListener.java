package com.autoclicker;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Check if Ctrl + Q is pressed
        if (e.getKeyCode() == NativeKeyEvent.VC_Q && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
            App.stopListeners();
            App.runRest();
        }
    }
}