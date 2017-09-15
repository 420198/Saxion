// For now you may ignore all these #include lines
// They will be explained in a later lecture
#include <iostream>	// for: std::cout and std::cerr
#include <fstream>	// for: std::ifstream
#include <sstream>	// for: std::stringstream
#include <string>	// for: std::string, std::getline()
#include <cstring>	// for: std::strerror()
#include <cerrno>	// for: errno
#include <cstdlib>	// for: EXIT_SUCCESS, EXIT_FAILURE
#include "ansi.h"	// for: ansi color code strings
using namespace std;	// so we don't have to add the std:: scope all the time


/** @file main.cc
 * This file contains the function you have to complete.
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */


/** @fn void  convert(const string& filename)
 * This is the function you have to complete.
 * @param filename The name of the file to be converted
 */
void	convert(const string& filename)
{
	/* HINT:
	 * Add your C++ code directly underneath each of individual comment lines.
	 * Each comment line here usually matches with 1 line of C++ code.
	 */

	// initialize an ifstream (i.e. an input-file-stream) with the given filename
    // iff we can not open the file for some reason ...
        // print an error message on cerr
		// and return from this function
    // initialize a line-number counter with 0
    // print the start of the xml output "<xml>" to cout
	// we now need a string variable to store the current line of input
    // while we can read a line of text from the ifstream into that string ...
        // increment the line-number
        // if the string begins with a '#' character ...
			// then print the string as xml comment on cout
			// and 'continue' with the next input line
		// wrap the input string into a istringstream (i.e. an input-string-stream)
		// read the keyword (into a string variable) from the istringstream
		// read the separator (into a string variable) from the istringstream
		// if the separator is not a "=" string ...
			// print an error message containing the line-number on cerr
			// and 'continue' with the next input line
		// we now need a string variable to store the word(s) after the "="
		// while we can read a word (into that string variable) from that istringstream
			// print the keyword, the word and the keyword in xml style on cout
    // print the end of the xml output "</xml>" on cout
    // close the ifstream (optional action, leaving this function does the same)
}


/**
 * The main function of this program
 * passes the given filenames one by one
 * to the convert function.
 */
int main(int argc, const char *argv[])
{
	cout << "** Hello xml world! **" << endl;
	if (argc == 1) {
		cerr << "Usage: " << argv[0] << " file_names\n";
	}

    // for all arguments do
    for (int i = 1 ; i < argc ; ++i) {
		// Note: The AC_BLUE and similar strings alter the color
		// 		of the output (but only iff supported on your platform)
        cout << AC_BLUE "CONVERTING file " << argv[i] << AA_RESET << endl;
        convert( argv[i] );
        cout << AC_BLUE "CONVERSION done" AA_RESET << endl;
    }

    return EXIT_SUCCESS;
}

// vim:sw=4:ts=4:ai:aw:
