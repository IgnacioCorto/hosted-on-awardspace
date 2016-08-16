import java.awt.*;
import javax.swing.*;

class MyGridBagLayout {
    public static void main (String [] args) {
        new MyGridBagLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();
/*
        // LAYOUT DEFINITION
        GridBagLayout myGridBagLayoutTest = new GridBagLayout();
        pane.setLayout(myGridBagLayoutTest);
        
        GridBagConstraints gbc1 = new GridBagConstraints();
        
        gbc1.gridx = 0;   // Component Colum Position in Grids
        gbc1.gridy = 0;   //Component Row Position in Grids

        gbc1.gridwidth = 2;   // Component Width in Grid Units
        gbc1.gridheight = 2;  // Component Height in Grid Units

        gbc1.fill = GridBagConstraints.NONE;  // Don't use Extra-Grids to resize Component
        
        gbc1.ipadx = 1; // Component Internal  X Padding
        gbc1.ipady = 1; // Component Internal  Y Padding

        gbc1.insets = new Insets(5,5,5,5);  // Component Top, Left, Bottom, Right Margins
        gbc1.anchor = GridBagConstraints.FIRST_LINE_END;  //Component Alignment inside a Grid
        
        gbc1.weightx = 20.0;
        gbc1.weighty = 10.0;
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button);

        button = new JButton("Button 2 (CENTER)");          //Make the center component big, 
        button.setPreferredSize(new Dimension(200, 100));   //since that's the typical usage
        pane.add(button);

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button);

        button = new JButton("5 (LINE_END)");
        pane.add(button);
*/

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (false /* shouldFill */) {
        		//natural height, maximum width
        		c.fill = GridBagConstraints.HORIZONTAL;
        }

        button = new JButton("Button 1");
        if (false /* shouldWeightX */) {
        		   c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.01;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("Long-Named Button 4B");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);
        
        
        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);

       
        frm1.setSize(640,480);
        frm1.setVisible(true);

    }
}