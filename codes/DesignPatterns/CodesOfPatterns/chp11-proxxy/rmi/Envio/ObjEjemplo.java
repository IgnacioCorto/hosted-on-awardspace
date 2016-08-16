import java.io.Serializable;

class ObjEjemplo implements Serializable {
    Persona ignacio = new Persona();
    String id = "Objeto Ejemplo";
    
    void getDatos() {
        System.out.println("ID: "+id);
        System.out.println("Nombre: "+ignacio.nombre);
        System.out.println("Edad: "+ignacio.edad);
    }
}
