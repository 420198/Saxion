/** @file main.cc
 * The example test program
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 1.2	2012/09/24
 */

/** @mainpage
 * This is a mini-unittest framework in JUnit 3 style.
 * What is needed:
 * <ul>
 * <li>The UnitTest baseclass
 * <li>Your own, derived testclass, e.g. MyTest.
 * <li>A function using them
 * </ul>
 * @example MyTest.h
 * @example MyTest.cc
 * @example main.cc
 */
#include <iostream>
using namespace std;

#include "MyTest.h"

/** @fn int main()
 * The main() function of this example program.
 * It declares an instance of a testclass
 * and then calls it's run method.
 */
int main()
{
	cout << "Hello test world!" << endl;

	MyTest  the_test;						// A MyTest instance ...
	int errorCount = the_test.run();		// ... to be run

	return (errorCount);
}

// vim:sw=4:ts=4:ai:aw:
