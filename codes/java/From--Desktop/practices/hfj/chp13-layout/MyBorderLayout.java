import javax.swing.*;
import java.awt.*;

class MyBorderLayout extends JPanel {

    public static void main (String [] args) {
        MyBorderLayout obj = new MyBorderLayout();
        obj.executeProgram();
    }

    void executeProgram () {
        JFrame f = new JFrame("Hola");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300,300);
        f.setVisible(true);
       
        JButton b1 = new JButton("Click Me like you mean it!!");
        Font fnt1 = new Font ("Serif",Font.BOLD, 28);
        b1.setFont(fnt1);

        JButton btn2 = new JButton("Impress me!!");
        JButton btn3 = new JButton("Button 3");

        JPanel pnl1 = new JPanel();
        pnl1.setBackground(Color.darkGray);
        pnl1.add(btn2);
        pnl1.add(btn3);
        
        for(int i = 0; i<10 ; i++) {
            pnl1.add( new JButton("On-The-Fly") );
        }
        
        JButton btn4 = new JButton("Button 4");
        JButton btn5 = new JButton("Button 5");
        JButton btn6 = new JButton("Button 6");

        JPanel pnl2 = new JPanel();
        pnl2.setLayout( new BoxLayout(pnl2, BoxLayout.Y_AXIS) );
        pnl2.setBackground(Color.green);
        pnl2.add(btn4);
        pnl2.add(btn5);
        pnl2.add(btn6);

        for(int i = 0; i<10 ; i++) {
            pnl2.add( new JButton("On-The-Fly") );
        }

        f.getContentPane().add(BorderLayout.WEST, b1);
        f.getContentPane().add(BorderLayout.EAST, pnl1);
        f.getContentPane().add(BorderLayout.CENTER, pnl2);
    }
   

}