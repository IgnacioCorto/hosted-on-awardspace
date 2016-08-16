public class app03
{
public static void main(String [] args)
{
String s1="Hola ", s2="Desde ", s3="Java!", s4;
s4 = s1+s2+s3;

int budget = 1;
boolean fired = true;
String mensaje;

mensaje=
budget<0 | fired == true ?
 "Uh oh." : "Todavia es solvente";

System.out.println(
 s4+s4.charAt(15)
 +"\n"+s4.substring(1,2)
 +"\n"+s4.replace('D','d')
 +"\n"+s4.toUpperCase()
 +"\n"+mensaje
);

 System.out.println( (++budget) +" "+ budget );

}
}