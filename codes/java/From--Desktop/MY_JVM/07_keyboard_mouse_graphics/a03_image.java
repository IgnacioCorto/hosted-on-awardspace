//########### import ###############

import java.awt.*;
import java.applet.Applet;
/*import java.awt.event.*;*/

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a03_image.class"
  alt="Probando Applet"
  name="a03_image"
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

//########### a03_image ###############

public class
   a03_image
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
 
}