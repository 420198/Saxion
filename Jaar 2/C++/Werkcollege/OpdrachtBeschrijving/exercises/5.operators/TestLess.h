#ifndef	__TESTLESS_H
#define	__TESTLESS_H 6.1

/** @file TestLess.h
 * The definition of class TestLess
 * to compare persons and marriages.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "UnitTest.h"

class Person;
class Marriage;


/// @class TestLess
/// A test class for class Marriage
class	TestLess : public UnitTest
{
		Marriage	*m1	= nullptr;
		Marriage	*m2	= nullptr;

		Person		*claus	 = nullptr;
		Person		*beatrix = nullptr;
		Person		*willem	= nullptr;
		Person		*maxima	= nullptr;
		Person		*amalia	= nullptr;

	public:

		/// Overrule the action to do prior to each test (fixed name!)
		void	setUp();
		/// Overrrule the action to do after each test (fixed name!)
		void	tearDown();

		// Now declare the various testcases (you may choose your own names)

		/// Declare the first testcase
		void	testPerson();

		/// Declare the second testcase
		void	testMarriage();

		/// And the constructor
		TestLess();
};


// vim:sw=4:ts=4:ai:aw:
#endif	//__TESTLESS_H
