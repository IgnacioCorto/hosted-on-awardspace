interface alertas
{
 String hacer_ruido(String acochee);
}

public class consola_acochee
{
 public static void main(String[] args)
 {
  megafono object1 = new megafono();
  System.out.println(object1.hacer_ruido("A aprender Java!!!"));
 }
}

class megafono implements alertas
{
 public String hacer_ruido(String acochee)
 {
  return "El ruido que se hara es ===> " + acochee;
 }
}