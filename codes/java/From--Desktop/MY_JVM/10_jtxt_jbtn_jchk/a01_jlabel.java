import java.awt.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a01_jlabel.class"
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

public class a01_jlabel extends JApplet
{
 public a01_jlabel()
 {
  Container contentPane = getContentPane();
	JLabel miJLabel = new JLabel("Hola desde a01_jlabel",
															 new ImageIcon("temp/icon.jpg"),
															 JLabel.CENTER); //CENTER

//	miJLabel.setVerticalTextPosition(JLabel.BOTTOM);
	miJLabel.setHorizontalTextPosition(JLabel.RIGHT);  //CENTER

//  PRIMER CODIGO
//	contentPane.setLayout(new FlowLayout());

	contentPane.add(miJLabel);
 }
}

