//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="ab_multiplicadora.class"
  alt="Probando Applet"
  name="ab_multiplicadora"
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

//########### ab_multiplicadora ###############

public class
   ab_multiplicadora
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######
 TextField text1,text2,text3;
 Label multiplylabel;
 Button b1;

 public void init()
 {
//  setLayout(new FlowLayout(FlowLayout.LEFT));
  setLayout(new GridLayout(5,1));

//####### Text #######

  text1 = new TextField(2);
  add(text1);

  multiplylabel = new Label("*");  
  add(multiplylabel);

  text2 = new TextField(2);
  add(text2);

  b1 = new Button("=");
  add(b1);
  b1.addActionListener(this);

  text3 = new TextField(2);
  add(text3);

 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   if (event.getSource() == b1)
   {
    int product = Integer.parseInt(text1.getText()) 
                * Integer.parseInt(text2.getText()) ;
    text3.setText(String.valueOf(product));
   }
 }

//############ paint ##############

 public void paint(Graphics g)
 {
  g.drawString(getParameter("parametro1"),20,190);
  //System.out.println("Hola desde Java #2!");
 }


}

