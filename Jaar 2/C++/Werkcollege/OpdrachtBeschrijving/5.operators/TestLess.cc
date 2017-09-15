#include "ansi.h"
#include "asserts.h"
#include <iostream>
using namespace std;

/** @file TestLess.cc
 * The implementation of class TestLess
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "Person.h"
#include "Marriage.h"
#include "TestLess.h"


/// Action to do prior to each test (fixed name!)
void	TestLess::setUp()
{
	//cout << "TestLess::setUp" << endl;
	// prepare the test
	m1     = nullptr;
	m2     = nullptr;
	willem = nullptr;
	maxima = nullptr;
	amalia = nullptr;
}

/// Action to do after each test (fixed name!)
void	TestLess::tearDown()
{
	//cout << "TestLess::tearDown" << endl;
	// Yes: In C++ you are allowed to "delete" null pointers
	delete m1;			m1 = nullptr;
	delete m2;			m2 = nullptr;
	delete willem;		willem = nullptr;
	delete maxima;		maxima = nullptr;
	delete amalia;		amalia = nullptr;
}


// Define the various testcases

// Using some preprocessor magic
#define	ABOUT(x,y)\
		cout << "\t" AS_BOLD<<*x<<AA_RESET<<endl;\
		cout << "\t" AS_BOLD<<*y<<AA_RESET<<endl;
#define	COMPARE(x,y)\
	if((*x) < (*y)) {\
		cout << AS_BOLD #x " < " #y AA_RESET " oke" << endl;\
		ABOUT(x,y)\
	} else \
		cout << AC_RED #x " < " #y " FAILED" AA_RESET << endl;
#define	COMPARE_NOT(x,y)\
	if(!((*x) < (*y))) {\
		cout << AS_BOLD "!(" #x " < " #y ")" AA_RESET " oke" << endl;\
		ABOUT(x,y)\
	} else \
		cout << AC_RED #x " < " #y " FAILED" AA_RESET << endl;

/// First test case: ordering of persons
void TestLess::testPerson()
{
	cout << "TestLess::testPerson" << endl;
	// create some persons
	amalia  = new Person("Amalia", 2002, Person::FEMALE);
	beatrix = new Person("Beatrix", 1938, Person::FEMALE);
	claus   = new Person("Claus", 1926, Person::MALE);
	maxima  = new Person("Maxima", 1971, Person::FEMALE);
	willem  = new Person("Willem-Alexander", 1967, Person::MALE);
	// compare by name
	COMPARE(amalia,maxima);
	COMPARE_NOT(maxima,amalia);
	COMPARE(amalia,beatrix);
	COMPARE_NOT(beatrix,amalia);
	COMPARE(beatrix,claus);
	COMPARE_NOT(claus,beatrix);
	COMPARE(claus,maxima);
	COMPARE(maxima,willem);
}

/// Second test case: ordering of marriages
void TestLess::testMarriage()
{
	cout << "TestLess::testMarriage" << endl;
	maxima  = new Person("Maxima", 1971, Person::FEMALE);
	willem  = new Person("Willem-Alexander", 1967, Person::MALE);
	m2 = new Marriage(willem, maxima, 2002);
	beatrix = new Person("Beatrix", 1938, Person::FEMALE);
	claus   = new Person("Claus", 1926, Person::MALE);
	m1 = new Marriage(beatrix, claus, 1966);
	// compare by name
	COMPARE(m1,m2);
	COMPARE_NOT(m2,m1);
}

/// The constructor gives a name to this testset and registers all testcases
TestLess::TestLess()
	: UnitTest("TestLess")
{
	// Register your test functions here
	addTest(static_cast<TestCase>(&TestLess::testPerson));
	addTest(static_cast<TestCase>(&TestLess::testMarriage));
}

// vim:sw=4:ts=4:ai:aw:
