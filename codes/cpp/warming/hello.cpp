#include <std_lib_facilities.h>

int main(){
    cout << "Hello, World!\n";
    int current;
    cin>>current;
    while(cin){
        cout<<"-> "<<current<<endl;
        cin>>current;
    }
    try{
        error("non-positive area");
    }catch(exception& e){
       cout<<"guepa: "<<e.what()<<endl;
    }
    
    keep_window_open();
    return 0;
}
