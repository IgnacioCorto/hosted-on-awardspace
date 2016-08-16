import java.io.*;
import java.net.*;

class MyThread {

    public static void main (String [] args) {
        MyThread obj = new MyThread();
        obj.executeProgram();
    }

    void mySleep(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException ex) {}
    }
    
    /* The program starts here : */
    
    void executeProgram () {
        try {
            Runnable r = new ProcesoParalelo();
            Thread t = new Thread(r);
            t.setName("Monstruo");
            t.start();
            
            for(int i = 0; i<20; i++) {
                System.out.println("Main"+i);
                mySleep(250);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    class ProcesoParalelo implements Runnable {
        public void run() {
            for(int i = 0; i<20; i++) {
                System.out.println("Paso de "+Thread.currentThread().getName()+" : "+i);
                mySleep(250);
                if(i==10) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {}
                }
            }
        }
    }

}