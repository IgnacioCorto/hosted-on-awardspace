import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


/*
<applet 
  codebase="temp"
  code="a03_menu.class"
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

public class a03_menu extends Applet implements ActionListener
{
 Button b1;
 frame menuWindow;

//################ init ################
 public void init()
 {
  b1 = new Button("Visualizar el menu la ventana");
	add(b1);
	b1.addActionListener(this);
	
	menuWindow = new frame("Menus");
	menuWindow.setSize(200,200);
 }
  
//################ actionPerformed ################
 public void actionPerformed (ActionEvent event)
 {
  if (event.getSource()==b1) menuWindow.setVisible(true);
 }
}

//################ ventana: MENU frame ##############
class frame extends Frame implements ActionListener, ItemListener
{
 Menu menu,submenu;
 MenuBar menubar;
 MenuItem menuitem1, menuitem2, menuitem3;
 CheckboxMenuItem subitem1;
 
 Label label;

 frame(String title)
 {
  super(title);
	label = new Label("¡Hola desde Java! Esta es un MENU frame.");
	setLayout(new GridLayout(1,1));
	add(label);
	
	menubar = new MenuBar();
	menu = new Menu("Archivo");
	
	menuitem1 = new MenuItem("Elemento 1");
	menu.add(menuitem1);
	menuitem1.addActionListener(this);

  menu.addSeparator();

	menuitem2 = new MenuItem("Elemento 2");
	menu.add(menuitem2);
	menuitem2.addActionListener(this);

	menuitem3 = new MenuItem("Elemento 3");
	menu.add(menuitem3);
	menuitem3.addActionListener(this);
	
  submenu = new Menu("Sub Menu");
	subitem1 = new CheckboxMenuItem("Verificacion");
	subitem1.addItemListener(this);
	submenu.add(subitem1);
	menu.add(submenu);


	menubar.add(menu);
	setMenuBar(menubar);
	
	addWindowListener
	( 
	 new WindowAdapter() 
	 {
	  public void windowClosing(WindowEvent e)
		{
		 setVisible(false);
		}
	 }
	);
	
 }
 
 //############# actionPerformed ##############
 public void actionPerformed(ActionEvent event)
 {
  if(event.getSource()==menuitem1) label.setText("Eligio el Elemento #1");
  if(event.getSource()==menuitem2) label.setText("Eligio el Elemento #2");
  if(event.getSource()==menuitem3)
	{
	 label.setText("Eligio el Elemento #3");
	 menuitem3.setEnabled(false);
	}
 }


 //############# itemStateChanged ##############
 public void itemStateChanged(ItemEvent event)
 {
  if(event.getSource()==subitem1)
	 {
	 if(((CheckboxMenuItem)event.getItemSelectable()).getState())
	  label.setText("subitem1 *SI* esta seleccionado");
	 else 
 	  label.setText("subitem1 *NO* esta seleccionado");
	 }
 }

}

