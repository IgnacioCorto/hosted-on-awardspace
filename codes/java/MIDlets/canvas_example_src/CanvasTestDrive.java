/*
 * TestDrive.java
 *
 * Created on March 6, 2010, 8:58 AM
 */

package hello;

import hello.SampleCanvas;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.rms.*;

/**
 *
 * @author  dell
 * @version
 */

class AlertCanvas extends Form {
    
    public AlertCanvas(String title) {
        super(title);
    }
    
    
    protected void paint(Graphics g){
        g.setGrayScale(255);
        g.setColor(255, 0, 0);
        g.fillRect(0, 0, 30, 30);
        g.drawRoundRect(0, 0, 100,100, 5, 5);
    }
}

public class CanvasTestDrive extends MIDlet {
    
    private Display display;
    private AlertCanvas alertBox;
   //private SampleCanvas sample;
    
    public CanvasTestDrive(){
        display = Display.getDisplay(this);
        alertBox = new AlertCanvas("Titulo");
        //sample = new SampleCanvas();
    }
    
    public void startApp() {
        
        
        HttpConnection c = null;
        InputStream is = null;
        OutputStream os = null;
        String url = "http://localhost/ignacio/nokia/append.php" ;

        
        
        try {
        
            display.setCurrent(alertBox);
            System.out.println("Guepa!!!");

            //OutputStream os = Connector.openOutputStream("file:///ignacio.dat");
            RecordStore rms = RecordStore.openRecordStore("ignacio",true);
            byte [] entrada = {64,64,64,64};
            /*os.write(entrada);
            os.close();*/
            String parrafo 
                = "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                + "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                + "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                + "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                + "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                + "asd;lkfjasdkl;fjasdl;kfjasdklfjasd;lkfjasdkl;fjasdkl;fjasdkl;fjasdl;kfj"
                ;
            byte [] parraBytes = parrafo.getBytes("ISO-8859-1");            
            int rec_id = rms.addRecord(parraBytes,0,parraBytes.length);
            System.out.println("Escribio!!!");
            
            //InputStream is = Connector.openInputStream("file:///ignacio.dat");
            byte [] texto = new byte[4];
            texto = rms.getRecord(rec_id);
            /*is.read(texto);
            is.close();*/
            System.out.println( new String(texto) );
            System.out.println("Leyo!!!");
            
            alertBox.append("Dato: "+ new  String(texto));

            //  http://localhost/ignacio/nokia/append.php
            

       
            c = (HttpConnection)Connector.open(url);

            // Set the request method and headers
            c.setRequestMethod(HttpConnection.POST);
            System.out.println(HttpConnection.POST);
            /*c.setRequestProperty("If-Modified-Since",
                "29 Oct 1999 19:43:31 GMT");*/
            //c.setRequestProperty("User-Agent",
            //    "Profile/MIDP-1.0 Configuration/CLDC-1.0");
            //c.setRequestProperty("Content-Language", "en-US");
            //c.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            String datosPost = "parrafo="+ urlEncoder(new  String(texto)) ;
            //c.setRequestProperty("Content-Length", new Integer(datosPost.length()).toString() );

            // Getting the output stream may flush the headers
            os = c.openOutputStream();
            os.write( datosPost.getBytes() );
            os.flush();                // Optional, openInputStream will flush

            // Opening the InputStream will open the connection
            // and read the HTTP headers. They are stored until
            // requested.
            is = c.openInputStream();

            // Get the ContentType
            String type = c.getType();
            //processType(type);

            // Get the length and process the data
            int len = (int)c.getLength();
            if (len > 0) {
                byte[] data = new byte[len];
                int actual = is.read(data);
                //process(data);
                System.out.println(new String(data));
            } else {
                int ch;
                while ((ch = is.read()) != -1) {
                    //process((byte)ch);
                }
            }

            
        if (is != null)
                is.close();
            if (os != null)
                os.close();
            if (c != null)
                c.close();      
         
        
        } catch(RecordStoreException e) {
            e.printStackTrace();
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();            
        } catch(IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private String urlEncoder(String s) {
        try {
            if (s == null) {
                return (s);
            }
            StringBuffer sb = new StringBuffer(100);
            char c;
            for (int i = 0; i < s.length(); i++) {
                c = s.charAt(i);
                if ( (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') ||
                        (c >= 'a' && c <= 'z')) {
                    sb.append(c);
                    continue;
                }
                if (c > 15) { // is it a non-control char, ie. >x0F so 2 chars
                    sb.append("%" + Integer.toHexString( (int) c)); // just add % and the string
                } else {
                    sb.append("%0" + Integer.toHexString( (int) c)) ; // otherwise need to add a leading 0
                }
            }
        return (sb.toString());
        }
           catch (Exception ex) {
                System.out.println("Exception, URLencode string is " + s);
                return (null);
            }
        }    
    
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
