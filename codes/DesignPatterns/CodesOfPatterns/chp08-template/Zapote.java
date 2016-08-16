class Zapote extends PrepararJugo {

    void echarEnVaso() {
        System.out.println("Echando los trozos en el vaso");
    }
    
    void mezclar() {
        System.out.println("Licuando en la Licuadora");
    }
    
    void servir() {
        System.out.println("Sirviendo la Batida");
    }

    boolean conLeche() { return false; }
    boolean conAzucar() { return false; }
    
}
