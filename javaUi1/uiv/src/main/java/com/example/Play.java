package com.example;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
// import java.util.Scanner;

public class Play {
    private static boolean stopPlayback = false;  // Flag to stop playback

    // Method to stop playback
    public static void stopPlayback() {
        stopPlayback = true;
        System.out.println("Playback stopped.");
    }

    // Method to replay the recorded clicks
    // public static void playRecordedData() {
    //     try {
    //         System.out.println("Press 1 to play indefinitely or 2 to specify the number of repetitions:");
    //         Scanner scanner = new Scanner(System.in);
    //         int choice = scanner.nextInt();  // Get user choice

    //         if (choice == 1) {
    //             playIndefinitely();  // Call the indefinite playback method
    //         } else if (choice == 2) {
    //             System.out.println("Enter the number of repetitions:");
    //             int repetitions = scanner.nextInt();  // Get number of repetitions
    //             playWithRepetitions(repetitions);  // Call the repetition playback method
    //         } else {
    //             System.out.println("Invalid choice. Exiting playback.");
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    // Method to play recorded data indefinitely until stopped
    public static void playIndefinitely() {
        try {
            System.out.println("Starting indefinite playback. Press Ctrl + 3 to stop.");
            stopPlayback = false;  // Reset the stop flag
            Robot robot = new Robot();
            List<StructOfData> recordedData = ClickData.getData();

            if (recordedData.isEmpty()) {
                System.out.println("No recorded data to play.");
                return;
            }

            // Loop indefinitely through the recorded data
            while (!stopPlayback) {
                for (StructOfData data : recordedData) {
                    if (stopPlayback) break;  // Break if stop flag is set

                    robot.mouseMove(data.x, data.y);  // Move mouse
                    simulateMouseClick(robot, data);  // Simulate click
                    Thread.sleep(data.delay);  // Delay
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to play recorded data a specific number of times
    public static void playWithRepetitions(int repetitions) {
        try {
            System.out.println("Starting playback for " + repetitions + " repetitions. Press Ctrl + 3 to stop.");
            stopPlayback = false;  // Reset the stop flag
            Robot robot = new Robot();
            List<StructOfData> recordedData = ClickData.getData();

            if (recordedData.isEmpty()) {
                System.out.println("No recorded data to play.");
                return;
            }

            // Loop through the recorded data for the specified number of repetitions
            for (int i = 0; i < repetitions && !stopPlayback; i++) {
                System.out.println("Repetition " + (i + 1) + " of " + repetitions);
                for (StructOfData data : recordedData) {
                    if (stopPlayback) break;  // Break if stop flag is set

                    robot.mouseMove(data.x, data.y);  // Move mouse
                    simulateMouseClick(robot, data);  // Simulate click
                    Thread.sleep(data.delay);  // Delay
                }
            }

            if (!stopPlayback) {
                System.out.println("Playback completed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to simulate mouse click
    private static void simulateMouseClick(Robot robot, StructOfData data) {
        if (data.button == 1) { // Left Click
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Simulated Left Click at: (" + data.x + ", " + data.y + ")");
        } else if (data.button == 2) { // Right Click
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            System.out.println("Simulated Right Click at: (" + data.x + ", " + data.y + ")");
        } else {
            System.out.println("Unsupported button type: " + data.button);
        }

        // Log the sleep duration
        System.out.println("Sleeping for " + data.delay + " ms...");
    }
}
