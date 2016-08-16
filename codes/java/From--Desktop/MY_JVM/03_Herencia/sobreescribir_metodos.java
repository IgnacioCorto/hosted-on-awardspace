//########## animal ##########
class animal
{
 final void breathe()
 {
  System.out.println("Respirar...");
 }
}

//########## pez ##########
class pez extends animal
{
 void breathe()
 {
  System.out.println("Burbujear...");
 }
 void newbreathe()
 {
  super.breathe();
 }
}

//########## sobreescribir_metodos ##########
class sobreescribir_metodos
{
 static void main(String [] args)
 {
  animal perro = new animal();
  perro.breathe();

  pez pescado = new pez();
  pescado.breathe();
  pescado.newbreathe();
 }
}