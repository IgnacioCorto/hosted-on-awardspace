//########### import ###############

import java.awt.*;
import java.applet.Applet;
/*import java.awt.event.*;*/

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a07_imageupdate.class"
  alt="Probando Applet"
  name="a07_imageupdate"
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

//########### a07_imageupdate ###############

public class
   a07_imageupdate
extends
   Applet

{ //####### Declarations #######

 Image image;
 
//############## init ##############

 public void init()
 {
  image = getImage(getDocumentBase(),"temp/image.jpg");
 }
 
//############## paint  ##############

 public void paint(Graphics g)
 {
  g.drawImage(image, 0,0,this);
 }

 public boolean imageUpdate(Image img, int flags,
 						    int x, int y,
							int w, int h)
 {
  if ((flags & ALLBITS) != 0)
   {
    repaint(x,y,w,h);
   }
   return (flags & ALLBITS) == 0;
 }
							
}