//################ oop02 #################
class oop02
{
 static void main(String [] args)
 {

  System.out.println(
   "Hola Mundo"
   +"\n"+(new data("Helicoptero")).getData()
  );
 }
}

//################ data #################
class data
{
 private String data_string = "Hola desde Java Otra vez!!!";
 data(String s) {data_string=s;}
 public String getData() { return data_string; };
 public void setData(String dato_nuevo) { data_string=dato_nuevo; };
}