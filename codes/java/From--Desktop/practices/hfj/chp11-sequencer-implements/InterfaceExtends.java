interface AClass {
    void desplegar(String mensaje);
}

interface AInterface extends AClass {
    void gritoDeGuerra();
}

class AnotherClass implements AInterface {
    public void gritoDeGuerra() {
        System.out.println("Sere Rico, Millonario y poderoso");
    }
    
    public void desplegar(String mensaje) {
        System.out.println(mensaje);
    }

}

class InterfaceExtends {
    public static void main(String [] args) {
        AnotherClass obj = new AnotherClass();
        obj.desplegar("Este es mi grito de guerra:");
        obj.gritoDeGuerra();
        obj.desplegar("I will be rich, millionaire and powerful! (En Ingles)");
    }
}