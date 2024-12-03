package com.example;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class StartBackend {
    private static boolean listenersActive = true;
    private static boolean isRecording = false;  // Track if recording is active

    public void startBackend() {
        try {
            // Register the native hook
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        // Add the mouse and keyboard listeners
        MouseListener mouseListener = new MouseListener();
        GlobalScreen.addNativeMouseListener(mouseListener);

        KeyListener keyListener = new KeyListener();
        GlobalScreen.addNativeKeyListener(keyListener);

        // The loop that keeps the program running
        while (listenersActive) {
            try {
                Thread.sleep(1000);  // Keep the program alive, waiting for key events
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        exit();  // Ensure the program exits cleanly
    }

    // Stops listeners (Ctrl + X to stop)
    public static void stopListeners() {
        if (listenersActive) {
            listenersActive = false;
            System.out.println("Listeners stopped.");
        }
    }

    // Start recording (Ctrl + R to start)
    public static void startRecording() {
        if (!isRecording) {
            ClickData.clearData();
            isRecording = true;
            System.out.println("Recording started.");
        } else {
            System.out.println("Already recording.");
        }
    }

    // Stop recording (Ctrl + R to stop)
    public static void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println("Recording stopped.");
        } else {
            System.out.println("Not recording.");
        }
    }

    // Exit program (Ctrl + X to exit)
    public static void exit() {
        try {
            GlobalScreen.unregisterNativeHook();  // Unregister hooks when done
            System.out.println("Exiting program.");
            System.exit(0);  // Exit the program
        } catch (NativeHookException e) {
            System.err.println("Error unregistering native hooks.");
            e.printStackTrace();
        }
    }

    // This function returns whether recording is active or not
    public static boolean isRecording() {
        return isRecording;
    }
}
