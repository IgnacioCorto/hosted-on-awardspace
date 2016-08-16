#include "my.h"
#include "swap.h"
#include <std_lib_facilities.h>

/*
#include "ns.h"
#include "ns0.h"
#include <std_lib_facilities.h>*/

/*namespace X {
    int var=0;
    void print(){ cout<<"From X: "<<var<<endl; }
}
namespace Y {
    int var=0;
    void print(){ cout<<"From Y: "<<var<<endl; }
}
namespace Z {
    int var=0;
    void print(){ cout<<"From Z: "<<var<<endl; }
}*/

int main(){
    {   cout << "Heads Drill" << endl;
    
        print_foo();
        print(99);
    }

    
    {   cout << "Swaps Drill" << endl;
    
        int x=7;
        int y=9;
        swap_v(x,y);
        cout<<"x="<<x<<"; y="<<y<<endl;
        swap_v(7,9);
        cout<<"x="<<x<<"; y="<<y<<endl;

         int cx=7;
         int cy=9;
        swap_cr(cx,cy);
        cout<<"cx="<<cx<<"; cy="<<cy<<endl;
        swap_cr(7.7,9.9);
        cout<<"cx="<<cx<<"; cy="<<cy<<endl;

        int dx=7.7;
        int dy=9.9;
        swap_r(dx,dy);
        cout<<"dx="<<dx<<"; dy="<<dy<<endl;
        swap_r(dx,dy);
        cout<<"dx="<<dx<<"; dy="<<dy<<endl;
    }

    /*{
        cout << "Namespaces Drill" << endl;

        X::var=7;
        X::print();
        using namespace Y;
        var=9;
        print();
        {   using Z::var;
            using Z::print;
            var=11;
            print();
        }
        print();
        X::print();
        
        NS0::var=777;
        NS0::print();
        
    } */
    
    
    {char cc;cin>>cc;}
}
