//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a02_font.class"
  alt="Probando Applet"
  name="a02_font"
  width="300"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/


//########### a02_font ###############

public class
   a02_font
extends
   Applet
implements
   ActionListener, KeyListener
{ //####### Declarations #######
 String text = "";
 Button boldbutton, italicbutton, largebutton;
 boolean bold = false;
 boolean italic = false;
 boolean large = false;

//############## init ##############
 public void init()
 {
  boldbutton = new Button("Fuente en negrita");
  italicbutton = new Button("Fuente en cursiva");
  largebutton = new Button("Fuente grande");
  
  boldbutton.addActionListener(this);
  italicbutton.addActionListener(this);
  largebutton.addActionListener(this);
  
  add(boldbutton);
  add(italicbutton);
  add(largebutton);

  addKeyListener(this);
  requestFocus();
 }

//############## paint  ##############
 public void paint(Graphics g)
 {
  String fontname = "Courier";
  int type = Font.PLAIN;
  int size = 36;
  Font font;
  FontMetrics fm;
  
  if(bold) type = type | Font.BOLD;
  if(italic) type = type | Font.ITALIC;
  if(large) size = 72;

  font = new Font(fontname, type, size);
  g.setFont(font);
  fm = getFontMetrics(font);
  
  int xloc = (getSize().width - fm.stringWidth(text)) / 2;
  int yloc = (getSize().height - fm.getHeight()) / 2;
    
  g.drawString(text,xloc,yloc);
 }
//############## actionPerformed ##############
 public void actionPerformed(ActionEvent event)
 {
  if (event.getSource() == boldbutton) bold = !bold;
  if (event.getSource() == italicbutton) italic = !italic;
  if (event.getSource() == largebutton) large = !large;
  requestFocus();
  repaint();
 }

//############## keyTyped ##############
 public void keyTyped(KeyEvent e)
 {
  text += e.getKeyChar();
  repaint();
 }

 public void keyPressed(KeyEvent e) {}
 public void keyReleased(KeyEvent e) {}
}

