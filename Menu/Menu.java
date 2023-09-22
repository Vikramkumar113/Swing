import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener{

    Container C;
    JMenuBar mb;
    JMenu file,edit,view,color;
    JMenuItem newFile,open,save,saveAs,close,cut,copy,paste,red,green,blue;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JScrollBar sb1,sb2,sb3;
    int r=0,g=0,b=0;

    public Menu(){
        super("Menu Bar with Items");

        C = getContentPane();
        C.setBackground(Color.white);

        buildLayout();
        setLayout(null);
        setSize(800,600);
        setVisible(true);
    }

    public void buildLayout(){
        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        color = new JMenu("Color");
        newFile = new JMenuItem("New File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save as");
        close = new JMenuItem("Close");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        red = new JMenuItem("Red");
        green = new JMenuItem("Green");
        blue = new JMenuItem("Blue");
     
        l1 = new JLabel("RED    :");
        l2  = new JLabel("GREEN  :");
        l3 = new JLabel("BLUE   :");
        t1 = new JTextField(""+r);
        t2 = new JTextField(""+g);
        t3 = new JTextField(""+b);
        sb1 = new JScrollBar(JScrollBar.HORIZONTAL,0,30,0,285);
        sb2 = new JScrollBar(JScrollBar.HORIZONTAL,0,30,0,285);
        sb3 = new JScrollBar(JScrollBar.HORIZONTAL,0,30,0,285);

        l1.setBounds(150,200,100,30);
        l2.setBounds(150,240,100,30);
        l3.setBounds(150,280,100,30); 
        t1.setBounds(280,200,40,30);
        t2.setBounds(280,240,40,30);
        t3.setBounds(280,280,40,30);
        sb1.setBounds(350,200,200,30);
        sb2.setBounds(350,240,200,30);
        sb3.setBounds(350,280,200,30);
        
        setListeners();

        file.add(newFile);
        file.add(open);
        file.addSeparator();
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(close);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        color.add(red);
        color.add(green);
        color.add(blue);
        view.add(color);
        mb.add(file);
        mb.add(edit);
        mb.add(view);
        setJMenuBar(mb);

        C.add(l1);
        C.add(l2);
        C.add(l3);
        C.add(t1);
        C.add(t2);
        C.add(t3);
        C.add(sb1);
        C.add(sb2);
        C.add(sb3);
    }

    public void setListeners(){
        close.addActionListener(this);
        red.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);

        
        sb1.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent ae){
                r=sb1.getValue();
                t1.setText(""+r);
                C.setBackground(new Color(r,g,b));
            }
        });
        sb2.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent ae){
                g=sb2.getValue();
                t2.setText(""+g);
                C.setBackground(new Color(r,g,b));
            }
        });
        sb3.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent ae){
                b=sb3.getValue();
                t3.setText(""+b);
                C.setBackground(new Color(r,g,b));
            }
        });

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == close)  this.dispose();
        else if(ae.getSource() == red) C.setBackground(Color.red);
        else if(ae.getSource() == green) C.setBackground(Color.green);
        else if(ae.getSource() == blue) C.setBackground(Color.blue);
    }

    
    public static void main(String s[]) {
        Menu m =new Menu();
    }
}
