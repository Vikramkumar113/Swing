import javax.swing.*;
public class passwordField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);

       JPasswordField pf = new JPasswordField();
       pf.setBounds(40, 100, 200, 20);
       frame.add(pf);

       pf.setEchoChar('a');

       
    }
    
}
