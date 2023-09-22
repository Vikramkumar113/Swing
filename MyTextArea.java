import javax.swing.*;
public class MyTextArea {
    public static void main(String[] args) {
        JFrame frame = new JFrame("example Text Field");
        frame.setSize(350,350);
        frame.setLayout(null);
        frame.setVisible(true);

        JTextArea y = new JTextArea(50,100);

        JScrollBar sb = new JScrollBar();

        y.setBounds(40,100,200,20);

        sb.setBounds(50, 120, 240, 60);

        frame.add(sb);
        frame.add(y);

    }
    
}
