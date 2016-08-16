//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a03_buscar.class"
  alt="Probando Applet"
  name="a03_buscar"
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

//########### a03_buscar ###############

public class
   a03_buscar
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######
 TextArea textarea1;
 Button button1;

 public void init()
 {
  textarea1 = new TextArea("Ya es la hora",10,20,
				TextArea.SCROLLBARS_BOTH);
  add(textarea1);
  button1 = new Button("Buscar \"hora\"");
  add(button1);
  button1.addActionListener(this);
 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   if (event.getSource() == button1)
   {
    String s = textarea1.getText();
    String s2 = new String("hora");
    int location = s.indexOf(s2);
//    textarea1.select( location, location+s2.length() );
    textarea1.select(0,4);
    System.out.println("Se ejecuto!");
   }
 }

}

