import javax.swing.*;

public class MyLabel{

public static void main(String args[]) {

    JFrame frame = new JFrame("example of Label");
    frame.setSize(500,500); 
    frame.setLayout(null);
    frame.setVisible(true);

    JLabel y1  = new JLabel("username");
    
    y1.setBounds(60,60,95,30);

    frame.add(y1);
    
    

}

}
