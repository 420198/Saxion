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
    cout << "sizeof long is " << sizeof(long) << endl;
    cout << "sizeof double is "<< sizeof(double) << endl;

    // array types
    cout << "sizeof int[3] is " << sizeof(int[3]) << endl;
    // TODO

    // pointer types
    cout << "sizeof int* is " << sizeof(int*) << endl;
    cout << "sizeof long* is " << sizeof(long*) << endl;
    cout << "sizeof double* is "<< sizeof(double*) << endl;
    // TODO

    // reference types
    cout << "sizeof int& is " << sizeof(int&) << endl;
    cout << "sizeof long& is " << sizeof(long&) << endl;
    cout << "sizeof double& is "<< sizeof(double&) << endl;
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

    cout << "\nmade by Stijn" <<endl;

    cout << "sizeof void is " << sizeof(void)<<endl;
    cout << "sizeof nullptr is " << sizeof(nullptr)<<endl;

    cout << "\nsizeof char[5] is " << sizeof(char[5])<<endl;
    cout << "sizeof char[3] is " << sizeof(char[3])<<endl;

    cout << "\nsizeof int[3] is " << sizeof(int[3])<<endl;
    cout << "sizeof int[5] is " << sizeof(int[5])<<endl;

    //std::string
    cout << "\nsizeof stijn const string is " << sizeof("stijn")<<endl;
    cout << "sizeof jasper123 const string is " << sizeof("jasper123")<<endl;
    cout << "sizeof empty const string is " << sizeof("")<<endl;
    cout << "sizeof const iueafhiahfoahfoiafhdi string is " << sizeof("iueafhiahfoahfoiafhdi")<<endl;

    //std::string instance
    cout << "\nsizeof stijn string is " << sizeof(string("name"))<<endl;
    cout << "sizeof jasper123 string is " << sizeof(string("jasper123"))<<endl;
    cout << "sizeof empty string is " << sizeof(string(""))<<endl;
    cout << "sizeof iueafhiahfoahfoiafhdi string is " << sizeof(string("iueafhiahfoahfoiafhdi"))<<endl;
    cout << "sizeof x string is " << sizeof(string("x"))<<endl;
    cout << "sizeof xx string is " << sizeof(string("xx"))<<endl;
    return EXIT_SUCCESS;
}
