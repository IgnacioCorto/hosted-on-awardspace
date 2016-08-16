//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a06_choice.class"
  alt="Probando Applet"
  name="a06_choice"
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

//########### a06_choice ###############

public class
   a06_choice
extends
   Applet
implements
   ItemListener
{

//####### Declarations #######
 TextField text1;
 Choice choice1;

 public void init()
 {
  text1 = new TextField(40);
  add(text1);
  
  choice1 = new Choice();
    choice1.add("Elemento 0");  choice1.add("Elemento 1");
    choice1.add("Elemento 2");  choice1.add("Elemento 3");
    choice1.add("Elemento 4");  choice1.add("Elemento 5");
    choice1.add("Elemento 6");  choice1.add("Elemento 7");
    choice1.add("Elemento 8");  choice1.add("Elemento 9");
  add(choice1);
  choice1.addItemListener(this);
 }

//############ itemStateChanged ##############

 public void itemStateChanged(ItemEvent event)
 {
   if (event.getItemSelectable() == choice1)
     text1.setText("Selecion: " + 
	( (Choice)event.getItemSelectable() ).getSelectedItem() );
 }

}

