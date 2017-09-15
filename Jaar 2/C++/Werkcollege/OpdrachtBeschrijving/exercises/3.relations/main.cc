#include <string>		// for: std::string
using namespace std;

#include "asserts.h"		// for: require(expr)


/** @file main.cc
 * The main function running the testcases.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */

// Include the testcase definitions
#include "TestToYoung.h"
#include "TestOrdinary.h"


int main()
{
	bool  success = true;      // optimistic

	// Two test cases ...

	TestToYoung  t1;
	if(t1.run() > 0)        // more than 0 errors?
		success = false;

	TestOrdinary  t2;
	if(t2.run() > 0)
		success = false;

	// The conclusion

	return success ? EXIT_SUCCESS : EXIT_FAILURE;
}

// vim:sw=4:ts=4:ai:aw:
