//############### import ##############
import java.applet.Applet;
import java.awt.*;

//############### HTML antiguo01 ##############
/*
 <applet
  codebase=temp
  code=antiguo01.class
  width=200
  height=200
 ></applet
*/

//############### antiguo01 ##############
public class antiguo01 extends Applet 
{
 TextField miTexto;
 Button miBoton;

  public void init()
  {
   miTexto = new TextField(20);
   add(miTexto);
   miBoton = new Button("Pulseme!");
   add(miBoton);
  }

  public boolean action(Event e, Object o)
  {
   String caption = (String)o;
   String mensaje = new String("Hola desde 'antiguo01'!");
 
   if(e.target instanceof Button)
    if(caption == "Pulseme!")
     miTexto.setText(mensaje);

   return true;
  }
}

//############### ##############


