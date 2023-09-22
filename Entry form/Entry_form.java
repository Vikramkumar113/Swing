import java.awt.*;
import java.awt.event.*;
import page2.Details;

public class Entry_form extends Frame implements ActionListener , ItemListener{

    Label heading,l1,l2,l3,l4,l5,l6;
    Button submit,close;
    TextField name,password;
    Checkbox r1,r2;
    CheckboxGroup cbg;
    Choice C;
    List states,cities;
    Font F1,F2,F3,F4;
    String[] data = new String[6];

    public Entry_form(){
        super("ENTRY FORM");

        F1 = new Font("Arial",Font.PLAIN,18);
        F2 = new Font("Arial",Font.BOLD,35);
        setFont(F1);

        //Labels
        heading = new Label("Entry Form");
        heading.setFont(F2);
        heading.setForeground(new Color(239,35,60));

        setBackground(new Color(237, 242, 244));
        setForeground(new Color(43,45,66));
        l1 =new Label("Name");
        l2 =new Label("Password");
        l3 =new Label("Gender");
        l4 =new Label("Country");
        l5 =new Label("State");
        l6 =new Label("City");

        //Buttons
        submit = new Button("SUBMIT");
        close = new Button("CLOSE");

        //Textboxes
        name = new TextField(25);
        password = new TextField(25);
        password.setEchoChar('*');

        //Radio Buttons
        cbg = new CheckboxGroup();
        r1 = new Checkbox("Male",false, cbg);
        r2 = new Checkbox("Female", false,cbg);

        //Combo box
        C = new Choice();
        C.add("India");
        C.add("USA");
        C.add("England");
        C.add("France");
        C.add("Russia");

        //List
        states = new List();
        states.add("Rajasthan");
        states.add("Utter pradesh");
        states.add("Gujarat");
        states.add("Maharashtra");
        states.add("Panjab");

        cities = new List();
        cities.add("Jaipur");
        cities.add("Jodhpur");
        cities.add("Ajmer");
        cities.add("Udaipur");

        //Setting Bounds
        heading.setBounds(300,100,200,60);
        l1.setBounds(200,200,200,40);
        l2.setBounds(200,250,200,40);
        l3.setBounds(200,300,200,40);
        l4.setBounds(200,350,200,40);
        l5.setBounds(200,400,200,40);
        l6.setBounds(200,450,200,40);

        name.setBounds(400, 200, 250, 40);
        password.setBounds(400, 250, 250, 40);
        r1.setBounds(400, 300, 250, 20);
        r2.setBounds(400, 320, 250, 20);
        C.setBounds(400, 350, 250, 40);
        states.setBounds(400, 400, 250, 25);
        cities.setBounds(400, 450, 250, 25);

        close.setBounds(220,550,200,50);
        submit.setBounds(430,550,200,50);

        submit.addActionListener(this);
        close.addActionListener(this);

        r1.addItemListener(this);
        r2.addItemListener(this);

        //Adding to Window
        add(heading);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(name);
        add(password);
        add(r1);
        add(r2);
        add(C);
        add(states);
        add(cities);
        add(close);
        add(submit);
        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setResizable(true);
    }

    public void storeData(){
        data[1] = name.getText();
        data[2] = password.getText();
        data[3] = C.getSelectedItem();
        data[4] = states.getSelectedItem();
        data[5] = cities.getSelectedItem();
    }

    public void showData(String[] data){
        Details detail = new Details(data);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == close){
            System.exit(0);
        }
        if(ae.getSource() == submit){
            storeData();
            showData(data);
        }
    }

    public void itemStateChanged(ItemEvent ie){
        if(r1.getState() == true){
            data[0] = "Male";
        }
        if(r2.getState() == true){
            data[0] = "Female";
        }

    }

    public static void main(String s[]){
        Entry_form EF = new Entry_form();
    }
}