class RaceConditions implements Runnable {
    
    static int balance = 0;

    public static void main (String [] args) {
        RaceConditions run1 = new RaceConditions();
        RaceConditions run2 = new RaceConditions();
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.setName("Run #1");
        t2.setName("Run #2");
        t1.start();
        t2.start();
    }
    
    public void run() {
        for(int i = 0; i<10;i++) {
            incrementar();
        }
    }
    
    synchronized void incrementar() {
        System.out.print(Thread.currentThread().getName()+": ");
        System.out.print(balance+" --> ");
        System.out.println(++balance);
    }
    
    

}