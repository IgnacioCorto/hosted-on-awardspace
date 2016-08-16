//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a05_multiple.class"
  alt="Probando Applet"
  name="a05_multiple"
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

//########### a05_multiple ###############

public class
   a05_multiple
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######
 List list1;
 TextField text1;
 Button button1;
 String selections[];

 public void init()
 {
  text1 = new TextField(40);
  add(text1);
  
  list1 = new List(4, true);
    list1.add("Elemento 0");  list1.add("Elemento 1");
    list1.add("Elemento 2");  list1.add("Elemento 3");
    list1.add("Elemento 4");  list1.add("Elemento 5");
    list1.add("Elemento 6");  list1.add("Elemento 7");
    list1.add("Elemento 8");  list1.add("Elemento 9");
  add(list1);

  button1 = new Button("Mostrar las selecciones");
  button1.addActionListener(this);
  add(button1);
 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   String outString = new String("Seleccion:");
   if (event.getSource() == button1)
   {
    selections = list1.getSelectedItems();
    for(int loopIndex = 0; loopIndex < selections.length; loopIndex++)
    {
     outString += " "+selections[loopIndex];
    }
    text1.setText(outString);
   }
 }

}

