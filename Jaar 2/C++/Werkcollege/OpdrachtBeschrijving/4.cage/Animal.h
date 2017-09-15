#ifndef	ANIMAL_H
#define	ANIMAL_H 6.1

/** @file Animal.h
 * The definition of class Animal that holds information about an animal.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include <string>       // for: std::string
#include <iostream>     // for: std::ostream


/** @class Animal Animal.h
 * A class to hold information about individual animals.
 */
class Animal
{
		// an output operator to print an animal
		friend std::ostream& operator<<(std::ostream&, const Animal&);

	private:
		// Animal data
		const int		  number;	// Animal number
		const std::string kind;  	// Animal category
		const std::string name;   	// Animal name
		int 			  age;		// Animal age

	public:

		/// The animal constructor
		/// @param  number The unique number of the animal (must be > 0)
		/// @param  kind   The animal category (must be non-empty)
		/// @param  name   The name of the animal (must be non-empty)
		/// @param  age    The age of the animal (must be >= 0)
		Animal(int, const std::string&, const std::string&, int);

		/// Get the animal category
		// (used by: Zoo::addAnimal)
		inline std::string getKind() const {
			return kind;
		}

		/// Does this animal have this number?
		inline bool hasNumber(int a_number) const {
			return (a_number == number);
		}

		// ===============================
		/// Save this animal to a file
		void saveFile(std::ostream& out) const;
};


// vim:sw=4:ai:aw:ts=4:
#endif	/*ANIMAL_H*/
