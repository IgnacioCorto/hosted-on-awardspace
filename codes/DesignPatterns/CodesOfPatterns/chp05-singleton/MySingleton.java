// la clase SINGLETON debe ser "public"
public class MySingleton {

   // una variable "private static" para guardar
   // la unica instancia del SINGLETON
   private static MySingleton instanciaUnica;
   private static int contador=0;

   // el constructor debe ser "private"
   // y estar VACIO, pues no se necesita
   private MySingleton() { }

   // el metodo constructor debe ser "static"   
   public static MySingleton getInstance() {

      // si no hay un SINGLETON creado
      // se crea y se retorna la referencia
      if (instanciaUnica == null) {
          synchronized(MySingleton.class) {
              if (instanciaUnica == null) {
                  instanciaUnica = new MySingleton();
                  instanciaUnica.contador++;
              }
          } 
      }      
      return instanciaUnica;      

   }
   
  public static int getTotal() {
      return contador;      
   }

}


