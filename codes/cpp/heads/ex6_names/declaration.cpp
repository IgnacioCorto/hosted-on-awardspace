#include "definition.h"

int NAMES::amount=0;
vector<string> NAMES::names;
vector<double> NAMES::ages;

void NAMES::input_names(){
	string name;
	for(int i=1;i<=amount;i++){
		cout<<"Name "<<i<<": ";
		cin>>name;
		cout<<endl;
		names.push_back(name);
	}
}

void NAMES::input_ages(){
	double age;
	for(int i=0;i<names.size();i++){
		cout<<"Age "<<names[i]<<": ";
		cin>>age;
		cout<<endl;
		ages.push_back(age);
	}
}

void NAMES::print_data(){
	for(int i=0;i<names.size();i++){
		cout
			<<"("
			<<names[i]
			<<", "
			<<ages[i]
			<<")"
			<<endl
			;
	}
	cout<<endl;

}


void NAMES::sort_data(){
	vector<string> an = names;
	vector<double> aa = ages;

	sort(aa.begin(),aa.end());
	
	for(int i=0;i<aa.size();i++){
		for(int j=i;j<aa.size();j++){
			if(aa[i]==ages[j]){
				swap(an[i],an[j]);
				break;
			}
		}
	}
	
	cout<<"==SORTED BY AGE=="<<endl;

	for(int i=0;i<names.size();i++){
		cout
			<<"("
			<<an[i]
			<<", "
			<<aa[i]
			<<")"
			<<endl
			;
	}
	
}

void NAMES::swap(string& a,string& b){
	string temp=a;
	a=b;
	b=temp;
}

void NAMES::check_amount(){
	if(amount<=0){
		cout<<"Amount of names: ";
		cin>>amount;
		cout<<endl;
	}
}

void NAMES::test(){
	check_amount();
	input_names();
	input_ages();
	print_data();
	sort_data();
	//print_data();
}