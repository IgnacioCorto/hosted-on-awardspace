//################## Data ##################
class Data
{
 String data_string;
 Data(String s) {data_string=s;}
}

//################## Class ##################
class Class
{
 void rewrite(Data d) {d.data_string="Hola a Java";}
}

//################## object_reference ##################
class object_reference
{
 static void main(String [] args)
 {
  Data d = new Data("Hola desde Java!");
  Class c = new Class();

  c.rewrite(d);
  System.out.println(d.data_string);
  c=null;
 }
}