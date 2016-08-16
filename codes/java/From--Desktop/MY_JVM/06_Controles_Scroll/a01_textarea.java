//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a01_textarea.class"
  alt="Probando Applet"
  name="a01_textarea"
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

//########### a01_textarea ###############

public class
   a01_textarea
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
  textarea1 = new TextArea("",10,20,TextArea.SCROLLBARS_BOTH);
  add(textarea1);
  button1 = new Button("Haga click aqui!");
  add(button1);
  button1.addActionListener(this);
 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
  String msg = "Hola desde a01_textarea";
   if (event.getSource() == button1)
   {
    textarea1.insert(msg,0);
   }
 }

}

