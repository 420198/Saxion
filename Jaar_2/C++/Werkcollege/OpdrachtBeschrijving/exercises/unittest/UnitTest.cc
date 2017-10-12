#include "ansi.h"		// for: ANSI color code strings
#include "asserts.h"	// for: assertion macros
#include <iostream>		// for: cout, cerr, endl
#include <stdexcept>	// for: exception, logic_error, etc


/** @file UnitTest.cc
 * The implementation of class UnitTest
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */


#include "UnitTest.h"


int  UnitTest::run()
{
	exceptionCount = 0;

	// Announce this test run
	std::cout << AC_BLUE "====== Running " << name << AA_RESET << std::endl;

	std::vector<TestCase>::iterator  i;
	int n;
	for (n = 1, i = testcases.begin() ; i != testcases.end() ; ++i, ++n)
	{
		std::cout << AC_BLUE "=== Test " << n << AA_RESET << std::endl;

		// Setup fase (should never fail)
		exceptionExpected = false;
		try {
			setUp();
		} catch(const assert_error& e) {
			std::cerr << AC_BROWN << e.what() << std::endl
				<< AC_RED "FATAL: Assertion exception during setUp!" AA_RESET << std::endl;
			++exceptionCount;
			continue; // skip this test
		} catch(const std::exception& e) {
			std::cerr << AC_BROWN << e.what() << std::endl
				<< AC_RED "FATAL: Exception during setUp!" AA_RESET << std::endl;
			++exceptionCount;
			continue; // skip this test
		} catch(...) {
			std::cerr << AC_RED "FATAL: Unexpected exception during setUp!" AA_RESET << std::endl;
			++exceptionCount;
			continue; // skip this test
		}

		// Test fase (by default expect no exceptions)
		exceptionExpected = false;
		try {
			TestCase fp = *i;
			(this->*fp)();
			if(exceptionExpected) {
				std::cerr << AC_RED "FAIL: EXPECTED AN EXCEPTION BUT THAT DID NOT HAPPEN!" AA_RESET << std::endl;
				++exceptionCount;
			}
		} catch(const assert_error& e) {
			if(exceptionExpected) {		// was expected
				std::cerr << AC_BROWN << e.what() << std::endl
					<< AC_GREEN "GOOD: An expected assertion exception occurred" AA_RESET << std::endl;
			} else {			    // was not expected
				std::cerr << AC_BROWN << e.what() << std::endl
					<< AC_RED "FAIL: UNEXPECTED ASSERTION EXCEPTION!" AA_RESET << std::endl;
				++exceptionCount;
			}
		} catch(const std::exception& e) {
			if(exceptionExpected) {		// was expected
				std::cerr << AC_BROWN << e.what() << std::endl
					<< AC_GREEN "GOOD: An expected exception occurred" AA_RESET << std::endl;
			} else {			    // was not expected
				std::cerr << AC_BROWN << e.what() << std::endl
					<< AC_RED "FAIL: UNEXPECTED EXCEPTION!" AA_RESET << std::endl;
				++exceptionCount;
			}
		} catch(...) {
			if(exceptionExpected) {		// was expected
				std::cerr << AC_GREEN "GOOD: An expected exception occurred" AA_RESET << std::endl;
			} else {			    // was not expected
				std::cerr << AC_RED "FAIL: UNEXPECTED EXCEPTION!" AA_RESET << std::endl;
				++exceptionCount;
			}
		}

		// Teardown fase (should never fail)
		exceptionExpected = false;
		try {
			tearDown();
		} catch(const assert_error& e) {
			std::cerr << AC_BROWN << e.what() << std::endl
				<< AC_RED "FATAL: Assertion exception during tearDown!" AA_RESET << std::endl;
			++exceptionCount;
		} catch(const std::exception& e) {
			std::cerr << AC_BROWN << e.what() << std::endl
				<< AC_RED "FATAL: Exception during tearDown!" AA_RESET << std::endl;
			++exceptionCount;
		} catch(...) {
			std::cerr << AC_RED "FATAL: Unexpected exception during tearDown!" AA_RESET << std::endl;
			++exceptionCount;
		}
	}

	// Report final status
	if(exceptionCount  > 0)
		std::cout << AC_RED "====== Finished " << name << " with "
				<< exceptionCount << " errors." << AA_RESET << std::endl << std::endl;
	else
		std::cout << AC_BLUE "====== Finished " << name << " with "
				<< exceptionCount << " errors." << AA_RESET << std::endl << std::endl;

	return exceptionCount;
}

// vim:sw=4:ts=4:ai:aw:
