import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/*
<applet 
  codebase="temp"
  code="a01_ventana.class"
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

public class a01_ventana extends Applet implements ActionListener
{
 Button b1, b2;
 labelFrame window;

//################ init ################
 public void init()
 {
  b1 = new Button("Visualizar la ventana");
	add(b1);
	b1.addActionListener(this);
	
	b2 = new Button("Ocultar la ventana");
	add(b2);
	b2.addActionListener(this);
	
	window = new labelFrame("Ventana Java");
	window.setSize(300,200);
 }
 
//################ actionPerformed ################
 public void actionPerformed (ActionEvent event)
 {
  if (event.getSource()==b1) window.setVisible(true);
  if (event.getSource()==b2) window.setVisible(false);
 }
}

//################ ventana: labelFrame ##############
class labelFrame extends Frame implements MouseListener
{
 Label label;
 labelFrame(String title)
 {
  super(title);
	setLayout(new FlowLayout());
	label = new Label("¡Hola desde Java! Esta es una ventana frame.");
	add(label);
	addMouseListener(this);
	addWindowListener( 
	 new WindowAdapter() 
	 {
	  public void windowClosing(WindowEvent e)
		{
		 setVisible(false);
		}
	 });
 }
 
//############# mousePressed ##############
 public void mousePressed(MouseEvent e)
 {
  if( (e.getModifiers() & InputEvent.BUTTON1_MASK)==InputEvent.BUTTON1_MASK)
  	 label.setText("Boton IZQUIERDO del raton pulsado en (" + e.getX() + ", " + e.getY() + ")" );
		 
	else
  	 label.setText("Boton DERECHO del raton pulsado en (" + e.getX() + ", " + e.getY() + ")" );
 }
 
//############# mouseClicked ##############
 public void mouseClicked(MouseEvent e)
 {
  label.setText("Pulso el raton en (" + e.getX() + ", " + e.getY() + ")" );
 }
 
 //############# mouseReleased ##############
 public void mouseReleased(MouseEvent e)
 {
  label.setText("Solto el boton en (" + e.getX() + ", " + e.getY() + ")" );
 }

 //############# mouseEntered ##############
 public void mouseEntered(MouseEvent e)
 {
  label.setText("Raton para introducir en (" + e.getX() + ", " + e.getY() + ")" );
 }

 //############# mouseExited ##############
 public void mouseExited(MouseEvent e)
 {
  label.setText("Raton para salir en (" + e.getX() + ", " + e.getY() + ")" );
 }


}

