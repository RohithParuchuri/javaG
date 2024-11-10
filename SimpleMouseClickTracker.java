import java.awt.event.InputEvent;
import java.util.Scanner;
import clicker.*;;

public class SimpleMouseClickTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Delay: ");
        int time = sc.nextInt();
        System.out.print("Number of repetition: ");
        int rep = sc.nextInt();
        int mask = InputEvent.BUTTON1_DOWN_MASK;
        Click btn = new Click(mask); // creates button type to be cilckable
        btn.click(time, rep);
    }
}