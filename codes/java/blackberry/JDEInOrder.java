/*
look at api: name, description, return, modifiers
skeleton:
BasicEditField: it has its own menu?? No: disable debug errors!
	.keyChar(key,status,time)

UiApplication.getApplication()
	.pushScreen(new My_MainScreen());
	.popScreen(field.getScreen());
	.getScreenCount();
	
	
 */

package com.awardspace.luis3ignacio.learning.inorder;

import javax.microedition.media.*;
import javax.microedition.media.Manager;
import javax.microedition.media.control.*;

import net.rim.device.api.system.KeyListener;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

class HomeApplication extends net.rim.device.api.ui.UiApplication {
	public static void main(String[] args) {
		HomeApplication instance = new HomeApplication();
		instance.enterEventDispatcher();
	}

	public HomeApplication() {
		pushScreen(new NewScreen("1) 1st: "));
		// pushScreen(new NewScreen("2nd: "));
	}
}

/**
 * You can put next code in another file. Don't forget those 'import' lines
 */

class NewScreen extends MainScreen {
	private static int count = 0;
	private static String hola = "hola mundo";

	public NewScreen(String title) {
		super();
		count++;
		LabelField applicationTitle = new LabelField(title + " #" + count);
		setTitle(applicationTitle);
		RichTextField richWorld = new RichTextField("Hola Mundo #" + count
				+ "!!");
		BasicEditField editWorld = new BasicEditField("Escribe" + count + ": ",
				null) {
			protected boolean keyChar(char key, int status, int time) {
				boolean value = super.keyChar(key, status, time);
				// Dialog.alert(""+key);
				// Dialog.alert(getText());
				try {

					new Thread() {
						{
							start();

						}

						public void run() {
							try {
								Manager.playTone(ToneControl.C4, 500, 200);
							} catch (MediaException e) {
							}

						}
					};
				} catch (Exception e) {
				}
				return value;
			}
		};

		add(richWorld);
		add(editWorld);

		Graphics gd = getGraphics();
		gd.setColor(Color.BLACK);
		gd.drawRect(300, 220, 20, 20);
		paint(gd);

		// if (count <= 5)
		// UiApplication.getUiApplication().pushScreen(
		// new NewScreen(title + " +"));

		add(new ButtonField("Agregar Pantalla") {
			{// AN USEFUL INSTANCE INITIALIZER!!!
				setChangeListener(new FieldChangeListener() {
					public void fieldChanged(Field field, int context) {
						UiApplication.getUiApplication().pushScreen(
								new NewScreen("Nueva #"));
					}
				});
			}
		});

		add(new ButtonField("Cerrar Pantalla") {
			{
				setChangeListener(new FieldChangeListener() {
					public void fieldChanged(Field field, int context) {
						UiApplication.getUiApplication().popScreen(getScreen());
						Dialog.alert("Screens: "
								+ UiApplication.getUiApplication()
										.getScreenCount());
						if (UiApplication.getUiApplication().getScreenCount() <= 0) {
							System.exit(0);
						}
					}
				});
			}
		});

		addKeyListener(new KeyListener() {

			public boolean keyChar(char key, int status, int time) {
				// TODO Auto-generated method stub
				Dialog.alert("" + key);
				return false;
			}

			public boolean keyDown(int keycode, int time) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean keyRepeat(int keycode, int time) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean keyStatus(int keycode, int time) {
				// TODO Auto-generated method stub
				return false;
			}

			public boolean keyUp(int keycode, int time) {
				// TODO Auto-generated method stub
				return false;
			}

		});

	}

	protected void makeMenu(Menu menu, int instance) {
		menu.add(new MenuItem("Add Screen", 110, 10) {
			public void run() {
				UiApplication.getUiApplication().pushScreen(
						new NewScreen("Nueva #"));
			}
		});
	}

}
