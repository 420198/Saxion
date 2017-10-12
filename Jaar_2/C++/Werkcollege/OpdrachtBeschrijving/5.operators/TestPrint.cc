#include "ansi.h"
#include "asserts.h"
#include <iostream>
using namespace std;

/** @file TestPrint.cc
 * The implementation of class TestPrint
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "TestPrint.h"
#include "Person.h"
#include "Marriage.h"


/// Action to do prior to each test (fixed name!)
void	TestPrint::setUp()
{
	//cout << "TestPrint::setUp" << endl;
	// prepare the test
	marriage = nullptr;
	alex   = nullptr;
	maxima = nullptr;
	amalia = nullptr;
}

/// Action to do after each test (fixed name!)
void	TestPrint::tearDown()
{
	//cout << "TestPrint::tearDown" << endl;
	// Yes: In C++ you are allowed to "delete" null pointers
	delete marriage;	marriage = nullptr;
	delete alex;		alex = nullptr;
	delete maxima;		maxima = nullptr;
	delete amalia;		amalia = nullptr;
}


// Define the various testcases

/// First testcase
void	TestPrint::getMarried()
{
	cout << "TestPrint::getMarried" << endl;
	// the actual test
	alex   = new Person("Willem-Alexander", 1967, Person::MALE);
	require(alex != nullptr);
	cout <<AS_BOLD<< (*alex) <<AA_RESET<< endl;			// PRINT TEST
	maxima = new Person("Maxima", 1971, Person::FEMALE);
	require(maxima != nullptr);
	cout <<AS_BOLD<< (*maxima) <<AA_RESET<< endl;		// PRINT TEST
	marriage = new Marriage(alex, maxima, 2002);
	// ensure the object was created
	check(marriage != nullptr);
	check(marriage->getChild()==nullptr);	// no child yet
	cout <<AS_BOLD<< (*marriage) <<AA_RESET<< endl;		// PRINT TEST
}

/// Second testcase
void	TestPrint::haveChild()
{
	cout << "TestPrint::haveChild" << endl;
	// the actual test
	alex   = new Person("Willem-Alexander", 1967, Person::MALE);
	cout <<AS_BOLD<< (*alex) <<AA_RESET<< endl;				// PRINT TEST
	maxima = new Person("Maxima", 1971, Person::FEMALE);
	cout <<AS_BOLD<< (*maxima) <<AA_RESET<< endl;			// PRINT TEST
	marriage = new Marriage(alex, maxima, 2002);
	// ensure the object was created
	check(marriage->getChild()==nullptr);	// no child yet
	cout <<AS_BOLD<< (*marriage) <<AA_RESET<< endl;			// PRINT TEST
	// add a child
	amalia = new Person("Amalia", 2002, Person::FEMALE);
	cout <<AS_BOLD<< (*amalia) <<AA_RESET<< endl;			// PRINT TEST
	marriage->addChild( amalia );
	check(marriage->getChild() == amalia);
	cout <<AS_BOLD<< (*marriage) <<AA_RESET<< endl;			// PRINT TEST
}


/// The constructor gives a name to this testset and registers all testcases
TestPrint::TestPrint()
	: UnitTest("TestPrint")
{
	// Register your test functions here
	addTest(static_cast<TestCase>(&TestPrint::getMarried));
	addTest(static_cast<TestCase>(&TestPrint::haveChild));
}

// vim:sw=4:ts=4:ai:aw:
