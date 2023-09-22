import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class InsertData extends JFrame implements ActionListener{

    JLabel heading,l1,l2,l3,l4;
    JButton insert,close,delete,fetch;
    JTextField enroll,name,age;
    Font F1,F2;1234511

    public InsertData(){
        super("Student Database");

        F1 = new Font("Arial",Font.BOLD,35);
        F2 = new Font("Arial",Font.PLAIN,25);

        //Labels
        heading = new JLabel("Entry Form");
        heading.setFont(F1);
        heading.setForeground(new Color(239,35,60));

        setBackground(new Color(237, 242, 244));
        setForeground(new Color(43,45,66));

        l1 =new JLabel("Enroll :");
        l2 =new JLabel("Name :");
        l3 =new JLabel("Age : ");
        l4 =new JLabel("Enter details to insert");
        l4.setForeground(Color.red);

        //Textboxes
        enroll = new JTextField(25);
        name = new JTextField(25);
        age = new JTextField(25);

        //Buttons
        insert = new JButton("INSERT");
        close = new JButton("CLOSE");
        delete = new JButton("DELETE");
        fetch = new JButton("FETCH");

        //Setting Bounds
        heading.setBounds(300,100,200,60);
        l1.setBounds(200,200,200,40);
        l2.setBounds(200,250,200,40);
        l3.setBounds(200,300,200,40);
        l4.setBounds(200,350,400,40);

        enroll.setBounds(400, 200, 250, 40);
        name.setBounds(400, 250, 250, 40);
        age.setBounds(400, 300, 250, 40);

        insert.setBounds(325,400,200,50);
        delete.setBounds(220,470,200,50);
        fetch.setBounds(430,470,200,50);
        close.setBounds(325,530,200,50);

        insert.addActionListener(this);
        close.addActionListener(this);
        delete.addActionListener(this);
        fetch.addActionListener(this);

        //Adding to Window
        add(heading);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(enroll);
        add(name);
        add(age);
        add(close);
        add(insert);
        add(delete);
        add(fetch);

        setLayout(null);
        setSize(850,800);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == close){
            System.exit(0);
        }
        else if(ae.getSource() == insert){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:Student32");
                Statement st=con.createStatement();
                String query = "select sid from student where sid=" + enroll.getText();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    l4.setText("Record already exists!");
                }
                else{
                    query = "INSERT INTO student (sid,sname,age) VALUES ('" + enroll.getText() +"','"+name.getText()+"','"+age.getText()+"')";
                    st.executeUpdate(query);
                    l4.setText("Record inserted successfully!");
                    enroll.setText(""+(Integer.parseInt(enroll.getText())+1));
                    name.setText("");
                    age.setText("");
                }
                con.close();
                st.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return;
        }
        else if(ae.getSource() == fetch){
            FetchData fd = new FetchData();
            return;
        }
        else if(ae.getSource() == delete){
            DeleteData dd = new DeleteData();
            return;
        }
        else{
            return;
        }
    }

    public static void main(String s[]){
        InsertData ID = new InsertData();
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:Student32");
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("select max(sid) from student");
            if(rs.next()){
                ID.enroll.setText(""+(rs.getInt(1) + 1));   
            }
            else{
                ID.enroll.setText(""+1);   
            }
            con.close();
            st.close();
            rs.close();            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

class DeleteData extends JFrame implements ActionListener{

    JLabel heading,l1,l2;
    JTextField enroll;
    JButton delete,ok;
    Font F1,F2;

    public DeleteData(){
        super("Delete Record");

        F1 = new Font("Arial",Font.PLAIN,25);
        F2 = new Font("Arial",Font.BOLD,35);

        //Labels
        heading = new JLabel("DELETE RECORD");
        heading.setFont(F2);
        heading.setForeground(new Color(239,35,60));

        setBackground(new Color(237, 242, 244));
        setForeground(new Color(43,45,66));

        l1 =new JLabel("Enroll :");
        l2 =new JLabel("Enter enrollment number to delete that record");

        ok = new JButton("OK");
        delete = new JButton("DELETE");

        //Textboxes
        enroll = new JTextField(25);

        //Setting Bounds
        heading.setBounds(200,100,400,60);
        l1.setBounds(100,200,200,40);
        l2.setBounds(100,250,400,40);
        l2.setForeground(Color.red);

        enroll.setBounds(300, 200, 250, 40);

        delete.setBounds(200, 300, 200, 50);
        ok.setBounds(200, 360, 200, 50);
        delete.addActionListener(this);
        ok.addActionListener(this);

        //Adding to Window
        add(heading);
        add(l1);
        add(l2);
        add(enroll);
        add(ok);
        add(delete);

        setLayout(null);
        setSize(650,550);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:Student32");
                Statement st=con.createStatement();
                String query = "select sid from student where sid=" + enroll.getText();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    query = "DELETE FROM student WHERE sid=" + enroll.getText();
                    st.executeUpdate(query);
                    enroll.setText("");
                    l2.setText("Record deleted successfully!");
                }
                else{
                    l2.setText("Record not found!");
                }
                con.close();
                st.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            this.dispose();
        }
    }
}

class FetchData extends JFrame implements ActionListener{

    JLabel heading,l1,l2,l3,l4;
    JTextField enroll,name,age;
    JButton fetch,ok;
    Font F1,F2;

    public FetchData(){
        super("Record");

        F1 = new Font("Arial",Font.PLAIN,25);
        F2 = new Font("Arial",Font.BOLD,35);

        //Labels
        heading = new JLabel("STUDENT");
        heading.setFont(F2);
        heading.setForeground(new Color(239,35,60));

        setBackground(new Color(237, 242, 244));
        setForeground(new Color(43,45,66));

        l1 =new JLabel("Enroll :");
        l2 =new JLabel("Name :");
        l3 =new JLabel("Age : ");
        l4 =new JLabel("Enter enrollment number and fetch record");

        ok = new JButton("OK");
        fetch = new JButton("FETCH");

        //Textboxes
        enroll = new JTextField(25);
        name = new JTextField(25);
        age = new JTextField(25);

        //Setting Bounds
        heading.setBounds(200,100,200,60);
        l1.setBounds(100,200,200,40);
        l2.setBounds(100,250,200,40);
        l3.setBounds(100,300,200,40);
        l4.setBounds(100,350,400,40);
        l4.setForeground(Color.red);

        enroll.setBounds(300, 200, 250, 40);
        name.setBounds(300, 250, 250, 40);
        age.setBounds(300, 300, 250, 40);

        fetch.setBounds(200, 400, 200, 50);
        ok.setBounds(200, 460, 200, 50);
        fetch.addActionListener(this);
        ok.addActionListener(this);

        //Adding to Window
        add(heading);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(enroll);
        add(name);
        add(age);
        add(ok);
        add(fetch);

        setLayout(null);
        setSize(650,750);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetch){
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con = DriverManager.getConnection("jdbc:odbc:Student32");
                Statement st=con.createStatement();
                String query = "select * from student where sid=" + enroll.getText();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    name.setText(rs.getString("sname"));
                    age.setText(""+rs.getInt("age"));
                    l4.setText("Record Fetched Successfully!");
                }
                else{
                    name.setText("");
                    age.setText("");
                    l4.setText("Record not found!");
                }
                con.close();
                st.close();
                rs.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            this.dispose();
        }
    }
}