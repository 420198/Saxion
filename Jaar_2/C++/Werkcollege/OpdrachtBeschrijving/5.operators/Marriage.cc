#include "asserts.h"		// for: require(), etc.
#include "Person.h"			// definition of class Person
#include "Marriage.h"		// definition of class Marriage
#include <iostream>


/** @file Marriage.cc
 * The implementation of class Marriage
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1	2016/10/17
 */


Marriage::Marriage(Person *person1, Person *person2, int inyear)
	// TODO - Initialize attributes here
	:male(person1),female(person2),year(inyear)
{
	// TODO - Check any preconditions here
	require(person1->ageInYear(2016) >17);
	require(person2->ageInYear(2016) >17);
}

Marriage::~Marriage()
{
	// TODO - Do we really have to do anything here?
}

void Marriage::addChild(Person *new_child)
{
	// TODO - Check pre-conditions & update
	require(new_child != nullptr);
	if(!child){
        child = new_child;
    }
}

Person	*Marriage::getChild()
{
    std::cout<<child;
    if(child){
        return child;
    }else{
        return nullptr;
    }
}

std::ostream& operator<<(std::ostream& os, const Marriage& a){
    if(a.child){
        return os << " married "<<a.year<<": "<<*a.male<<" + "<<*a.female
                            <<" & "<<*a.child;
    }else{
        return os << " married "<<a.year<<": "<<*a.male<<" + "<<*a.female;
    }
}

bool operator<(const Marriage& a,const Marriage& b){
    return a.year < b.year;
}
// vim:sw=4:ts=4:ai:aw:
