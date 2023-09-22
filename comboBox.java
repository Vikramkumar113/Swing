import javax.swing.*;
public class comboBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);

        JComboBox cb = new JComboBox();
        cb.addItem("abc");
        cb.addItem("bcd");
      // cb.getSelectedItem();

        cb.setBounds(40, 100, 200, 20);
        frame.add(cb);

       
    }
    
}

