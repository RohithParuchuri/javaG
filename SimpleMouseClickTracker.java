import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class SimpleMouseClickTracker {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Delay: ");
        int time = sc.nextInt();
        System.out.print("Number of repetition: ");
        int rep = sc.nextInt();
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        
        try {
            Robot bot = new Robot();
            for (int i = 0; i < rep; i++) { // Click rep times
                Thread.sleep(time);
                bot.mousePress(mask);
                bot.mouseRelease(mask);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        }
    }
}