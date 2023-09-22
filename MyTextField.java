import javax.swing.*;
public class MyTextField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);

        JTextField y = new JTextField();

        y.setBounds(40,100,200,20);

        JButton b = new JButton("Ok");
        b.setBounds(50,120,220,40);

        frame.add(y);
        frame.add(b);

       
    }
    
}
