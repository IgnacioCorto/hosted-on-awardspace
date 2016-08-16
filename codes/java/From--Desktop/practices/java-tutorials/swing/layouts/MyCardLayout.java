import java.awt.*;
import javax.swing.*;

class MyCardLayout {
    public static void main (String [] args) {
        new MyCardLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        CardLayout myCardLayoutTest = new CardLayout();
        pane.setLayout(myCardLayoutTest);
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button, "1");

        button = new JButton("Button 2 (CENTER)");          //Make the center component big, 
        button.setPreferredSize(new Dimension(200, 100));   //since that's the typical usage
        pane.add(button, "2");

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button, "3");

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button, "4");

        button = new JButton("5 (LINE_END)");
        pane.add(button, "5");

        frm1.setSize(640,480);
        frm1.setVisible(true);
        
        CardLayout cl = (CardLayout) pane.getLayout();
        try { Thread.sleep(1000); } catch (Exception ex) { ex.printStackTrace(); }
        cl.show(pane,"2");
        try { Thread.sleep(1000); } catch (Exception ex) { ex.printStackTrace(); }
        cl.show(pane,"3");
        try { Thread.sleep(1000); } catch (Exception ex) { ex.printStackTrace(); }
        cl.show(pane,"4");
        try { Thread.sleep(1000); } catch (Exception ex) { ex.printStackTrace(); }
        cl.show(pane,"5");
        
        try { Thread.sleep(1000); } catch (Exception ex) { ex.printStackTrace(); }
        myCardLayoutTest.show(pane,"1");


    }
}