//########### import ###############

import java.awt.*;
import java.applet.Applet;
import java.awt.image.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a10_realzar.class"
  alt="Probando Applet"
  name="a10_realzar"
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

//########### a10_realzar ###############

public class
   a10_realzar
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
  
  // Es prescindible cual es 'rojo' o 'azul'
  for (int x=2; x<166; x++)
  for (int y=2; y<167; y++)
  {
   int red = ( ( pixels[(x+1)*167 + y+1] & 0xFF ) -
               ( pixels[x*167 + y] & 0xFF ) ) + 128;

   int green = ( (( pixels[(x+1)*167 + y+1] & 0xFF00 ) / 0x100 ) -
                 (( pixels[x*167 + y] & 0xFF00) / 0x100) % 0x100 ) 
				  + 128;

   int blue = ( (( pixels[(x+1)*167 + y+1] & 0xFF0000 ) / 0x10000 ) -
                (( pixels[x*167 + y] & 0xFF0000) / 0x10000) % 0x10000 ) 
				  + 128;
				  
   int avg = (red+green+blue)/3;

   pixels[x * 167 + y] = (0xff000000 | avg << 16 | avg << 8 | avg );
  }
  
  /*
  for (int ii = 0; ii < 167*168; ii++)
  {
   int p = pixels[ii];
   int red = 0xff & (p >> 16);
   int green = 0xff & (p >> 8);
   int blue = 0xff & p;
   pixels[ii] = (0xff000000 | red << 16 | green << 8 | blue );
  }
  */
  
  image2 = createImage(new MemoryImageSource(167,168,pixels,0,167));
 }
 
//############## paint  ##############

 public void paint(Graphics g)
 {
  g.drawImage(image, 0,0,this);
  g.drawImage(image2, 200,0,this);
 }

}