import java.awt.*;
import javax.swing.*;

class MyBoxLayout {
    public static void main (String [] args) {
        new MyBoxLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        BoxLayout myBoxLayoutTest = new BoxLayout(pane,BoxLayout.PAGE_AXIS);
        frm1.setLayout(myBoxLayoutTest);
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button);

        //Box.createRigidArea
        pane.add(Box.createRigidArea(new Dimension(30,20)));

        button = new JButton("Button 2 (CENTER)");          //Make the center component big, 
        button.setPreferredSize(new Dimension(200, 100));   //since that's the typical usage
        button.setAlignmentX(Component.CENTER_ALIGNMENT);   // of BorderLayout.
        pane.add(button);

        //Box.createVerticalGlue
        pane.add(Box.createVerticalGlue());

        button = new JButton("Button 3 (LINE_START)");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button);

        //Box.Filler
        Dimension minSize = new Dimension(5, 100);
        Dimension prefSize = new Dimension(5, 100);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);
        pane.add( new Box.Filler(minSize, prefSize, maxSize));
        
        
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button);

        button = new JButton("5 (LINE_END)");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(button);

        frm1.setSize(640,480);
        frm1.setVisible(true);
    }
}