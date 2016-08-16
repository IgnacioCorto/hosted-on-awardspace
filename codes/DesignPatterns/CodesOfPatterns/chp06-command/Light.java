class Light {
    private int intensidad;
    private boolean encendida;
    
    Light(int brillo) {
        intensidad=brillo;
        encendida=false;
    }
    
    void encender() {
        encendida=true;
    }
    
    void apagar() {
        encendida=false;
    }

    void estado() {
        if(encendida) {
            System.out.print("Luz Encendida");
        } else {
            System.out.print("Luz Apagada");
        }
        System.out.println(", Brillo: "+intensidad);
    }
    
    void aclarar(int cantidad) {
        if (intensidad+cantidad>10) intensidad=10;
        else intensidad+=cantidad;
    }

    void obscurecer(int cantidad) {
        if (intensidad-cantidad<0) intensidad=0;
        else intensidad-=cantidad;
    }
    
}