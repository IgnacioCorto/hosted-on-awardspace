import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/*
<applet 
  codebase="temp"
  code="a02_ventana_app.class"
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

public class a02_ventana_app
{

 //################ main ################
 public static void main(String [] args)
 {
  AppFrame f = new AppFrame();
	f.setSize(200,200);
	f.addWindowListener
	(
	 new WindowAdapter()
	 {
	  public void windowClosing(WindowEvent e)
		{
		 System.exit(0);
		}
	 }
	);
	f.show();
 }
}


 //################ init ################
class AppFrame extends Frame implements ActionListener
{
 Button b1, b2;
 labelWindow window;

 AppFrame()
 {
  setLayout(new FlowLayout());
	b1 = new Button("Visualizar la ventana");
	add(b1);
	b1.addActionListener(this);
	
	b2 = new Button("Ocultar la ventana");
	add(b2);
	b2.addActionListener(this);
	
	window = new labelWindow(this);
	window.setSize(300,300);
	window.setLocation(300,300);
 }
 
//################ actionPerformed ################
 public void actionPerformed (ActionEvent event)
 {
  if (event.getSource()==b1) window.setVisible(true);
  if (event.getSource()==b2) window.setVisible(false);
 }

}

//############# WINDOW --> labelWindow #########
class labelWindow extends Window
{
 Label label;
 labelWindow(AppFrame af)
 {
  super(af);
	setLayout(new FlowLayout());
	label = new Label("¡Hola desde Java! Esta es un WINDOW.");
	add(label);
 }

 public void paint (Graphics g)
 {
  int width = getSize().width;
  int height = getSize().height;
	g.drawRect(0,0,-width,-height);
 }
}
