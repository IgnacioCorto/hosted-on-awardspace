class MentaVendida extends EstadoMaquina {

    StateTestDrive estaMaquina;

    MentaVendida(StateTestDrive m) {
        estaMaquina = m;
    }

    void insertarToken() {
        System.out.println("Favor esperar que la menta "
                + "le sea entregada!!");
    }
    
    void expulsarToken() {
        System.out.println("No puedes expulsar. Ya compraste!!");
    }
    
    void girarPalanca() {
        System.out.println("Girar mas veces no te dara "
                + "mas mentas!!");
    }
    void sacarMenta() {
        System.out.println("Menta Vendada. "
                + "Gracias por su compra");
        estaMaquina.miEstado = estaMaquina.sinToken;
    }
}