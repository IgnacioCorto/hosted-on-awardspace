
#include "fibo.h"

void FIBONACCI::calculate(int x, int y, vector<int>& v,int n){
    v.push_back(x);
    v.push_back(y);
    int nn;
    for(int i=0;i<n;i++){
	nn=v[i]+v[i+1];
	if(nn<0) error("Limit Found",v[i-1]);
	v.push_back( nn );
    }
}