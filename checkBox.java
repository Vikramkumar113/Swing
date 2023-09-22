import javax.swing.JCheckBox;

import javax.swing.*;
public class checkBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);

        JCheckBox cb = new JCheckBox();
        cb.setBounds(40,100,200,20);
        frame.add(cb);
    }
    
}
