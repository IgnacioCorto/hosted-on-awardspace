import java.io.*;
import java.net.*;

class MyServer {

    public static void main (String [] args) {
        MyServer obj = new MyServer();
        obj.executeProgram();
    }

    void mySleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (Exception ex) {}
    }
    
    /* The program starts here : */
    
    void executeProgram () {
        try {
            System.out.println("Waiting for a message...");
            ServerSocket srv = new ServerSocket(65535);
            Socket tsw = srv.accept();
            
            //Socket tsw = new Socket("127.0.0.1",65535);
            PrintWriter w = new PrintWriter(tsw.getOutputStream());
            w.println("a saying I would like you to recieve");
            w.print("the continuation of my phrase");
            w.close();
            System.out.println("Message Sent!!");

            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}