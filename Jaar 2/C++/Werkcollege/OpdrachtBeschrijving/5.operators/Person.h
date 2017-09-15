#ifndef	__PERSON_H
#define	__PERSON_H 6.1

/** @file Person.h
 * The definition of class Person
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */

#include <string>		// for: std::string
#include <iostream>

/// @class Person
/// Holds some information about people.
class Person
{
    friend std::ostream& operator<<(std::ostream&,const Person& );
    friend bool operator<(const Person&,const Person& );

	public:

		/// Cosmetic sugar: year of birth
		typedef int	Year;

		/// @enum Gender
		/// Define the constants for a persons gender.
		enum Gender { MALE, FEMALE };
		// The constants can be used as:
		// Person::MALE en Person::FEMALE
	private:

		// TODO - define attributes
		const std::string
		 name;
		Year born;
		Gender gender;

	public:
		/// Create a person with the given name, birthyear and gender.
		Person(const std::string&,Year,Gender);

		/// Returns the age of this person in the given year
		int  ageInYear(Year);


};

std::ostream& operator << (std::ostream&,
                        Person::Gender&);

// vim:sw=4:ts=4:ai:aw:
#endif	/*__PERSON_H*/
