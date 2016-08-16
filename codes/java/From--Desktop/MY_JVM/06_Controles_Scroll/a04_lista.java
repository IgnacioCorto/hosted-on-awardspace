//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a04_lista.class"
  alt="Probando Applet"
  name="a04_lista"
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

//########### a04_lista ###############

public class
   a04_lista
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######
 List list1;
 TextField text1;

 public void init()
 {
  text1 = new TextField(20);
  add(text1);
  
  list1 = new List(4);
    list1.add("Elemento 0");  list1.add("Elemento 1");
    list1.add("Elemento 2");  list1.add("Elemento 3");
    list1.add("Elemento 4");  list1.add("Elemento 5");
    list1.add("Elemento 6");  list1.add("Elemento 7");
    list1.add("Elemento 8");  list1.add("Elemento 9");
  add(list1);

  list1.addActionListener(this);
 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   if (event.getSource() == list1)
   {
    text1.setText( ( (List) event.getSource() ).getSelectedItem() );
   }
 }

}

