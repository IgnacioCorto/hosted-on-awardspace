//################ a ######
class a
{

 b b1;

 a ()
 {
  b1=new b();
 }

 private void finalize()
 {
  b1=null;
 }

}

//################ b ######
class b
{
 a a1;
 b()
 {
  a1= new a();
 }

 private void finalize()
 {
  a1=null;
 }

}

//################ borrame ######
class borrame
{
 static void main(String [] args)
 {
  a obj = new a();
 // obj = null;
 }
}