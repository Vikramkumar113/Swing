import javax.swing.*;
import java.awt.event.*;
public class sum extends JFrame implements ActionListener{
   
        JTextField t1;
        JTextField t2;
        JTextField t3;
        JButton B1;
        sum(){
          t1 = new JTextField();
          t2 = new JTextField();
          t3 = new JTextField();
          B1 = new JButton("ADD");

        t1.setBounds(40,100,200,20);
        t2.setBounds(60,120,220,40);
        t3.setBounds(100,180,300,100);
        B1.setBounds(400,200,100,80);

        B1.addActionListener(this);

        add(t1);
        add(t2);
        add(t3);
        add(B1);

        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setResizable(true);
        }

        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()== B1)
            {
               int x=Integer.parseInt(t1.getText());
			   int y=Integer.parseInt(t2.getText());
			   int addition=x+y;
			   t3.setText(""+addition);
            }
        }

        public static void main(String s[])
        {
            sum add = new sum();
        }   
}
