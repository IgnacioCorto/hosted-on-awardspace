class SinMentas extends EstadoMaquina {

    StateTestDrive estaMaquina;

    SinMentas(StateTestDrive m) {
        estaMaquina = m;
    }


    void insertarToken() {
        System.out.println("No hay mentas");
    }
    void expulsarToken() {
        System.out.println("No hay mentas");
    }
    void girarPalanca() {
        System.out.println("No hay mentas");
    }
    void sacarMenta() {
        System.out.println("No hay mentas");
    }
}