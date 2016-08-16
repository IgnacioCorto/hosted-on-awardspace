// Importar java.applet.Applet
import java.applet.Applet;

// Importamos java.awt.*
import java.awt.*;

// extender Applet
public class appleted extends Applet
{
  
  // sobreescribimos el metodo paint(Graphics g)
  public void paint(Graphics g)
  {
    // Dibujamos una cadena en la pantalla
    g.drawString("Hola desde Java",60,100);

  }

}