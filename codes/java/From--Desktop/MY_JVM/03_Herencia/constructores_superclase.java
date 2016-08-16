//################### a ######################
class a
{
 a()
 {
  System.out.println("En el constructor de a...");
 }

 a(String s)
 {
  System.out.println("En el constructor String de a...");
  System.out.println(s);
 }
}

//################### a ######################
class b extends a
{
 b(String s)
 {
  super(s);
  System.out.println("En el constructor de b...");
  System.out.println(s);
 }
}

//################### constructores_superclase ######################
public class constructores_superclase
{
 public static void main(String [] args)
 {
  b objeto = new b("Lo hice con Ely");
 }
}