#ifndef	__TESTPRINT_H
#define	__TESTPRINT_H 6.1

/** @file TestPrint.h
 * The definition of class TestPrint
 * was derived from TestOrdinay
 * by removing a redundant testcase
 * and adding a few output statements.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "UnitTest.h"

class Person;
class Marriage;


/// @class TestPrint
/// A test class for class Marriage
class	TestPrint : public UnitTest
{
		Marriage	*marriage	= nullptr;

		Person		*alex	= nullptr;
		Person		*maxima	= nullptr;
		Person		*amalia	= nullptr;

	public:

		/// Overrule the action to do prior to each test (fixed name!)
		void	setUp();
		/// Overrrule the action to do after each test (fixed name!)
		void	tearDown();

		// Now declare the various testcases (you may choose your own names)

		/// Declare the first testcase
		void	getMarried();
		/// Declare the second testcase
		void	haveChild();

		/// And the constructor
		TestPrint();
};


// vim:sw=4:ts=4:ai:aw:
#endif	//__TESTPRINT_H
