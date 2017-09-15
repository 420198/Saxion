#include <cstdlib>  // for: EXIT_SUCCESS, EXIT_FAILURE

/** @file main.cc
 * The main function running the testcases.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

// include the testcase definitions
#include "TestPrint.h"
#include "TestLess.h"


int main()
{
	bool  success = true;      // optimistic

	// The two test sets ...

	TestPrint		t0;		// the test for the << operator
	if(t0.run() > 0)
		success = false;

	TestLess		t1;		// the test for the < operator
	if(t1.run() > 0)
		success = false;

	// The conclusion
	return success ? EXIT_SUCCESS : EXIT_FAILURE;
}


// vim:sw=4:ts=4:ai:aw:
