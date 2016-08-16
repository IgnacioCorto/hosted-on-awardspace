class ConToken extends EstadoMaquina {

    StateTestDrive estaMaquina;

    ConToken(StateTestDrive m) {
        estaMaquina = m;
    }

    void insertarToken() {
        System.out.println("Ya tiene un Token!!");
    }
    void expulsarToken() {
        System.out.println("Token Expulsado. Que Pena!!");
        estaMaquina.miEstado = estaMaquina.sinToken;
    }
    void girarPalanca() {
        System.out.println("Has Girado la palanca.");
        estaMaquina.miEstado = estaMaquina.mentaVendida;
    }
    void sacarMenta() {
        System.out.println("Debes girar la palanca primero.");
    }
}