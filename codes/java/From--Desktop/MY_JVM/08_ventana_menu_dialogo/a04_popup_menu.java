import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/*
<applet 
  codebase="temp"
  code="a04_popup_menu.class"
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

public class a04_popup_menu extends Applet implements ActionListener, MouseListener
{
 Label label;
 PopupMenu popup;
 MenuItem menuitem1,menuitem2,menuitem3,menuitem4;
 
//################ init ################
 public void init()
 {
  popup = new PopupMenu("Menu");

	menuitem1 = new MenuItem("Elemento #1");
	menuitem1.addActionListener(this);
	menuitem2 = new MenuItem("Elemento #2");
	menuitem2.addActionListener(this);
	menuitem3 = new MenuItem("Elemento #3");
	menuitem3.addActionListener(this);
	menuitem4 = new MenuItem("Elemento #4");
	menuitem4.addActionListener(this);

  popup.add(menuitem1);
  popup.addSeparator();
  popup.add(menuitem2);
  popup.addSeparator();
  popup.add(menuitem3);
  popup.addSeparator();
  popup.add(menuitem4);
	add(popup);
	
	label = new Label("Hola desde a04_popup_menu!!");
	add(label);
	addMouseListener(this);
 }
  
//################ actionPerformed ################
public void actionPerformed(ActionEvent event)
 {
  if(event.getSource()==menuitem1) label.setText("Eligio el Elemento #1");
  if(event.getSource()==menuitem2) label.setText("Eligio el Elemento #2");
  if(event.getSource()==menuitem3) label.setText("Eligio el Elemento #3");
  if(event.getSource()==menuitem4) label.setText("Eligio el Elemento #4");
 }

//################ mousePressed ################
public void mousePressed(MouseEvent event)
 {
  if(event.getModifiers()!=0) popup.show(this,event.getX(),event.getY());
 }

//################ Mouse EMPTY Events ################
 public void mouseExited(MouseEvent event){}
 public void mouseEntered(MouseEvent event){}
 public void mouseReleased(MouseEvent event){}
 public void mouseClicked(MouseEvent event){}


}

