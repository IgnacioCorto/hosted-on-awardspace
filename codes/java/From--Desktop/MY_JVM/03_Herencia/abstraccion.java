abstract class a
{ abstract String getData();
  void print() { System.out.println(getData()); }  }

class b extends a
{  String getData() { return "Hola desde Java"; }  }

class abstraccion
{
 static void main(String[] args)
 {
  b b1 = new b();
  b1.print();
 }
}