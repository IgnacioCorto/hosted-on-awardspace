class Product01 implements Product {
    public void presentarse() {
        System.out.println("Soy "
            + this.getClass().getName()
            + ", Descendiente de "
            + this.getClass().getSuperclass().getName()
            + " e implemento a "
            + this.getClass().getInterfaces()[0].getName()
            );
    }
}