#include "asserts.h"		// for: require(expr)
#include "Person.h"			// for: definition of class Person
using namespace std;

/** @file Person.cc
 * The implementation of class Person
 * @version 6.1	2016/10/17
 */

Person::Person(const string& name, Year born, Gender gender)
// TODO - Initialize attributes here
    : name(name),born(born),gender(gender)
{
    // TODO - Check any preconditions here
    require(!name.empty());
    //pre-conditions
}

int	Person::ageInYear(Year year)
{
    return year-born; // TODO - return the right value
}
// vim:sw=4:ts=4:ai:aw:
