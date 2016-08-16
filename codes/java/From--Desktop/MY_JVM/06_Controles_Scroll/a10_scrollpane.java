//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a10_scrollpane.class"
  alt="Probando Applet"
  name="a10_scrollpane"
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

//########### TextPanel ###############

class TextPanel extends Panel
{

 public Dimension getPreferredSize()
 {
  return new Dimension(400,400);
 }

 public void paint(Graphics g)
 {
  g.drawString("\r\r\r\rEsta es una cadena de texto larga que parece"+
  "continuar y continuar y continuar y continuar y continuar y continuar y continuar"+ 
  "y continuar y continuar y continuar y continuar y continuar y continuar y continuar"+ 
  "y continuar y continuar y continuar y continuar y continuar y continuar y continuar"+
  "y continuar y continuar y continuar y continuar y continuar y continuar y continuar",
   10, 10);
 }
}

//########### a10_scrollpane ###############

public class
   a10_scrollpane
extends
   Applet
implements
   AdjustmentListener
{

//####### Declarations #######
 ScrollPane scrollpane1;
 TextPanel t1;
 TextField text1;

 public void init()
 {
  // text1 = new TextField("Hola desde ScrollPane");
  // scrollpane1.add(text1);
  t1 = new TextPanel();
  scrollpane1 = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
  scrollpane1.add(t1);
  /*===>*/ add(scrollpane1);
 }

 public void adjustmentValueChanged(AdjustmentEvent event)
 {
 }

}

