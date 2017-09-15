//
// Created by sklar on 1/9/2017.
//
#include "asserts.h"    // voor: require, check, notreached en ensure
#include "Animal.h"
#include "Cage.h"
#include "Keeper.h"
#include "Manager.h"
using namespace std;


Keeper::Keeper(int number, const string& name, int age)
: Employee(number,name,age)
{

}
Keeper::~Keeper(){
    delete cage;
}

// for keepers only
void Keeper::setCage(Cage *new_cage)
{
	require(new_cage != nullptr);
	require(cage == nullptr);		// already has a cage
	cage = new_cage;
}

// Calculate salary of employee
float Keeper::getSalary() const
{
    check(cage != nullptr);
    return 2000 + cage->size() * 100; // animal count
}

void Keeper::print(ostream& os) const
{
    Employee::print(os);
    os << "\tcage " << cage->getKind();
}

// output operator
ostream& operator<<(ostream& os, const Keeper& employee)
{
    os << static_cast<const Employee&>(employee);
    os << "\tcage " << employee.cage->getKind();
    return os;
}

// =====================================
void Keeper::saveFile(ostream& out) const
{
    out << "3\t3\t" // action 3=employee, kind 3=keeper
    << number << "\t" << name << "\t" << age
    << "\t" << cage->getKind() << "\t" << boss->getNumber() << endl;
}
