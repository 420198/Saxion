#include "asserts.h"
#include <iostream>
using namespace std;

/** @file TestToYoung.cc
 * The implementation of class TestToYoung
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "TestToYoung.h"
#include "Person.h"
#include "Marriage.h"


/// Action to do prior to each test (fixed name!)
void	TestToYoung::setUp()
{
	cout << "TestToYoung::setUp" << endl;
	// preconditions
	require(to_young_boy == nullptr);
	to_young_boy  = new Person("Jim", 1999, Person::MALE);
	require(to_young_girl == nullptr);
	to_young_girl = new Person("Kim", 2001, Person::FEMALE);
}

/// Action to do after each test (fixed name!)
void	TestToYoung::tearDown()
{
	cout << "TestToYoung::tearDown" << endl;
	delete to_young_girl;	to_young_girl = nullptr;
	delete to_young_boy;	to_young_boy  = nullptr;
}
// Define the various testcases

/// First testcase
void TestToYoung::getMarried()
{
	cout << "TestToYoung::getMarried" << endl;
	// preconditions
	require(to_young_boy  != nullptr);
	require(to_young_girl != nullptr);
	// the test
	expectException();			// We expect that the next action will fail
	Marriage *marriage = new Marriage(to_young_boy, to_young_girl, 2008);
	delete marriage;
}


/// The constructor gives a name to this testset and registers all testcases
TestToYoung::TestToYoung() : UnitTest("TestToYoung")
{
	// Register your test functions here
	addTest(static_cast<TestCase>(&TestToYoung::getMarried));
}

// vim:sw=4:ts=4:ai:aw:
