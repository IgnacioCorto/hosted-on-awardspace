public class SingletonTestDrive {

    public static void main(String [] args) {
        new SingletonTestDrive().printNoStatic(); 

        XXX xxx = new XXX();
        System.out.println(xxx.fulano);
        
        int total = 10;
        Runnable [] r = new Runnable[total];
        Thread   [] t = new Thread[total];
        
        for(int i=0 ; i<total ; i++ ) {
            r[i] = new Thread01();
            t[i] = new Thread(r[i]);
        }
        for(int i=0 ; i<total ; i++ ) {
            System.gc();
            t[i].start();
        }
    }

    static void printStatic() {
        System.out.println("Desde Static");
    }

    void printNoStatic() {
        System.out.println("Desde No Static");
        printStatic();
    }

    
}

interface XX {
    String fulano="";
}

class XXX implements XX {
}