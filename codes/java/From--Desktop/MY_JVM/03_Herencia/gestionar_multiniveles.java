//############## a ################
class a { a() { System.out.println("Construccion de a..."); } }

//############## b ################
class b extends a { b() { System.out.println("Construccion de b..."); } }

//############## c ################
class c extends b { c() { System.out.println("Construccion de c..."); } }

//############## d ################
class d extends c { d() { System.out.println("Construccion de d..."); } }

//############## gestionar_multiniveles ################
class gestionar_multiniveles
{
 static void main(String [] args)
 {
  d objeto = new d();
 }
}