#ifndef	__TestToYoung_H
#define	__TestToYoung_H 6.1

/** @file TestToYoung.h
 * The definition of class TestToYoung
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include "UnitTest.h"

// Tell compiler Person is a class
class Person;

/// @class TestToYoung
/// A test class for class Huwelijk
class	TestToYoung : public UnitTest
{
		Person *to_young_boy	= nullptr;
		Person *to_young_girl	= nullptr;

	public:
		/// Overrule the action to do prior to each test (fixed name!)
		void	setUp();
		/// Overrule the action to do after each test (fixed name!)
		void	tearDown();

		// Now declare the various testcases (you may choose your own names)
		/// Declare the first testcase
		void	getMarried();

		/// The constructor
		TestToYoung();
};


#endif	/*__TestToYoung_H*/
// vim:sw=4:ts=4:ai:aw:
