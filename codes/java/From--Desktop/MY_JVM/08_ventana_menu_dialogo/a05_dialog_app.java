import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/*
<applet 
  codebase="temp"
  code="a05_dialog_app.class"
  alt="Probando Applet"
  name="a00_mouselistener"
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

public class a05_dialog_app
{
 public static void main(String args[])
 {
  dialogframe f = new dialogframe("Dialogos");
	f.setSize(200,200);
	f.addWindowListener
	(
	 new WindowAdapter()
	 {
	  public void windowClosing(WindowEvent e)
		{
		 System.exit(0);
		}
	 }
	);
	f.setVisible(true);
 }
}

//############## dialogframe ##################
class dialogframe extends Frame implements ActionListener
{
 Menu Menu1;
 MenuBar Menubar1;
 Label label;
 MenuItem menuitem1;
 okcanceldialog dialog;
 
 dialogframe(String title)
 {
  super(title);
	label=new Label("Hola desde a05_dialog_app");
	setLayout(new GridLayout(1,1));
	add(label);
	Menubar1 = new MenuBar();
	
	Menu1 = new Menu("Archivo");
	
	menuitem1 = new MenuItem("Cuadro de dialogo...");
	Menu1.add(menuitem1);
	menuitem1.addActionListener(this);
	
	Menubar1.add(Menu1);
	
	setMenuBar(Menubar1);
	dialog = new okcanceldialog(this,"Dialogo",false);
 }
 
 //###############  dialogframe.actionPerformed ##########
  public void actionPerformed(ActionEvent event)
 {
  if(event.getSource()== menuitem1)
	{
	 dialog.setVisible(true);
	 label.setText(dialog.data);
	}
 }
}

//############## okcanceldialog class ##################
class okcanceldialog extends Dialog implements ActionListener
{
 Button ok, cancel;
 TextField text;
 String data;
 
 okcanceldialog(Frame hostFrame, String title, boolean dModal)
 {
  super(hostFrame,title,dModal);
	setSize(300,100);
	setLayout(new FlowLayout());
	ok = new Button("Aceptar");
	add(ok);
	ok.addActionListener((ActionListener)this);
	cancel = new Button("Cancelar");
	add(cancel);
	cancel.addActionListener(this);
	text = new TextField(30);
	add(text);
	data = new String("");
 }
 
 //############## okcanceldialog.actionPerformed #################
 public void actionPerformed(ActionEvent event)
 {
  if(event.getSource()==ok) data=text.getText();
	else data="";
	setVisible(false);
 }
}
