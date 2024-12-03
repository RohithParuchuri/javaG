package com.example;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener {
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // Check if Ctrl + Q is pressed
        if (e.getKeyCode() == NativeKeyEvent.VC_Q && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
            // Print recorded data
            ClickData.printData();
        }

        // Check if Ctrl + P is pressed to play the recorded data
        // if (e.getKeyCode() == NativeKeyEvent.VC_P && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
        //     // Play the recorded data
        //     Play.playRecordedData();
        // }

        // Check if Ctrl + X is pressed to stop listeners and exit
        if (e.getKeyCode() == NativeKeyEvent.VC_X && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
            StartBackend.stopListeners();  // Stop listeners
        }

        // Check if Ctrl + R is pressed to start/stop recording
        if (e.getKeyCode() == NativeKeyEvent.VC_R && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
            if (StartBackend.isRecording()) {
                StartBackend.stopRecording();  // Stop recording
            } else {
                StartBackend.startRecording();  // Start recording
            }
        }

        // Check if Ctrl + 3 is pressed to stop playback
        if (e.getKeyCode() == NativeKeyEvent.VC_3 && (e.getModifiers() & NativeKeyEvent.CTRL_MASK) != 0) {
            Play.stopPlayback();  // Stop playback
            AutoClick.b = false;
        }
    }
}
