
#include "fibo.h"

int main(){
	using namespace FIBONACCI;
	vector<int> v;
	try{
		//calculate(999999999,999999999,v,3);
		calculate(0,1,v,999999999);
		for(int i=0;i<v.size();i++){
		    cout<<"#"<<i<<": "<<v[i]<<endl;
		}		
	} catch (runtime_error& e) {
		 cout<<e.what()<<endl;
	}
	
}

