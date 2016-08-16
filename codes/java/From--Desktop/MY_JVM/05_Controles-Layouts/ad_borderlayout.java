//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="ad_borderlayout.class"
  alt="Probando Applet"
  name="ad_borderlayout"
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

//########### buttonpanel ###############

class textPanel extends Panel
{
 TextField Text1;

 textPanel()
 {
  Text1 = new TextField(20);
  add(Text1);
 }
}

//########### ad_borderlayout ###############

public class
   ad_borderlayout
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######

 Button button1, button2, button3, button4;
 textPanel Panel1;

 public void init()
 {
// setLayout(new FlowLayout(FlowLayout.LEFT));
// setLayout(new GridLayout(2,3));
setLayout(new BorderLayout());

button1 = new Button("1");
button2 = new Button("2");
button3 = new Button("3");
button4 = new Button("4");

add("West", button2);
add("East", button4);
add("North", button1);
add("South", button3);

button1.addActionListener(this);
button2.addActionListener(this);
button3.addActionListener(this);
button4.addActionListener(this);

Panel1 = new textPanel();
add("Center",Panel1);
Panel1.Text1.setLocation(0,0);

 }


//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
  Panel1.Text1.setText("Boton Activado: " + ( (Button) 
   event.getSource() ).getLabel() + "!!");
 }

}

