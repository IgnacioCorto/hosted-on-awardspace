//############### import ##############
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


//############### en_misma_clase  ##############
public class en_misma_clase  extends Applet implements ActionListener
{
 TextField miTexto;
 Button miBoton;

  public void init()
  {
   miTexto = new TextField(20);
   add(miTexto);
   miBoton = new Button("Haga click aqui!");
   add(miBoton);
   miBoton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event)
  {
   String mensaje = new String("Hola desde Java!");
   if(event.getSource() == miBoton) miTexto.setText(mensaje);
  }
}

//############### ##############


//############### CODIGO HTML ##############
/*
 <applet
  codebase=temp
  code=en_misma_clase .class
  width=200
  height=200
 ></applet
*/