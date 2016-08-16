//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a08_mover.class"
  alt="Probando Applet"
  name="a08_mover"
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

//########### a08_mover ###############

public class
   a08_mover
extends
   Applet
implements
   AdjustmentListener
{

//####### Declarations #######
 Scrollbar scroll1,scroll2;
 int x = 0;

 public void init()
 {
  scroll1 = new Scrollbar(Scrollbar.HORIZONTAL, 1,20,1,100);
  add(scroll1);
  scroll1.addAdjustmentListener(this);
 }

 public void paint(Graphics myGraphs)
 {
  myGraphs.drawString("Hola desde java",x,60);
 }


//############ adjustmentValueChanged ##############

 public void adjustmentValueChanged(AdjustmentEvent event)
 {
  if (event.getAdjustable() == scroll1)
  {
   x = (int) (   getSize().width
               * (float) scroll1.getValue()
               / 100 );
   repaint();
  }

 }

}

