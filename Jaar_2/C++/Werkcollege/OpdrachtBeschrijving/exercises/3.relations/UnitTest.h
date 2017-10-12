#ifndef	__UNITTEST_H
#define	__UNITTEST_H

/** @file UnitTest.h
 * The definition of baseclass UnitTest.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include <vector>
#include <string>

/// @class UnitTest
/// The generic baseclass for a testset in JUnit3 style.
class UnitTest
{
	protected:

		/// This defines the "TestCase" pseudo-type.
		typedef void (UnitTest::*TestCase)();

	private:

		const std::string   	name;			// The name of this test (for some user feedback)
		std::vector<TestCase>	testcases;		// The set of registered testcases
		bool                    exceptionExpected;	// The current expect-status
		int		        	    exceptionCount;		// The current number of exceptions seen

	protected:

		/// Add a testcase to the testset.
		/// @param testcase		A method from a derived classs that performs a test.
		///	Such methods should be void and expect no parameters.
		/// 	@note	To add a testcase to the testset you should say:
		///			@code
		///		addTest( static_cast<TestCase>( &MyTest::myTest1 ) );
		///			@endcode
		/// where 'myTest1' is the name of one of the test methods defined
		/// by the derived class.
		/// You can also use the TESTCASE macro instead:
		///			@code
		///		addTest( TESTCASE( MyTest::myTest1 ) );
		///			@endcode
		void	addTest(TestCase testcase) {
			testcases.push_back(testcase);
		}

		/// Tell the testbase we now expect some exception to occur.
		void	expectException()   { exceptionExpected = true; }

		/// Tell the testcase we expect that no exceptions will occur.
		/// This is the default state when a testcase is executed.
		void	expectNoException() { exceptionExpected = false; }


		/// Default version of setUp.
		/// Will be called prior to each testcase
		/// unless overruled by the derived class.
		virtual	void	setUp()	{}

		/// Default version of tearDown.
		/// Will be called after each testcase
		/// unless overruled by the derived class.
		virtual	void	tearDown() {}


		/// Creates an, as yet, empty testset.
		explicit
		UnitTest(const char *name = "UnitTest")
			: name(name), exceptionExpected(false), exceptionCount(0)
		{}

		/// Creates an, as yet, empty testset.
		explicit
		UnitTest(const std::string& name = "UnitTest")
			: name(name), exceptionExpected(false), exceptionCount(0)
		{}

	public:

		/// Runs the test by invoking all registered testcases
		/// in the order they were added to the test set.
		/// @return the number of exceptions seen.
		int	run();

};


/// A macro to use for: addTest( TESTCASE(MyClass::testMethod))
#define TESTCASE(x) static_cast<TestCase>(&x)


// vim:sw=4:ts=4:ai:aw:
#endif	/*__UNITTEST_H*/
