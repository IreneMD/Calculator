package calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Widget extends JPanel {

    private static final long serialVersionUID = -1;

    private JTextField display = new JTextField("0");

    private ActionListener listener;

    public static JFrame makeWindow(String title) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(200, 200);
        frame.addWindowListener(new Close());

        Container contentPane = frame.getContentPane();
        contentPane.add(new Widget());
        return frame;
    }

    private Widget() {
        listener = new Listener(this);
        setLayout(new BorderLayout());

        display.setEditable(false);
        add(display, "North");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String buttonLabels = "789/456*123-0.=+";
        for (int i = 0; i < buttonLabels.length(); i++) {
            JButton b = new JButton(buttonLabels.substring(i, i + 1));
            panel.add(b);
            b.addActionListener(listener);
        }
        add(panel, "Center");
    }

    public void setText(String text) {
        this.display.setText(text);
    }

    public String getText() {
        return this.display.getText();
    }
}
