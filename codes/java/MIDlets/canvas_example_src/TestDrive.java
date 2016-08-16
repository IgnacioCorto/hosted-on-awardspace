/*
 * TestDrive.java
 *
 * Created on March 6, 2010, 8:58 AM
 */

package hello;

import hello.SampleCanvas;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author  dell
 * @version
 */
public class TestDrive extends MIDlet {
    
    private Display display;
   private SampleCanvas sample;
    
    public TestDrive(){
        display = Display.getDisplay(this);
        sample = new SampleCanvas();
    }
    
    public void startApp() {
        display.setCurrent(sample);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
