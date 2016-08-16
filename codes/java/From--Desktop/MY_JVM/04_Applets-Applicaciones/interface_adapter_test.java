interface interfaz
{
 int metodo1();
 void metodo2();
}

class adaptador implements interfaz
{
 public int metodo1() { return 0; }
 public void metodo2() { }
}

class prueba extends adaptador
{
 public int metodo1()
 {
  return (new interface_adapter_test()).ignacio;
 }
}

public class interface_adapter_test
{
 public int ignacio = 3;

 public static void main(String[] args)
 {
  System.out.println((new prueba()).metodo1() );
 }
}