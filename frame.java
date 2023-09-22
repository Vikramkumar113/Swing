import java.awt.*;
public class frame extends Frame{
    public frame(){
        super("My Frame");
        setSize(500,500);
        setVisible(true);
        // setResizable(false);
    }
    public static void main(String s[]){
        frame f1 = new frame();
    }
}