package com.awardspace.luis3ignacio.learning.extvid00;

import java.io.InputStream;

import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VideoControl;
import javax.microedition.media.control.VolumeControl;

import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;

public class ExternalVideo extends UiApplication {
	public static void main(String[] args) {
		ExternalVideo instance = new ExternalVideo();
		instance.enterEventDispatcher();
	}

	public ExternalVideo() {
		pushScreen(new VideoPlayer());
	}
}

/**
 * You can put next code in another file. Don't forget those 'import' lines
 */

class VideoPlayer extends MainScreen {

	public Player player;
	public VideoControl vc;
	InputStream is;

	public VideoPlayer() {
		setTitle(new LabelField("#7 Video Example"));

		try {
			//is = getClass().getResourceAsStream("/cat-speak.3gp");
			//player = Manager.createPlayer(is, "video/3gp");
			player = Manager.createPlayer("file:///SDCard/cat-speak.3gp");
			player.realize();
			player.prefetch();
			vc = (VideoControl) player.getControl("VideoControl");

//			vc.initDisplayMode(VideoControl.USE_DIRECT_VIDEO, this);
//			// GUIControl gc;
//			// if ((gc = (GUIControl) player.getControl("GUIControl")) != null)
//			// {
//			// add((Field) gc.initDisplayMode(GUIControl.USE_GUI_PRIMITIVE,
//			// null));
//			// }
			vc.setDisplayLocation(0, 0);
			vc.setDisplaySize(160, 120);
			vc.setVisible(true);
			player.start();
		} catch (Exception e) {
			Dialog.alert(e.toString());
			e.printStackTrace();
		}
		
	}

	public void close() {
		try {
			// player.removePlayerListener(this);
			player.stop();
			player.deallocate();
			player.close();
			is.close();
			player = null;
			is = null;
			vc = null;
			System.gc();
		} catch (Exception e) {
			Dialog.alert(e.toString());
		}
		super.close();
	}
}
