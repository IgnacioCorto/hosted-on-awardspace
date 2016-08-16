class display
{
 void imprimir() {System.out.println("Prueba");}
}

class copia extends display {}

class mi_primera_herencia
{
 static void main(String[] parametros)
 {
  copia objecto = new copia();
  objecto.imprimir();
 }
}