#include "definition.h"

vector<double> WP::weights, WP::prices;


void WP::index(){
	double sum=0;
	weights.push_back(1);
	weights.push_back(2);
	weights.push_back(3);
	weights.push_back(5);
	weights.push_back(6);
	weights.push_back(8);
	
	prices.push_back(3);
	prices.push_back(3);
	prices.push_back(3);
	prices.push_back(3);

	if(weights.size()>prices.size()){
		cout<<"Difference in array size"<<endl;
		return;
	}
	
	for(int i=0;i<weights.size();i++){
		sum+=weights[i]*prices[i];
	}
	
	cout
		<<"Total "
		<<sum
		<<endl;
}

double WP::maxv(vector<double>& v) {
	if(v.size()==0) return 0;
	
	double maxim=v[0];
	for(int i=0;i<v.size();i++){
		if(v[i]>maxim) maxim=v[i];
	}
	return maxim;
}

WP::calcs WP::do_calcs(vector<double> v) {
	calcs x;
	if(v.size()==0) return x;
	
	/*x.smallest=1;
	x.largest=6;
	x.mean=3;
	x.median=3.5;
	return x;*/
	
	x.largest=v[0];
	x.smallest=v[0];
	double sum=0;
	
	sort(v.begin(),v.end());
	
	for(int i=0;i<v.size();i++){
		if(v[i]>x.largest) x.largest=v[i];
		if(v[i]<x.smallest) x.smallest=v[i];
		sum+=v[i];
	}
	x.mean=sum/v.size();
	
	if(v.size()%2==1){
		x.median=v[v.size()/2];
	} else {
		x.median = 
			(v[v.size()/2]+
			v[v.size()/2-1])
			/2
			;
	}
	
	
	return x;
	
}


void WP::print_until_s(const vector<string> v, const string quit){
	//v.push_back("guepa");
	//quit="quit";
	bool flag=false;
	for(int i=0;i<v.size();i++){
		if(v[i]==quit) {
			if(flag) return;
			else flag=true;
		}
		cout<<v[i]<<endl;
	}
}




WP::lex WP::do_lex(vector<string> v) {
	lex x;
	if(v.size()==0) return x;
	
	sort(v.begin(),v.end());
	
	x.top=v[0];
	x.bottom=v[v.size()-1];

	x.shortest=x.longest=v[0];

	
	for(int i=0;i<v.size();i++){
		if(v[i].size()<x.shortest.size()) x.shortest=v[i];
		if(v[i].size()>x.longest.size()) x.longest=v[i];
		x.l.push_back(v[i].length());
	}
	
	return x;
	
}





/*
TEST CASES
*/


void WP::test(){
	cout<<endl<<"===Calculate Index==="<<endl;
	index();
	cout
		<<"Max Weight: "
		<<maxv(weights)
		<<endl;
	
	calcs rst = do_calcs(weights);
	
	cout<<endl
		<<"calcs Struct Data: "
		<<"Small: "<<rst.smallest<<endl
		<<"Large: "<<rst.largest<<endl
		<<"Mean: "<<rst.mean<<endl
		<<"Median: "<<rst.median<<endl
		;
		
	vector<string> l;
	l.push_back("Hola");
	l.push_back("Ho");
	l.push_back("quit");
	l.push_back("Holalala");
	l.push_back("zquit");
	l.push_back("Hola");
	print_until_s(l,"quit");
	
	lex ll=do_lex(l);

	string s_test="ignacio";
	cout<<endl
		<<"lex Struct Data: "<<endl
		<<"top: "<<ll.top<<endl
		<<"bottom: "<<ll.bottom<<endl
		<<"shortest: "<<ll.shortest<<endl
		<<"longest: "<<ll.longest<<endl
		;
	cout<<endl<<"lex sizes:"<<endl;
	for(int i=0;i<ll.l.size();i++){
		cout<<ll.l[i]<<endl;
	}
		
	
}