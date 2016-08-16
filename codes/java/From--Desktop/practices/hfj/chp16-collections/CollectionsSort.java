import java.util.*;

// Java Document
class CollectionsSort {
	public static void main (String [] args) {
		ArrayList<String> aco = new ArrayList<String>();
		aco.add("B");
		aco.add("C");
		aco.add("A");
		for(int i = 0; i < aco.size() ; i++) {
			System.out.print(aco.get(i));
		}
		System.out.println();
		Collections.sort(aco);
		for(int i = 0; i < aco.size() ; i++) {
			System.out.print(aco.get(i));
		}
		System.out.println();
		
		
	}
}