#include "asserts.h"
#include <iostream>
using namespace std;

/** @file TestOrdinary.cc
 * The implementation of class TestOrdinary
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2017/10/17
 */

#include "TestOrdinary.h"
#include "Person.h"
#include "Marriage.h"


/// Action to do prior to each test (fixed name!)
void	TestOrdinary::setUp()
{
	cout << "TestOrdinary::setUp" << endl;
	// prepare the test
	require(marriage == nullptr);
	require(alex == nullptr);
	require(maxima == nullptr);
	require(amalia == nullptr);
	require(alexia == nullptr);
}

/// Action to do after each test (fixed name!)
void	TestOrdinary::tearDown()
{
	cout << "TestOrdinary::tearDown" << endl;
	// Yes: In C++ you are allowed to "delete" null pointers
	delete marriage;	marriage = nullptr;
	delete alex;		alex   = nullptr;
	delete maxima;		maxima = nullptr;
	delete amalia;		amalia = nullptr;
	delete alexia;		alexia = nullptr;
}


// Define the various testcases

/// First testcase
void	TestOrdinary::getMarried()
{
	cout << "TestOrdinary::getMarried" << endl;
	// prepare the test
	alex   = new Person("Willem-Alexander", 1967, Person::MALE);
	require(alex != nullptr);
	maxima = new Person("Maxima", 1971, Person::FEMALE);
	require(maxima != nullptr);
	// the actual test
	marriage = new Marriage(alex, maxima, 2002);
	check(marriage != nullptr);
	check(marriage->getChild()==nullptr);	// no child yet
}

/// Second testcase
void	TestOrdinary::haveChild()
{
	cout << "TestOrdinary::haveChild" << endl;
	// prepare the test
	alex   = new Person("Willem-Alexander", 1967, Person::MALE);
	require(alex != nullptr);
	maxima = new Person("Maxima", 1971, Person::FEMALE);
	require(maxima != nullptr);
	marriage = new Marriage(alex, maxima, 2002);
	check(marriage != nullptr);
	check(marriage->getChild()==nullptr);	// no child yet
	// and now add a child
	amalia = new Person("Amalia", 2002, Person::FEMALE);
	check(amalia != nullptr);
	marriage->addChild( amalia );
	check(marriage->getChild() == amalia);
}

/// Third testcase
void	TestOrdinary::haveSecondChild()
{
	cout << "TestOrdinary::haveSecondChild" << endl;
	// prepare the test
	alex   = new Person("Willem-Alexander", 1967, Person::MALE);
	require(alex != nullptr);
	maxima = new Person("Maxima", 1971, Person::FEMALE);
	require(maxima != nullptr);
	marriage = new Marriage(alex, maxima, 2002);
	check(marriage != nullptr);
	check(marriage->getChild()==nullptr);	// no child yet
	// add a child
	amalia = new Person("Amalia", 2002, Person::FEMALE);
	check(amalia != nullptr);
	marriage->addChild( amalia );
	check(marriage->getChild()==amalia);
	// and now add another child
	alexia = new Person("Alexa", 2005, Person::FEMALE);
	check(alexia != nullptr);
	expectException();				// the next action is expected to fail
	marriage->addChild( alexia );
	notreached();					// should not get here anymore
}


/// The constructor gives a name to this testset and registers all testcases
TestOrdinary::TestOrdinary() : UnitTest("TestOrdinary")
{
	// Register your test functions here
	addTest(static_cast<TestCase>(&TestOrdinary::getMarried));
	addTest(static_cast<TestCase>(&TestOrdinary::haveChild));
	addTest(static_cast<TestCase>(&TestOrdinary::haveSecondChild));
}

// vim:sw=4:ts=4:ai:aw:
