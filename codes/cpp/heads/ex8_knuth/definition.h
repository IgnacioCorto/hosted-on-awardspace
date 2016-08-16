#ifndef _EX8_KNUTH
#define _EX8_KNUTH
#include <std_lib_facilities.h>

namespace KNUTH {
	extern unsigned int seed,m,k,a;
	
	void set(int);
	int get();
	void test();
	int between(int,int);
}

#endif

/*

[m]        [k]
2^31-249   40692
2^31-1     48271
2^31-1     62089911
2^32       69069
2^48       31167285
2^64-1     6364136223846793005


x1 = (k*x0+a) mod m

	k=multiplier
	a=increment
	m=modulus

x2 = (e*x0-pi*x1) mod 2^31-1    //more random one

*/