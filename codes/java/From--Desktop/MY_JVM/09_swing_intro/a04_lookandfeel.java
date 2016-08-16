import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.plaf.metal.MetalLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

/*
<applet 
  codebase="temp"
  code="a04_lookandfeel.class"
  alt="Probando Applet"
  name="a00_mouselistener"
  width="300"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

public class a04_lookandfeel extends JApplet
{
 JRadioButton b1 = new JRadioButton("Metal"),
              b2 = new JRadioButton("Motif"),
							b3 = new JRadioButton("Windows");
 
 public void init()
 {
  Container contentPane = getContentPane();
	contentPane.add(new jpanel(), BorderLayout.CENTER);
 }

	class jpanel extends JPanel implements ActionListener
	{
	 jpanel()
	 {
		setBackground(Color.white);
		
		add( new JButton("JBoton") );
		add( new JTextField("JCuadro_de_Texto") );
		add( new JCheckBox("JCasilla_de_Activacion") );
		add( new JRadioButton("JBoton_de_Opcion") );
		add( new JLabel("JEtiqueta") );
		add( new JList ( new String[] { "JLista Elemento 1",
																		"JLista Elemento 2",
																		"JLista Elemento 3" } ) );
		add(new JScrollBar(SwingConstants.HORIZONTAL));
		
		ButtonGroup group = new ButtonGroup();
		group.add(b1);
		group.add(b2);
		group.add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		add(b1);
		add(b2);
		add(b3);
	 }
	 
	 public void actionPerformed(ActionEvent e)
	 {
		JRadioButton src = (JRadioButton)e.getSource();
		
		try
		 {
			if ((JRadioButton)e.getSource() == b1)
				UIManager.setLookAndFeel (
				 "javax.swing.plaf.metal.MetalLookAndFeel");
			else if ((JRadioButton)e.getSource() == b2)
				UIManager.setLookAndFeel (
				 "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			else if ((JRadioButton)e.getSource() == b3)
				UIManager.setLookAndFeel (
				 "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		 }
		 
		 catch(Exception ex) {}
		 
		 SwingUtilities.updateComponentTreeUI(getContentPane());
	 }
	
	/* 
	 public void paintComponent(Graphics g)
	 {
		super.paintComponent(g);
		g.drawString("Hola desde Swing con a04_lookandfeel",0,60);
	 }
	*/
	} 
 
}

