class TestSync implements Runnable {
    private int balance;
    
    public void run() {
        for(int i = 0; i < 50; i++ ) {
            increment();
        }
    }
    
    public /* synchronized */ void increment() {
        int i = balance;
        System.out.print("Actual("+i+") ");
        balance = i + 1;
        System.out.println("New("+balance+") ");
    }
}

public class TestSyncTest {
    public static void main (String [] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}