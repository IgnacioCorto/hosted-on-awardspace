public class app02
{
	public static void main(String [] args)
	{
		double array[][]=
			{  {1,2,3},
			   {3,2,1},
			   {1,2,3}   };

		int sum=0, total=0;
		for(
			int outer_index=0;
			outer_index<array.length;
			outer_index++)
		for(
			int inner_index=0;
			inner_index<array[outer_index].length;
			inner_index++)
			{
				sum+=array[outer_index][inner_index];
				total++;
				System.out.print(array[outer_index][inner_index]+" ");
			}
		System.out.println("\nValor medio del array = " + (sum/total) );

	}
}