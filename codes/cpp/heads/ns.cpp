#include "ns.h"
#include <std_lib_facilities.h>

int X::var=1;
int Y::var=2;
int Z::var=3;

void X::print(){ cout<<"From X: "<<var<<endl; }
void Y::print(){ cout<<"From Y: "<<var<<endl; }
void Z::print(){ cout<<"From Z: "<<var<<endl; }

