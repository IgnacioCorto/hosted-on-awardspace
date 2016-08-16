class SinToken extends EstadoMaquina {

    StateTestDrive estaMaquina;

    SinToken(StateTestDrive m) {
        estaMaquina = m;
    }

    void insertarToken() {
        System.out.println("Token Insertado. Gracias!!");
        estaMaquina.miEstado = estaMaquina.conToken;
    }
    void expulsarToken() {
        System.out.println("No has insertando un Token!!");
    }
    void girarPalanca() {
        System.out.println("No has insertando un Token");
    }
    void sacarMenta() {
        System.out.println("No has insertando un Token");
    }
}