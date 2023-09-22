import javax.swing.*;
import java.awt.event.*;

public class DialogBox extends JFrame implements ActionListener {
    JButton b1, b2, b3;

    public DialogBox() {
        b1 = new JButton("Message dialog box");
        b2 = new JButton("Confirm dialog box");
        b3 = new JButton("Input dialog box");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // optional
        b1.setBounds(50, 50, 250, 30);
        b2.setBounds(50, 90, 250, 30);
        b3.setBounds(50, 130, 250, 30);

        add(b1);
        add(b2);
        add(b3);

        setTitle("Dialog Boxes");
        setSize(350,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            JOptionPane.showMessageDialog(this, "Hello");
        }

        if (ae.getSource() == b2) {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
            
            //optional
            if (choice == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Proceeding...");
            } else {
                JOptionPane.showMessageDialog(this, "Cancelled.");
            }
        }

        if (ae.getSource() == b3) {
            String input = JOptionPane.showInputDialog(this, "Enter your name:");

            // optinal
            if (input != null && !input.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Hello, " + input + "!");
            } else {
                JOptionPane.showMessageDialog(this, "You did not enter a name.");
            }
        }

    }

    public static void main(String[] args) {
        DialogBox d = new DialogBox();
    }
}
