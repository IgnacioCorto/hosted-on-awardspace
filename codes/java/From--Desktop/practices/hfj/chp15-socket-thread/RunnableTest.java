class RunnableTest implements Runnable {

    public static void main( String [] args ) {
        Runnable r = new RunnableTest();
        Thread t = new Thread(r);
        t.start();
        System.out.println("Fin de RunnableTest");
    }

}