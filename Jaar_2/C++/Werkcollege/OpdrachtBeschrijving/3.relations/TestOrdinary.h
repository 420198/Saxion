#ifndef	__TestOrdinary_H
#define	__TestOrdinary_H 6.1

/** @file TestOrdinary.h
 * The definition of class TestOrdinary
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */

#include "UnitTest.h"

// tell compiler about classes
class Marriage;
class Person;


/// @class TestOrdinary
/// A test class for class Marriage
class	TestOrdinary : public UnitTest
{
		Marriage	*marriage = nullptr;

		Person		*alex   = nullptr;
		Person		*maxima = nullptr;
		Person		*amalia = nullptr;
		Person		*alexia = nullptr;

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
		/// Declare the third testcase
		void	haveSecondChild();

		/// And the constructor
		TestOrdinary();
};


#endif	/*__TestOrdinary_H*/
// vim:sw=4:ts=4:ai:aw:
