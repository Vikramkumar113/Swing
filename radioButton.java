import javax.swing.*;
public class radioButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");

        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("female");

        r1.setBounds(75,50,100,30);
        r2.setBounds(75,100,100,30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);


        frame.add(r1);
        frame.add(r2);
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}
