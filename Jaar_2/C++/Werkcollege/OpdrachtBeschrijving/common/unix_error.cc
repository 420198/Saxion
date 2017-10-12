/** @file unix_error.cc
 * The implementation of the functions to throw errors signaled by the unix OS.
 *
 * They wrap the given argument string together with some
 * system error message into std::runtime_error() throwables
 * <br>Also see: std::perror()
 */
// linux hooks
#include <cstring>		// extern char *strerror(int errnum);
#include <cerrno>		// extern int errno;

// c++ hooks
#include <stdexcept>	// std::runtime_error

// our own stuff
#include "ansi.h"		// ansi colorcode strings
#include "unix_error.h"


static // (i.e. only visible in this source file)
// A function to combine the given argument
// with the unix error message that belongs with
// the given errornumber
// into a nice c++ string.
std::string	makeErrorString( const std::string &what_arg, int errornumber )
{
	std::string  s;
	s += AC_RED;
	s += what_arg;
	s += ": ";
	s += strerror(errornumber);
	s += AA_RESET;
	return  s;
}


// Throw a unix system error
void unix_error(const std::string &what_arg)
{
	throw std::runtime_error(makeErrorString(what_arg, errno));
}


// Throw a unix system error
void unix_error(const char *what_arg)
{
	throw std::runtime_error(makeErrorString(what_arg, errno));
}

