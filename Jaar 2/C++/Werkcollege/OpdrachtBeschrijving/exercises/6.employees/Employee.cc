#include "asserts.h"    // voor: require, check, notreached en ensure
#include "Animal.h"
#include "Cage.h"
#include "Employee.h"
#include "Manager.h"

using namespace std;


/** @file Employee.cc
 * The implementation of class Employee
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */


Employee::Employee( int number, const string& name, int age)
	:  number(number), name(name), age(age)
{
	require(number >= 0);
	require(!name.empty());
	require(age >= 0);
}

Employee::~Employee()
{
	if(boss != nullptr) {	// Inform your boss
		boss->removeEmployee(this);
		boss = nullptr;
	}
}

// for "ordinary" employees
void Employee::setBoss(Manager *new_boss)
{
	require(new_boss != nullptr);
	require(boss == nullptr);		// should not have a boss yet
	boss = new_boss;
}

// Calculate salary of employee
float Employee::getSalary() const
{
    return 0;
}

void Employee::print(ostream& os) const
{
	os << number << "\t" << name << "\t"
		<< age << "\t" << getSalary() << " euro";
	if(boss != nullptr)
		os << "\tworks for " << boss->number;
}

// output operator
ostream& operator<<(ostream& os, const Employee& employee)
{
	os << employee.number << "\t" << employee.name << "\t"
		<< employee.age << "\t" << employee.getSalary() << " euro";
	if(employee.boss != nullptr)
		os << "\tworks for " << employee.boss->number;
	return os;
}
// vim:sw=4:ai:aw:ts=4: