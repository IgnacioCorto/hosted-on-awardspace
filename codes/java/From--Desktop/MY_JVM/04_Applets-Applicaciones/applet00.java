/*
<applet 
  codebase="temp"
  code="applet00.class"
  alt="Probando Applet"
  name="applet00"
  width="200"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### applet00 ###############

public class applet00 extends Applet  implements ActionListener
{

 TextField texto1;
 Button boton1;

 public void init()
 {
  setBackground(Color.red);
  texto1 = new TextField(20);
  boton1 = new Button("Haga click aqui!");
  add(texto1);
  add(boton1);
  texto1.setText("Hola desde Mi Casa #2!!");
  boton1.addActionListener(this);
 }

 public void paint(Graphics g)
 {
  g.drawString(getParameter("parametro1"),20,100);
  //System.out.println("Hola desde Java #2!");
 }


 public void actionPerformed(ActionEvent event)
 {
  String msg = new String("Hola desde Java");
  if(event.getSource() == boton1)
  {
   texto1.setText(msg);
  }
 }


 public void start() {}
 public void stop() {}
 public void destroy() {}
 public void update() {}


}

