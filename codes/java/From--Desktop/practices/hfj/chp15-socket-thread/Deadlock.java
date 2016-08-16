class Deadlock {
    public static void main(String [] args) {
        MyWorld obj = new MyWorld();
        obj.go();
    }
}

class MyWorld {
    public static int r = 10;
    foo a = new foo();
    bar b = new bar();

    void go() {
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        ta.start();
        tb.start();
    }

}

class foo implements Runnable {
    
    static synchronized void aMethod() {
        System.out.print("Method of [A],");
        try { Thread.sleep(1000); }
        catch (InterruptedException ex) { ex.printStackTrace(); }
    }
    
    public void run() {
        for(int i = 1; i<MyWorld.r ; i++) {
            foo.aMethod();
        }
    }
   
}

class bar implements Runnable {

    static synchronized void aMethod() {
        System.out.print("Method of [B],");
        try { Thread.sleep(1000); }
        catch (InterruptedException ex) { ex.printStackTrace(); }
    }

    public void run() {
        for(int i = 1; i<MyWorld.r ; i++) {
            bar.aMethod();
            foo.aMethod();
            System.out.println();
        }
    }
    
}