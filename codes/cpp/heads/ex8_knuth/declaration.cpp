#include "definition.h"

/*int KNUTH::seed=3;
int KNUTH::m=654321;
int KNUTH::k=40692;
int KNUTH::a=3;*/

namespace KNUTH {
	unsigned int seed=0;
	unsigned int m=65421;
	unsigned int k=4062;
	unsigned int a=2;
}

//using namespace KNUTH;

void KNUTH::set(int data){
	seed=data;
}

int KNUTH::get(){
	seed=(k*seed+a)%m;
	return seed;
}

int KNUTH::between(int a,int b){
	return a+get()%(b-a);
}


void KNUTH::test(){
	cout<<get()<<endl;
	cout<<get()<<endl;
	cout<<get()<<endl;
	cout<<between(1,6)<<endl;
	cout<<between(1,6)<<endl;
	cout<<between(1,6)<<endl;
	cout<<between(1,6)<<endl;
}