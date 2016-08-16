
#include "label_print.h"


void LABEL_PRINT::print(string label, vector<int> arr){
	for(int i=0;i<arr.size();i++)
	cout << label << " --> " << arr[i] << endl;
}

void LABEL_PRINT::test(){
	cout << "in Test!" << endl;
	vector<int> aa(3,2);
	string bb="El Fuerte";
	print(bb,aa);
	
	cout << "in Test 2!" << endl;
	print("El Fuerte 2",vector<int> (3,22));
}
