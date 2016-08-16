#include "ns.h"
#include <std_lib_facilities.h>

//namespace X { int hey=2; }

int X::hey=3;

void X::print(){ 
    cout<<"From X: "<<"guay "
        <<hey
        <<endl; 
}


