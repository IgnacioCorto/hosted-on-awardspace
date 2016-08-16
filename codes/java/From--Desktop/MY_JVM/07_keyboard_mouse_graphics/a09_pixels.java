//########### import ###############

import java.awt.*;
import java.applet.Applet;
import java.awt.image.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a09_pixels.class"
  alt="Probando Applet"
  name="a09_pixels"
  width="600"
  height="150"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### a09_pixels ###############

public class
   a09_pixels
extends
   Applet

{ //####### Declarations #######

 Image image, image2;
 
//############## init ##############

 public void init()
 {
  image = getImage(getDocumentBase(),"temp/image.jpg");
  int pixels[] = new int[167*168];
  
  PixelGrabber pg = new PixelGrabber(image, 0, 0, 167,168, 
  									 pixels, 0, 167);
  try { pg.grabPixels(); }
  catch (InterruptedException e) {}
  
  // Este 'for' se usa para Manipular PIXELES
  for (int ii = 0; ii < 167*168; ii++)
  {
   int p = pixels[ii];
   int red = 0xff & (p >> 16);
   int green = 0xff & (p >> 8);
   int blue = 0xff & p;

   // NORMAL   
   pixels[ii] = (0xff000000 | red << 16 | green << 8 | blue );

   /*   // MAS CLARO
   int force = 60;
   red = red + force > 255 ? 255 : red + force;
   green = green + force > 255 ? 255 : green + force;
   blue = blue + force > 255 ? 255 : blue + force;
   pixels[ii] = (0xff000000 | red << 16 | green << 8 | blue );
   */
   
   /*  // BLANCO Y NEGRO
   int avg = (int) ( (red + green + blue)/3 );
   pixels[ii] = (0xff000000 | avg << 16 | avg << 8 | avg );
   */

// HAPPY=BLIND, Haz lo que te gusta y olvidate del mundo
// Doubt=Fear, 

  }
  
  image2 = createImage(new MemoryImageSource(167,168,pixels,0,167));
 }
 
//############## paint  ##############

 public void paint(Graphics g)
 {
  g.drawImage(image, 0,0,this);
  g.drawImage(image2, 200,0,this);
 }

}