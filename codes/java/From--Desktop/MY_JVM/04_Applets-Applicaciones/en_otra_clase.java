//###### import ######
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


//###### html ######
/*
	<applet
	  codebase=temp
	  code=en_otra_clase.class
	  width=200
	  height=200>
	</applet>
*/

//###### en_otra_clase ######
public class en_otra_clase extends Applet
{
 public TextField texto1;
 public Button boton1;

 public void init()
 {
  texto1 = new TextField(20);
  add(texto1);
  boton1 = new Button("Haga clic aqui!!");
  add(boton1);
  a objeto = new a(this);
  boton1.addActionListener(objeto);
 }
}

//###### a ######
class a implements ActionListener
{
 en_otra_clase c;
 
 a(en_otra_clase appletobject)
 {
  c = appletobject;
 }

 public void actionPerformed(ActionEvent event)
 {
  String mensaje = new String("Hola desde 'en_otra_clase'!!");
  if (event.getSource() == c.boton1)
   c.texto1.setText(mensaje);
 }
}