//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a02_reemplazar.class"
  alt="Probando Applet"
  name="a02_reemplazar"
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

//########### a02_reemplazar ###############

public class
   a02_reemplazar
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
  button1 = new Button("Cambiar el texto seleccionado");
  add(button1);
  button1.addActionListener(this);
 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   if (event.getSource() == button1)
   {
    textarea1.replaceRange("Hola desde a02_reemplazar",
				textarea1.getSelectionStart(),
				textarea1.getSelectionEnd() );
   }
 }

}

