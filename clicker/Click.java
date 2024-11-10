package clicker;

import java.awt.Robot;

public class Click {
    static int mask;
    public Click(int m)
    {
        this.mask = m;
    }
    public void click(int time, int rep)
    {
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