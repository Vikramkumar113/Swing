import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Ex_f_4 extends Frame implements ActionListener
{
	Button B1;
	TextField T1;

	public Ex_f_4()
	{
		
		super("My frame");
		setLayout(null);
		T1 = new TextField();
		T1.setBounds(300,50,100,25);
		B1 = new Button("Max");
		B1.setBounds(100,100,50,50);
		B1.addActionListener(this);
		add(T1);
		add(B1);

			try
			{
				Connection con;
				Statement st;
				ResultSet rs;
			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:PRASH");
				st = con.createStatement();
				//rs = st.executeQuery("select max(sid) from Students");
				rs = st.executeQuery("select * from Students where sid = (select max(sid) from Students)");
				if(rs.next())
				{
					T1.setText(""+rs.getInt("sid"));
				}
				else
				{
					T1.setText("1000");
				}
				con.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
			}

		setSize(800,800);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==B1)
		{
			try
			{
				Connection con;
				Statement st;
				ResultSet rs;
			
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:PRASH");
				st = con.createStatement();
				//rs = st.executeQuery("select max(sid) from Students");
				rs = st.executeQuery("select * from Students where sid = (select max(sid) from Students)");
				
				if(rs.next())
				{
					T1.setText(""+(rs.getInt("sid")));
				}
				else
				{
					T1.setText("1000");
				}
				con.close();
				st.close();
				rs.close();
			}
			catch(Exception e)
			{
			}
		}

		}


	public static void main(String s[])
	{
		Ex_f_4 ob  = new Ex_f_4();
		
	}

}
		