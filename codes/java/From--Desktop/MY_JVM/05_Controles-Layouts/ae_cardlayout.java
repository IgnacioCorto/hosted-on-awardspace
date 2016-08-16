//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="ae_cardlayout.class"
  alt="Probando Applet"
  name="ae_cardlayout"
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

//########### cardpanel ###############

class cardPanel extends Panel
{
 Button button1;
 Label label1;

 cardPanel(ae_cardlayout applet, String cardnumber)
 {
  button1 = new Button("Tarjeta Siguiente");
  button1.addActionListener(applet);
  add(button1);
  label1 = new Label("Esta es la tarjeta #"+cardnumber);
  add(label1);
 }
}

//########### ae_cardlayout ###############

public class
   ae_cardlayout
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######

 int index = 1;
 CardLayout cardlayout;
 cardPanel panel1, panel2, panel3;

 public void init()
 {
cardlayout = new CardLayout();
setLayout(cardlayout);

panel1 = new cardPanel(this, "uno");
panel2 = new cardPanel(this, "dos");
panel3 = new cardPanel(this, "tres");

add("primero", panel1);
add("segundo", panel2);
add("tercero", panel3);

cardlayout.show(this, "primero");

 }


//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
  switch(++index)
  {
   case 1:
    cardlayout.show(this,"primero");
    break;
   case 2:
    cardlayout.show(this,"segundo");
    break;
   case 3:
    cardlayout.show(this,"tercero");
    break;
  }
 if(index==3) index = 0;
 repaint();

 }

}

