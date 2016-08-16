class a { void print(){System.out.println("Aqui esta a...");} }
class b extends a { void print(){System.out.println("Aqui esta b...");} }
class c extends b { void print(){System.out.println("Aqui esta c...");} }
class d extends c { void print(){System.out.println("Aqui esta d...");} }

class poliformismo
{
 static void main(String[] args)
 {
  a a1 = new a();
  a b1 = new b();
  a c1 = new c();
  a d1 = new d();
  a aref;

  aref = a1; aref.print();
  aref = b1; aref.print();
  aref = c1; aref.print();
  aref = d1; aref.print();
 }
}