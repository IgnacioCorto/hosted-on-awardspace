//############### import ##############
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


//############### con_comandos ##############
public class con_caption extends Applet implements ActionListener
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
   String mensaje = new String("Hola desde 'con_caption!");
   String caption = event.getActionCommand();
 
   if(caption.equals("Haga click aqui!")) miTexto.setText(mensaje);
  }
}

//############### ##############


//############### CODIGO HTML ##############
/*
 <applet
  codebase=temp
  code=con_caption.class
  width=200
  height=200
 ></applet
*/