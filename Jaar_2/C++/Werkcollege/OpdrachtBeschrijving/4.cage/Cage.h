#ifndef	CAGE_H
#define	CAGE_H 6.1

/** @file Cage.h
 * The definition of class Cage that holds animals of a given type.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include <string>   // for: std::string
#include <iostream> // for: std::ostream
#include <map>      // for: std::map<K,V>


// tell compiler Animal is a class
class Animal;


/** @class Cage Cage.h
 * A cage class to hold animals of the same type.
 */
class Cage
{
		// The Cage output operator to print the cage.
		// It also prints any animals within.
		friend std::ostream& operator<<(std::ostream&, const Cage&);

	private:
		const std::string		kind;		// the animal category
		std::map<int,Animal*>	animals;	// the animal container

	public:
		/// Construct a cage for the given type of animals
		/// @param kind    The animal category
		///		@pre kind must be a non-empty string
		Cage(const std::string&);

		/// Called when a cage will be destroyed.
		/// Any animals remaining in the cage should be destroyed
		~Cage();

		/// Return the animal category of this cage
		/// @return The animal category
		inline const std::string&  getKind() const {
			return kind;
		}

		/// Add an animal to this cage
		/// @param  number   The unique number of the animal
		///		@pre That animal number may not already exist in this cage
		/// @param  animal     The animal to be added
		/// 	@pre The type of that animal must match with the type of this cage
		void     addAnimal(int,Animal*);

		/// Lookup an animal in this cage
		/// @param  number  The number of the animal sought
		///		@pre That animal number must be >= 0
		/// @returns nullptr when the animal is not in this cage
		Animal    *getAnimal(int) const;

		/// Remove an animal from this cage and 'destroy' it.
		/// @param  number  The number of the animal to be removed
		///		@pre That animal number must exist in this cage
		void     erase(int);

		/// Tell the number of animals in this cage
		///  (used e.g.to calculate the salary of a animalkeeper)
		inline int      size() const {
			return animals.size();
		}

		// =====================================
		/// Save this cage (and the animals) in a file
		void saveFile(std::ostream& out) const;
};


// vim:sw=4:ai:aw:ts=4:
#endif	/*CAGE_H*/
