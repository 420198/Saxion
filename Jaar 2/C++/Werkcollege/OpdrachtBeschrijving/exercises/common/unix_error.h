#ifndef UNIX_ERROR_H
#define UNIX_ERROR_H 1

#include <string>		// std::string

/** @file unix_error.h
 * Declarations for two functions that throw errors signaled by the unix OS.
 *
 * When somewhere in your program a systemcall fails,
 * e.g. you can not open a file,
 * the reason is explained as a code in the global 'errno' variable.
 * These functions take that code, convert it to some human readable string,
 * add the given argument as a prefix and then throw a "std::runtime_error".
 * <br>Also see: std::strerror() and std::perror()
 *
 * An example:
@code
try {
	ifstream  inputfile("some_filename");
	if (!inputfile)					// failed to open?
		unix_error("inputfile");	// report a problem
	// ... more code ...
}
catch(const unix_error& e) {
	cerr << "Oops: " << e.what() << endl;
}
@endcode
 *
 */


/// Throw a unix system error with some additional text
/// @param what_arg	additional text
/// @throw	std::runtime_error
extern void unix_error(const std::string& what_arg);

/// Throw a unix system error with some additional text
/// @param what_arg	additional text
/// @throw	std::runtime_error
extern void unix_error(const char *what_arg);

#endif // UNIX_ERROR_H
