class a
{
 a()
 {
  (new b() { public void print()
	{System.out.println("Hola Dios Java");}}).print();
 }
}

class b{}

class clases_anonimas
{
 static void main(String[] args)
 {
  a objeto = new a();
 }
}
    