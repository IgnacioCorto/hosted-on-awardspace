#include "declaration.h"

//integers arrays

vector<int> REVERSE::rev_int_n(vector<int>& v){
    vector<int> arr;
    arr=v;
    rev_int_r(arr);
    return arr;
}

void REVERSE::rev_int_r(vector<int>& v){
    for(int i=0;i<v.size()/2;i++)
	swap(v[i],v[v.size()-i-1]);
    cout<<endl;
}

void REVERSE::swap_int(int& a, int& b){
    int temp=a;
    a=b;
    b=temp;
}

void REVERSE::print_int_arr(string s, vector<int>& v){
    cout<<s;
    for(int i=0;i<v.size();i++)
	cout<<v[i]<<" ";
    cout<<endl;    
}


//strings arrays

vector<string> REVERSE::rev_str_n(vector<string>& v){
    vector<string> arr;
    arr=v;
    rev_str_r(arr);
    return arr;
}

void REVERSE::rev_str_r(vector<string>& v){
    for(int i=0;i<v.size()/2;i++)
	swap(v[i],v[v.size()-i-1]);
    cout<<endl;
}

void REVERSE::swap_str(string& a, string& b){
    string temp=a;
    a=b;
    b=temp;
}

void REVERSE::print_str_arr(string s, vector<string>& v){
    cout<<s;
    for(int i=0;i<v.size();i++)
	cout<<v[i]<<" ";
    cout<<endl;    
}


//test


void REVERSE::test(){
    
    cout<<"===Integers==="<<endl<<endl;
    
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(4);
    arr.push_back(5);
    
    print_int_arr("Normal Array: ",arr);
    
    vector<int> new_arr = rev_int_n(arr);

    print_int_arr("New Array: ",new_arr);
    print_int_arr("Normal Array: ",arr);

    rev_int_r(arr);
    print_int_arr("Normal Array (reversed): ",arr);


    cout<<endl<<"===Strings==="<<endl<<endl;
    

    vector<string> arr_s;
    arr_s.push_back("A");
    arr_s.push_back("B");
    arr_s.push_back("C");
    arr_s.push_back("D");
    arr_s.push_back("E");
    
    print_str_arr("Normal Array: ",arr_s);
    
    vector<string> new_arr_s = rev_str_n(arr_s);

    print_str_arr("New Array: ",new_arr_s);
    print_str_arr("Normal Array: ",arr_s);

    rev_str_r(arr_s);
    print_str_arr("Normal Array (reversed): ",arr_s);
    
    

}
