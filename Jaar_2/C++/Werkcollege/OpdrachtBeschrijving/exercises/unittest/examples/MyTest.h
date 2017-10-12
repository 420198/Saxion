#ifndef	__MYTEST_H
#define	__MYTEST_H

/** @file MyTest.h
 * The definition of class MyTest
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 1.3	2013/09/04
 */

#include "UnitTest.h"

/// @class MyTest
/// A sample UnitTest class.
class	MyTest : public UnitTest
{
	public:

		// Override the setUp and tearDown methods

		/// Override the action to do prior to each test
		void	setUp();
		/// Override the action to do after each test
		void	tearDown();

		// Now declare the various testcases (you may choose your own names)

		/// Declare the first testcase
		void	myTest1();
		/// Declare the second testcase
		void	myTest2();
		//  etc

		/// The constructor for this test
		MyTest();
};


// vim:sw=4:ts=4:ai:aw:
#endif	/*__MYTEST_H*/
