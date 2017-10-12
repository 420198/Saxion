#include "asserts.h"
#include <iostream>
using namespace std;

/** @file MyTest.cc
 * The implementation of class MyTest
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 1.3	2013/09/04
 */

#include "MyTest.h"


// Action to do prior to each test (fixed name!)
void	MyTest::setUp()
{
	cout << "MyTest::setUp" << endl;
}

// Action to do after each test (fixed name!)
void	MyTest::tearDown()
{
	cout << "MyTest::tearDown" << endl;
}


// ---- Define the various testcases ----

// First testcase
void	MyTest::myTest1()
{
	expectNoException();	// This is the default at each test
	cout << "MyTest::myTest1 1" << endl;
	expectException();		// We now expect some exception to occur
	cout << "MyTest::myTest1 2" << endl;
}

// Second testcase
void	MyTest::myTest2()
{
	cout << "MyTest::myTest2" << endl;
	notreached();			// borrowed from asserts.h
}


// The constructor gives a name to this testset,
// and then registers all the testcases to be performed.
MyTest::MyTest() : UnitTest("MyTest")
{
	// Register your test functions here
	//addTest( static_cast<TestCase>(&MyTest::myTest1) );
	//addTest( static_cast<TestCase>(&MyTest::myTest2) );
	addTest( TESTCASE(MyTest::myTest1) );
	addTest( TESTCASE(MyTest::myTest2) );
}

// vim:sw=4:ts=4:ai:aw:
