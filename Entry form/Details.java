package page2;
import java.awt.*;
import java.awt.event.*;
public class Details extends Frame implements ActionListener,ItemListener{

    Label heading,l1,l2,l3,l4,l5,l6;
    Button ok;
    Checkbox c;
    String password;

    public Details(String[] data){
        super("Details");

        password = data[2];

        ok = new Button("OK");
        c = new Checkbox();
        heading = new Label("YOUR DETAILS");
        l1 = new Label("Name     : " + data[1]);
        l2 = new Label("Password   :   **********");
        l3 = new Label("Gender   : "+data[0]);
        l4 = new Label("Country  : "+data[3]);
        l5 = new Label("State    : "+ data[4]);
        l6 = new Label("City     : "+data[5]);

        heading.setBounds(150,50,400,100);
        l1.setBounds(100,150,300,50);
        l2.setBounds(100,200,300,50);
        l3.setBounds(100,250,300,50);
        l4.setBounds(100,300,300,50);
        l5.setBounds(100,350,300,50);
        l6.setBounds(100,400,300,50);
        ok.setBounds(150,500,200,60);
        c.setBounds(400,200,50,50);
        
        heading.setFont(new Font("Arial",Font.BOLD,25));
        heading.setForeground(new Color(233, 138, 21));

        setFont(new Font("Arial",Font.PLAIN,18));

        ok.addActionListener(this);
        c.addItemListener(this);

        add(heading);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(ok);
        add(c);

        setBackground(new Color(236, 229, 240));
        setForeground(new Color(236, 229, 240));

        setSize(500,600);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == ok){
            this.dispose();
        }
    }

    public void itemStateChanged(ItemEvent ie){
        if(c.getState() == true){
            l2.setText("Password  :  "+ password);
        }
        else{
            l2.setText("Password  :  **********");
        }
    }
}