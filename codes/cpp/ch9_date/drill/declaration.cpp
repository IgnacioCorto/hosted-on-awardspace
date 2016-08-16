#include "definition.h"

void DRILL::test() {
    cout << "Drill #9..." << endl;
    
    Date1 today1;
    today1.y=-3;
    today1.m=13;
    today1.d=32;
    
    try{
        init_day1(today1,1981,1,1);

        cout<<today1.y<<'-'<<today1.m<<'-'<<today1.d<<endl;
        add_day1(today1,365);
        cout<<today1.y<<'-'<<today1.m<<'-'<<today1.d<<endl;
    }catch(exception& e){
        cout<<e.what()<<endl;
    }
    
}


/**
 *  Helpers and Implementations
 */

void DRILL::init_day1(Date1& date, int y, int m, int d) {
    if(y<1970 || y>2038) error("Invalid Year");
    if(m<1 || m>12) error("Invalid Month");

    if(d<1) error("Invalid Day");
    
    switch(m){
        case 4:
        case 11:
        case 6:
        case 9:
            if(d>30) error("Invalid Day");
            break;
        case 2:
            if(d>29) error("Invalid Day");
            if(d==29 && y%4!=0)  error("February is not Leap");
            break;
        default:
            if(d>31) error("Invalid Day");
            break;
    }
    
    date.y=y;
    date.m=m;
    date.d=d;
}


void DRILL::add_day1(Date1& date, int n) {
    init_day1(date,date.y,date.m,date.d);

    for(int i=0;i<n;i++){
        date.d++;
        switch(date.m){
            case 4:
            case 11:
            case 6:
            case 9:
                if(date.d==31) {
                    date.d=1;
                    date.m++;
                }
                break;
            case 2:
                if(date.y%4){
                    if(date.d==29) {
                        date.d=1;
                        date.m++;
                    }
                } else {
                    if(date.d==30) {
                        date.d=1;
                        date.m++;
                    }
                }

                break;
            default:
                if(date.d==32) {
                    date.d=1;
                    date.m++;
                }
                break;
        }
        if(date.m==13) {
            date.m=1;
            date.y++;
        }
    }

}
