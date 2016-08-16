//################# vehiculo #################
class vehiculo
{
 protected void start()
 {
  System.out.println("Arrancar...");
 }
}

//################# coche #################
class coche extends vehiculo
{
 public void drive()
 {
  System.out.println("Conducir...");
 }
}


//################# avion #################
class avion extends vehiculo
{
 public void fly()
 {
  System.out.println("Volar...");
 }
}

//################# whirlybird #################
class whirlybird extends avion
{
 public void whirl()
 {
  System.out.println("Girar...");
 }
}

//################# jet #################
class jet extends avion
{
 public void zoom()
 {
  System.out.println("Subir verticalmente...");
 }
}


//################# herencia00 #################
class herencia00
{
 static void main(String [] args)
 {
  System.out.println("Crear un coche...");
  coche c = new coche();
  c.start();
  c.drive();

  System.out.println();
  System.out.println("Crear un jet...");
  jet j = new jet();
  j.start();
  j.fly();
  j.zoom();

 }
}