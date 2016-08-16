class LockTest implements Runnable {
    public static void main(String [] args) {
        LockTest a = new LockTest();
        LockTest b = new LockTest();
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        ta.setName("Thread A...");
        tb.setName("Thread B...");
        ta.start();
        tb.start();
    }

    public synchronized void run () {
        for(int i=0; i<10 ; i++) {
            mostrarNombre(Thread.currentThread().getName());
            if(Thread.currentThread().getName().equals("Thread A...")) {
                try { Thread.sleep(500); }
                catch (InterruptedException ex) { ex.printStackTrace(); }
            }
        }

    }
    
    void mostrarNombre(String nombre) {
        System.out.println(nombre);
    }

}