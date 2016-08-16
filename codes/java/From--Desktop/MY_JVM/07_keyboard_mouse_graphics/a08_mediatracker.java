//########### import ###############

import java.awt.*;
import java.applet.Applet;
/*import java.awt.event.*;*/

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a08_mediatracker.class"
  alt="Probando Applet"
  name="a08_mediatracker"
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

//########### a08_mediatracker ###############

public class
   a08_mediatracker
extends
   Applet

{ //####### Declarations #######

 Image image;
 
//############## init ##############

 public void init()
 {
  MediaTracker tracker = new MediaTracker(this);
  image = getImage(getDocumentBase(),"temp/image.jpg");
  tracker.addImage(image,0);
  try  { tracker.waitForAll(); }
  catch ( InterruptedException ex ) { }
 }
 
//############## paint  ##############

 public void paint(Graphics g)
 {
  g.drawImage(image, 0,0,this);
 }

}