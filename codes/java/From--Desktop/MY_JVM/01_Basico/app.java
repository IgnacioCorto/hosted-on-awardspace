/*
   +-------------------------------------------------
   | Esta aplicacion visualiza "Hola desde Java"
   | 
   | Autor: G. Whiz, 1/1/00
   | Importanciones: Ninguna
   | Parametros: Argumentos de la linea de comandos
   | Retorno: Ninguno
   | Supuestos: Ninguno
   | Fecha de creacion: 28/jul/07
   | Ultima Actualizacion: 28/jul/07
   +-------------------------------------------------
*/

// importamos la clase Date
import java.util.*;

// importamos la clase Printer
import printer;

// Crear clase app
public class app

{
	// Crear main( ), punto de entrada a la aplicacion
	public static void main(String[] luis)

	{
		//Declaramos variabe days
		int days;

		//days sera 365
		days = 365;

		//Declaramos array accounts[]
		double accounts[][] = new double[2][100];

		//damos valores a accounts[*][3]
		accounts[0][3]=43.95;
		accounts[1][3]=2385489382.06;

		// Visualizar el mensaje con
		System.out.println("\nOJALA QUE TRABAJE ELIZABETH!!!");

		// Imprimimos la fecha actual
		System.out.println("Hoy = " + new Date() );

		// Imprimirmos el mensaje usando printer.print
		(new printer()).print();

		// Imprimimos a Days
		System.out.println("Numero de dias = "+ days);

		// Imprimimos accounts[*][3];
		System.out.println("Cuenta de Ahorros 3 = $" + accounts[0][3]);
		System.out.println("Cuenta Corriente  3 = $" + accounts[1][3]);

		// Definimos una cadena
		String saludo = "Hola desde *LLABA* usando un *STRING*";

		// y la imprimimos
		System.out.println(saludo);
	}

}