public class DecoradorAzucar extends Decorador {
    Bebida bebida;
    
    public DecoradorAzucar(Bebida b) {
        bebida = b;
    }

    public String getDescripcion() {
        return bebida.getDescripcion() + ", Azucar";
    }

    public double costo() {
        return bebida.costo() + 5.55;
    }
    
}