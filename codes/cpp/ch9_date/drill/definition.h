#include <std_lib_facilities.h>

namespace DRILL {

    //Simple Struct
    struct Date1 {
        int y,m,d;
    };
    
    //Helpers for the Simple Struct
    void init_day1(Date1&, int y, int m, int d);
    void add_day1(Date1&, int n);

    //Constructor in Struct (for Valid Initialization)
    struct Date2 {
        int y,m,d;
        // Date(int y, int m, int d);
        // void add_day(int n);
    };
    
    
    void test();
}
