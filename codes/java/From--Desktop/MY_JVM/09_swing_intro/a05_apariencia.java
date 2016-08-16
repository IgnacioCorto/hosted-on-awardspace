import java.awt.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a05_apariencia.class"
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

public class a05_apariencia extends JApplet
{
 public void init()
 {
  Container contentPane = getContentPane();
	
	JNewLabel jnewlabel = new JNewLabel ( "Etiqueta Falsa" );
	
	contentPane.setLayout ( new FlowLayout() ) ;
	contentPane.add(new JLabel ("Etiqueta Real") );
	contentPane.add(jnewlabel);
 }
}

class JNewLabel extends JTextField
{
 public JNewLabel(String s)
 {
  super(s);
 }
 
 public void updateUI()
 {
  super.updateUI();
	
	setHighlighter(null);
	setEditable(false);
	
	LookAndFeel.installBorder(this, "Label.border");
	LookAndFeel.installColorsAndFont(this,
																	 "Label.background",
	                                 "Label.foreground",
																	 "Label.font");
 }
}