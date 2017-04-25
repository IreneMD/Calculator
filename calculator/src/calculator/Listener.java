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

public class Listener implements ActionListener {

    private boolean calculating;

    private Widget parent;

    private double result;

    private String operator;

    public Listener(Widget parent) {
        this.parent = parent;
        this.result = 0;
        this.calculating = true;
        this.operator = "=";
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {
            if (calculating)
                parent.setText(cmd);
            else
                parent.setText(parent.getText() + cmd);
            calculating = false;
        } else {
            if (calculating) {
                if (cmd.equals("-")) {
                    parent.setText(cmd);
                    calculating = false;
                } else
                    operator = cmd;
            } else {
                double x = Double.parseDouble(parent.getText());
                String result = calculate(x);
                parent.setText(result);
                operator = cmd;
                calculating = true;
            }
        }
    }

    private String calculate(double n) {
        if (operator.equals("+"))
            result += n;
        else if (operator.equals("-"))
            result -= n;
        else if (operator.equals("*"))
            result *= n;
        else if (operator.equals("/"))
            result /= n;
        else if (operator.equals("="))
            result = n;
        return "" + result;
    }
}
