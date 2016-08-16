#include <std_lib_facilities.h>

namespace WP {
	extern vector<double> weights,prices;
	
	struct calcs{
		double smallest;
		double largest;
		double mean;
		double median;
	};

	struct lex{
		vector<int> l;
		string top;
		string bottom;
		string shortest;
		string longest;
	};	
	
	void index();
	double maxv(vector<double>&);
	calcs do_calcs(vector<double>);
	void print_until_s(const vector<string>, const string);
	lex do_lex(vector<string>);

	void test();

}
