package calculator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Close extends WindowAdapter {

    /**
     * Event received when the close button has been pressed.
     * @param e Event
     */
    public void windowClosing(WindowEvent e) {
        System.out.println("Close has been pressed");
        System.exit(0);
    }
}
