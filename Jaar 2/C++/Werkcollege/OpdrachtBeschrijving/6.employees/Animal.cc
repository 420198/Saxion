#include "asserts.h"    // for: require, check, notreached and ensure
#include "Animal.h"		// for: class Animal
using namespace std;

/** @file Animal.cc
 * The implementation of class Animal.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

Animal::Animal(int number, const string& kind, const string& name, int age)
	: number(number), kind(kind), name(name), age(age)
{
	require(number > 0);
	require(!kind.empty());
	require(!name.empty());
	require(age >= 0);
}


/// The animal output operator
std::ostream& operator<<(std::ostream& os, const Animal& a)
{
	// because we are a friend we can access the private attributes
	return os << a.number << "\t" << a.kind
				<< "\t" << a.name << "\t" << a.age;
}


// ====================================
void Animal::saveFile(ostream& out) const
{
	out << "1\t" // action 1=add animal
		<< number << "\t" << kind << "\t" << name << "\t" << age << endl;
}

// vim:sw=4:ai:aw:ts=4:

