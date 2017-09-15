#include "common.h"		// for: common stuff
#include "asserts.h"    // for: require, check, notreached and ensure
#include "Animal.h"		// for: class Animal
#include "Cage.h"		// for: class Cage
using namespace std;


/** @file Cage.cc
 * The implementation of class Cage
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */


// Construct a cage for the given type of animals
Cage::Cage(const string& kind)
	// TODO
	: kind(kind)
{
	// TODO Test the various preconditions here
	require(!kind.empty());
}

// Called before destroying a cage.
// Any remaining animals within should be destroyed.
Cage::~Cage()
{
	// TODO For each animal in the cage, delete it, to prevent memory leaks.

    map<int,Animal*>::iterator  i;
    for(i = animals.begin() ; i != animals.end() ; ++i) {
        delete i->second;
    }
}


// Add an animal to this cage
// There should not already be an animal with that number
// The type of the animal must match with the type of this cage
void Cage::addAnimal(int number, Animal *animal)
{
	// TODO
	require(animals.count(number) == 0);
    animals.insert(std::pair<int,Animal*>(number,animal));
}


// Locate an animal in this cage (or return nullptr)
Animal    *Cage::getAnimal(int number) const
{
    map<int,Animal*>::const_iterator iter = animals.find(number);
    if(iter != animals.end()){
        return iter->second;
    }else{
        return nullptr;
    }
}


// Remove an animal from this cage and destroy it.
// Removing a non existing animal is forbidden
void    Cage::erase(int number)
{
	// TODO
	require(animals.count(number) > 0);
	animals.erase(number);


}


// Cage output operator (prints both the cage and all animals within)
// Because we are a friend we have access the private attributes of Cage
ostream& operator<<(ostream& os, const Cage& cage)
{
	os << "Cage " << cage.kind << endl;
	// TODO
	// tell each animal within to print itself

    map<int,Animal*>::const_iterator  i;
    for(i = cage.animals.begin() ; i != cage.animals.end() ; ++i) {
        cout <<"\t"<< *i->second<<endl;
    }
	return os;
}

// =====================================
void  Cage::saveFile(ostream& out) const
{
	// Use a const_iterator because this is a const method
	map<int,Animal*>::const_iterator  i;
	for(i = animals.begin() ; i != animals.end() ; ++i) {
		Animal *animal = i->second;
		animal->saveFile(out);		// Let that animal save itself
	}
}


// vim:sw=4:ai:aw:ts=4:
