//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="af_gridbaglayout.class"
  alt="Probando Applet"
  name="af_gridbaglayout"
  width="400"
  height="80"
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

 cardPanel(af_gridbaglayout applet, String cardnumber)
 {
  button1 = new Button("Tarjeta Siguiente");
  button1.addActionListener(applet);
  add(button1);
  label1 = new Label("Esta es la tarjeta #"+cardnumber);
  add(label1);
 }
}

//########### af_gridbaglayout ###############

public class
   af_gridbaglayout
extends
   Applet
implements
   ActionListener
{

//####### Declarations #######

 Button boton1, boton2, boton3;
 TextField texto1;

 public void init()
 {
  GridBagLayout saco = new GridBagLayout();
  GridBagConstraints limites = new GridBagConstraints();
  setLayout(saco);
  limites.weighty = 1;
  limites.fill = GridBagConstraints.BOTH;

  limites.weightx =1;
  boton1 = new Button("Boton 1");
  saco.setConstraints(boton1, limites);
  boton1.setActionCommand("Boton 1");
  add(boton1);
  boton1.addActionListener(this);  

  limites.weightx =2;
  boton2 = new Button("Boton 2");
  saco.setConstraints(boton2, limites);
  boton2.setActionCommand("Boton 2");
  add(boton2);
  boton2.addActionListener(this);  

  limites.weightx =1;
  boton3 = new Button("Boton 3");
  limites.gridwidth=GridBagConstraints.REMAINDER;
  saco.setConstraints(boton3, limites);
  boton3.setActionCommand("Boton 3");
  add(boton3);
  boton3.addActionListener(this);  

  texto1 = new TextField();
  limites.gridwidth=GridBagConstraints.REMAINDER;
  saco.setConstraints(texto1, limites);
  add(texto1);
 }


//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
    texto1.setText("Boton Activado: " + ( (Button) 
   event.getSource()).getActionCommand() + "!!");

 }

}

