abstract class PrepararJugo {

    void preparar() {
     System.out.println("---"+this.getClass().getName()+"---");
     pelar();
     echarEnVaso();
     if( conAzucar() ) { echarAzucar(); }
     if( conLeche() ) { echarLeche(); }
     mezclar();
     servir();
    }
    
    void pelar() {
        System.out.println("Pelando la fruta");
    }
    
    abstract void echarEnVaso();

    boolean conAzucar() { return true; }

    void echarAzucar() {
        System.out.println("Echando Azucar");
    }

    boolean conLeche() { return true; }

    void echarLeche() {
        System.out.println("Echando Leche");
    }

    abstract void mezclar();
    abstract void servir();
    
    
}