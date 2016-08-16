//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a07_scrollbar.class"
  alt="Probando Applet"
  name="a07_scrollbar"
  width="400"
  height="100"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### a07_scrollbar ###############

public class
   a07_scrollbar
extends
   Applet
implements
   AdjustmentListener
{

//####### Declarations #######
 TextField text1;
 Scrollbar scroll1,scroll2;

 public void init()
 {
  scroll1 = new Scrollbar(Scrollbar.HORIZONTAL, 1,20,1,200);
  add(scroll1);
  scroll1.addAdjustmentListener(this);

  text1 = new TextField(20);
  add(text1);
  
  scroll2 = new Scrollbar(Scrollbar.VERTICAL, 1,20,1,200);
  add(scroll2);
  scroll2.addAdjustmentListener(this);

 }

//############ adjustmentValueChanged ##############

 public void adjustmentValueChanged(AdjustmentEvent event)
 {
   if (event.getAdjustable() == scroll1 ||
       event.getAdjustable() == scroll2)
     text1.setText("Horz: " + scroll1.getValue() +
                 "; Vert: " + scroll2.getValue() );
 }

}

