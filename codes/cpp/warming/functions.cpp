#include <std_lib_facilities.h>

void f(double){}

void g(int y) {
	f(y);
	double x(y);
	double z(int(3.14));
	cout <<z<<endl;
}

int main(){
  g(1);
  string hola("konnichi wa, sekai. \n");
  cout << hola ;
}
