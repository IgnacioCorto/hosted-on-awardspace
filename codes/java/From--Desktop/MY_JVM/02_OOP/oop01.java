//import printer;

// ################### oop01 #######################

public class oop01
{
 public static void main(String [] args)
 {
  printer printer1 = new printer();
  printer1.print("Que jevi!! Estoy aprendiendo OPP!!");
  (new printer()).print("no me funciono el static!");
  (new printer()).print("ESTOY APRENDIENDO JAVA, CONO!!!");
  

  Data dato = new Data();
  Data b = new Data();
  StringBuffer comandos = new StringBuffer();
  for(int ii=0; ii<args.length; ii++) comandos.append(args[ii]+" ");

  String cadena = dato.data_string;
  System.out.println(
   dato.data_string
   +"\n"+dato.contador
   +"\n"+dato.doble
   +"\nComandos: "+comandos.toString()
   +"\nArgumentos: "+args.length
   +"\n2+3="+calculator.addem(2,3)
   );
 }
}

// ################### Data #######################

class Data
{
 protected String data_string = "Cadena Publica en 'Class Data'";
 protected static int contador=2;
 protected static int doble;
 static {doble = 2 * contador;}
}

// ################### Printer #######################

class printer
{

 public void print(String mensaje)
 {
  internal_use_only(mensaje);  
 }

 private void internal_use_only(String mensaje)
 {
  System.out.println(mensaje);
 }

}

// ################### calculator #######################

class calculator
{
 static int addem(int valor1, int valor2)
 {
  return valor1 + valor2;
 }
}
