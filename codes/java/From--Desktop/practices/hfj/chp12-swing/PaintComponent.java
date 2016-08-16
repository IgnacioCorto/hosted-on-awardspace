import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class PaintComponent extends JPanel {
    JButton button, button2;
    JFrame MyWindow;

    public static void main (String [] args) /* throws Exception */ {
        PaintComponent obj = new PaintComponent();
        obj.go();
    }

    void go () {
        MyWindow = new JFrame();
        button = new JButton("Change my text!!");
        button2 = new JButton("Update Color!!");
        PaintComponent cuadro = new PaintComponent();

        MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyWindow.setSize(300,300);
        MyWindow.setVisible(true);
        
        MyWindow.getContentPane().add(BorderLayout.CENTER, cuadro);
        MyWindow.getContentPane().add(BorderLayout.WEST, button);
        MyWindow.getContentPane().add(BorderLayout.EAST, button2);
        
        button.addActionListener( new UpdateButton() );
        button2.addActionListener( new UpdateColor() );
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(Color.orange);
        int c_red   = (int) (Math.random()*256);
        int c_green = (int) (Math.random()*256);
        int c_blue  = (int) (Math.random()*256);
        
        GradientPaint gradient = new GradientPaint(
                50,50,Color.blue,
                250,250,new Color(c_red,c_green,c_blue) );
        g2d.setPaint(gradient);
        g2d.fillRect(0,0,200,200);
        
        Image image = new ImageIcon("ely.jpg").getImage();
        g2d.drawImage(image,0,0,this);
    }
    
    class UpdateColor implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            MyWindow.repaint();
        }
    }
    
    class UpdateButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            button.setText("You changed my text. Good!!");
        }
    }

}