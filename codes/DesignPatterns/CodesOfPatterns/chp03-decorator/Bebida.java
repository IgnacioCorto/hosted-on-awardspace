abstract class Bebida {
    String descripcion = "Bebida Desconocida";
    
    public String getDescripcion() {
        return descripcion;
    }
    
    protected abstract double costo();
   
}