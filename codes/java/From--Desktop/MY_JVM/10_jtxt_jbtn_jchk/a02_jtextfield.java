import java.awt.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a02_jtextfield.class"
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

public class a02_jtextfield extends JApplet
{
 JTextField text = new JTextField(20);
 
 public void init()
 {
  Container contentPane = getContentPane();
	
	contentPane.setLayout(new FlowLayout());
	contentPane.add(text);
	text.setText("Hola desde a02_jtextfield");
 }
}

