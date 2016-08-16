//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="aa_awt_controles.class"
  alt="Probando Applet"
  name="aa_awt_controles"
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

//########### aa_awt_controles ###############

public class
   aa_awt_controles
extends
   Applet
implements
   ActionListener, ItemListener
{

//####### Declarations #######
 TextField text1,text2;
 Label label1, label2, label3;
 Button button1;
 Checkbox checkbox1, checkbox2, checkbox3, checkbox4,
          radio1, radio2, radio3, radio4; 
 CheckboxGroup radios;



 public void init()
 {
  setLayout(new FlowLayout(FlowLayout.LEFT));

//####### Text #######

  text1 = new TextField(20);
  add(text1);
  text2 = new TextField(20);
  add(text2);

  text1.setEchoChar('*');
  text1.addActionListener(this);

//####### Label #######

  label1 = new Label("Ely #1", Label.LEFT);
  add(label1);
  label2 = new Label("Ely #2", Label.CENTER);
  add(label2);
  label3 = new Label("Ely #3", Label.RIGHT);
  add(label3);

//####### Buton #######

  button1 = new Button("Haga click aqui");
  add(button1);
  button1.setActionCommand("Boton Apretado");
  button1.addActionListener(this);

//####### Checkbox #######

  checkbox1 = new Checkbox("1");
   add(checkbox1);
   checkbox1.addItemListener(this); 
  checkbox2 = new Checkbox("2");
   add(checkbox2);
   checkbox2.addItemListener(this); 
  checkbox3 = new Checkbox("3");
   add(checkbox3);
   checkbox3.addItemListener(this); 
  checkbox4 = new Checkbox("4");
   add(checkbox4);
   checkbox4.addItemListener(this); 

//####### CheckboxGroup #######

  radios = new CheckboxGroup();

  radio1 = new Checkbox("1", false, radios);
  add(radio1);
  radio1.addItemListener(this);

  radio2 = new Checkbox("2", false, radios);
  add(radio2);
  radio2.addItemListener(this);

  radio3 = new Checkbox("3", false, radios);
  add(radio3);
  radio3.addItemListener(this);

  radio4 = new Checkbox("4", false, radios);
  add(radio4);
  radio4.addItemListener(this);

 }

//############ actionPerformed ##############

 public void actionPerformed(ActionEvent event)
 {
   if (event.getSource() == text1)
     text2.setText(text1.getText());
  // if (event.getSource() == button1)
   if (event.getActionCommand().equals("Boton Apretado"))
     text1.setText("Presionaste el boton");
 }

//############ itemStateChanged ##############

 public void itemStateChanged(ItemEvent e)
 {
/*
  if(e.getItemSelectable() == checkbox1)
    text2.setText("Checkbox #1 pulsado");
  if(e.getItemSelectable() == checkbox2)
    text2.setText("Checkbox #2 pulsado");
  if(e.getItemSelectable() == checkbox3)
    text2.setText("Checkbox #3 pulsado");
  if(e.getItemSelectable() == checkbox4)
    text2.setText("Checkbox #4 pulsado");
*/

//  text2.setText("Casilla Activada ==> " + ( (Checkbox) 
//   e.getItemSelectable() ).getLabel() + " Pulsada!!");

  text2.setText("Boton Activado: " + ( (Checkbox) 
   e.getItemSelectable() ).getLabel() + "!!");

 }

//############ paint ##############

 public void paint(Graphics g)
 {
  g.drawString(getParameter("parametro1"),20,190);
  //System.out.println("Hola desde Java #2!");
 }


}

