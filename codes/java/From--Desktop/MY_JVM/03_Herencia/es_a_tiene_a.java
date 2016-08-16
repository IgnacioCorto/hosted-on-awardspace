class a extends b
{ a() { print(); } }

class b { void print() { System.out.println("Viene de clase b..."); } }


class x { y y1; x ( ) { y1 = new y() ; y1.print( ) ; } }

class y { void print() { System.out.println("Viene de y..."); } }


class es_a_tiene_a
{
 static void main(String[] args)
 {
  a objeto1 = new a();
  x objeto2 = new x();
 }
}