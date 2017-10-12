#ifndef	__assert_error_h
#define	__assert_error_h 4.4
/** @file assert_error.h
 * This file defines the assert_error exception class.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 4.4	2016/02/12
 */

#include <stdexcept>	// std::logic_error


/** @class assert_error
 * If an assertion fails an instance of assert_error is thrown.
 */
class assert_error : public std::logic_error
{
public:

	/** Constructs the exception object with what_arg as explanatory
	 * string that can be accessed through what().
	 */
	explicit assert_error(const std::string& what_arg)
				: logic_error(what_arg) {}

	/** Constructs the exception object with what_arg as explanatory
	 * string that can be accessed through what().
	 */
	explicit assert_error(const char* what_arg)
				: logic_error(what_arg) {}

	/**
	 * Constructs the exception object with a message string composed of:
	 *	where the error occured, in which function it happened,
	 *	and what went wrong.
	 */
	assert_error(const char* where, const char* func, const char* what);
};

#endif	/*__assert_error_h*/
// vim:sw=4:ai:aw:ts=4:
