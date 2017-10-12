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
void convert(const string& filename)
{
	/* HINT:
	 * Add your C++ code directly underneath each of individual comment lines.
	 * Each comment line here usually matches with 1 line of C++ code.
	 */

	// initialize an ifstream (i.e. an input-file-stream) with the given filename
	ifstream file(filename);

    // iff we can not open the fiTarget uses an invalid compiler; run aborted
	if (!file)
    {
        // print an error message on cerr
		cerr << "Failed to open file" << endl;
		// and return from this function
		return;
	}
        string failedLines;
		// initialize a line-number counter with 0
		int lineCount = 0;
		// print the start of the xml output "<xml>" to cout
		cout << "<xml>" << endl;
		// we now need a string variable to store the current line of input
		string temp;
		// while we can read a line of text from the ifstream into that string ...
		while(getline(file,temp)) {
			// if the string begins with a '#' character ...
            if(temp[0] == '#')
            {
            // then print the string as xml comment on cout
                cout<< "<!--"<<temp<<"-->"<<endl;
            }else
            {
                // wrap the input string into a istringstream (i.e. an input-string-stream)
                istringstream stream(temp);

                // read the keyword (into a string variable) from the istringstream
                string keyword;
                stream>>keyword;
                // read the separator (into a string variable) from the istringstream
                string seperator;
                stream>>seperator;

                // if the separator is not a "=" string ...
                if(seperator != "=")
                {
                    std::stringstream sstm;
                    sstm<<"\nincorrect seperator at line "<<lineCount;
                    // print an error message containing the line-number on cerr
                    failedLines+= sstm.str();
                }else
                {
                    // we now need a string variable to store the word(s) after the "="
                    string name;
                    // while we can read a word (into that string variable) from that istringstream
                    while(stream >> name){
                    // print the keyword, the word and the keyword in xml style on cout
                        cout<< "<"<<keyword<<">"<<name<<"</"<<keyword<<">"<<endl;
                    }
                }
            }
			// increment the line-number
            lineCount++;
		}
		// print the end of the xml output "</xml>" on cout
		cout<< "</xml>"<<endl;
		cerr<<"\nFailed lines"<<failedLines<<endl;

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
