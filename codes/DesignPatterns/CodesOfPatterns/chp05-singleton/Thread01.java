class Thread01 implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        MySingleton s = MySingleton.getInstance();
        System.out.println("Total Singletons:"+s.getTotal());
    }

}