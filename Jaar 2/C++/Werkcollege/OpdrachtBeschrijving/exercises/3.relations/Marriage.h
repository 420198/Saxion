#ifndef	__MARRIAGE_H
#define	__MARRIAGE_H 6.1

/** @file Marriage.h
 * The definition of class Marriage
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

// Tell the compiler 'Person' is a class
class	Person;


/// @class Marriage
/// Holds some information about marriages between people.
class Marriage
{
	private:

		// TODO - define attributes

	public:

		/// Create a marriage between two persons in the given year.
		Marriage(Person*,Person*,int);

		/// Called just before an object is destroyed ...
		~Marriage();

		/// Add a child to this marriage
		/// @note There can only be one child!
		void	addChild(Person*);

		/// Tell the child of this marriage
		/// @return	the child or a nullptr
		Person	*getChild();

};


// vim:sw=4:ts=4:ai:aw:
#endif	/*__MARRIAGE_H*/
