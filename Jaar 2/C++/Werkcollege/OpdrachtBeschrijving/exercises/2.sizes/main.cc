#include <iostream>		// for: std::cout
#include <string>		// for: std::string
#include <cstdlib>		// for: EXIT_SUCCESS, EXIT_FAILURE
using namespace std;

/** @file main.cc
 * A program to print the sizes of various datatypes
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "classes.h"	// see: classes.h file


int main()
{
    cout << "Various datatype sizes." << endl;

    // built-in types
    cout << "sizeof int is " << sizeof(int) << endl;
    // TODO - add similar lines for other built-in types.

    // array types
    cout << "sizeof int[2] is " << sizeof(int[2]) << endl;
    // TODO

    // pointer types
    cout << "sizeof int* is " << sizeof(int*) << endl;
    // TODO

    // reference types
    cout << "sizeof int& is " << sizeof(int&) << endl;
    // TODO - compare the results with earlier results.
    // 		do you notice something funny?

    // std::string instances
    cout << "sizeof string(\"x\") is " << sizeof(string("x")) << endl;
    // TODO

    // C-string constants
    cout << "sizeof string constant \"x\"  is " << sizeof("x") << endl;
    // TODO - compare these with the result from the std::string versions

    // class type
    cout << "sizeof FunnySize1 is " << sizeof(FunnySize1) << endl;
    cout << "sizeof FunnySize2 is " << sizeof(FunnySize2) << endl;
    cout << "sizeof FunnySize3 is " << sizeof(FunnySize3) << endl;
    cout << "sizeof FunnySize4 is " << sizeof(FunnySize4) << endl;
    // 		observe how this affects size, and whether you understand
    // 		why it affects the size the way it does

    return EXIT_SUCCESS;
}
