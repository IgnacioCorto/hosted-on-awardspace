public class app01
{
	public static void main(String[] args)
	{
		char valor;
		boolean booleano1 = false;
		valor = 'A'; System.out.println("Valor: \""+valor+"\"");
		valor++; System.out.println("Valor: \""+valor+"\"");
		System.out.println("Luis\nIgnacio\nCortorreal\nDe La Cruz");

		if(booleano1) System.out.println("Booleano1 es Verdadero");
		else System.out.println("Booleano1 es falso");

		int int1 = 2, int2 = 3;
		int int3 = int1 * int2;
		System.out.println("int1="+int1+", int2="+int2+", int3="+int3);

		int cint1=1; byte cbyte1=(byte)cint1; System.out.println("cbyte1="+cbyte1);
//		byte cbyte1=1; int cint1=cbyte1;  System.out.println("cint1="+cint1);

		byte dbyte1=100, dbyte2=100, dbyte3;
		dbyte3=(byte)(dbyte1*dbyte2/100);
		System.out.println("dbyte3 = "+dbyte3);
		
	}
}
