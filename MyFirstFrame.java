import javax.swing.*;
import java.awt.*;
class MyFirstFrame{
	public static void main(String str[])
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);           // By default frame  is invisible so this method visible the frame
		frame.setSize(100,100);
		//frame.setBounds(100,100,100,100);
		frame.setTitle("My Frame");
		
		// Container c = frame.getContentPane();  
		// c.setBackground(Color.RED);

		 frame.setResizable(true);  

		ImageIcon icon = new ImageIcon("");
		frame.setIconImage(icon.getImage());
		icon.getIconWidth();
		icon.getIconHeight();
		
	}
}