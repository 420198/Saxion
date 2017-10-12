#include "asserts.h"    // voor: require, check, notreached en ensure
#include "Animal.h"
#include "Cage.h"
#include "Employee.h"
using namespace std;


/** @file Employee.cc
 * The implementation of class Employee
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */


Employee::Employee(Type kind, int number, const string& name, int age)
	: kind(kind), number(number), name(name), age(age)
{
	require((MANAGER <= kind) && (kind <= KEEPER));
	require(number >= 0);
	require(!name.empty());
	require(age >= 0);

	if(kind == MANAGER) {
		employees = new vector<Employee*>;
		employees->push_back(this); // Also manages himself
	}
}

Employee::~Employee()
{
	if(boss != nullptr) {	// Inform your boss
		boss->removeEmployee(this);
		boss = nullptr;
	}
	delete employees;
}


// for keepers only
void Employee::setCage(Cage *new_cage)
{
	require(new_cage != nullptr);
	require(cage == nullptr);		// already has a cage
	cage = new_cage;
}


// for "ordinary" employees
void Employee::setBoss(Employee *new_boss)
{
	require(new_boss != nullptr);
	require(boss == nullptr);		// should not have a boss yet
	boss = new_boss;
}

// for managers
// Add the given employee to the administrators department
void Employee::addEmployee(Employee *employee)
{
	require(employee!=nullptr);
	require(!employee->hasBoss());
	require(this->isManager());
	// Prevent duplicates
	vector<Employee *>::iterator  i = findEmployee(employee);
	check(i == employees->end());	// employee must not yet exist!
	employees->push_back(employee);
}

// for managers
// Remove the given employee from the administrators department
void Employee::removeEmployee(Employee *employee)
{
	require(employee!=nullptr);
	require(employee->hasBoss(this));
	require(this->isManager());
	vector<Employee *>::iterator  i = findEmployee(employee);
	check(i != employees->end());	// employee must exist!
	employees->erase(i);
}

// for managers
// Internal: Lookup an employee in this administrator's department
vector<Employee*>::iterator Employee::findEmployee(Employee *employee) const
{
	require(employees!=nullptr);
	vector<Employee*>::iterator i;
	for(i = employees->begin(); i != employees->end(); ++i) {
		if(*i == employee)
			return i;
	}
	return employees->end();
}

// Calculate salary of employee
float Employee::getSalary() const
{
	switch(kind) {
	case ADMINISTRATOR:
		return 1000 + age * 50;
	case MANAGER:
		check(employees != nullptr);
		return 5000 + employees->size() * 500; // employee count
	case KEEPER:
		check(cage != nullptr);
		return 2000 + cage->size() * 100; // animal count
	}
	return 0;
}


void Employee::print(ostream& os) const
{
	os << number << "\t" << name << "\t"
		<< age << "\t" << getSalary() << " euro";
	if(boss != nullptr)
		os << "\tworks for " << boss->number;
	if(kind == Employee::MANAGER)
		os << "\thas " << employees->size() << " employees";
	if(kind == Employee::KEEPER)
		os << "\tcage " << cage->getKind();
}


// output operator
ostream& operator<<(ostream& os, const Employee& employee)
{
	os << employee.number << "\t" << employee.name << "\t"
		<< employee.age << "\t" << employee.getSalary() << " euro";
	if(employee.boss != nullptr)
		os << "\tworks for " << employee.boss->number;
	if(employee.kind == Employee::MANAGER)
		os << "\thas " << employee.employees->size() << " employees";
	if(employee.kind == Employee::KEEPER)
		os << "\tcage " << employee.cage->getKind();
	return os;
}


// =====================================
void Employee::saveFile(ostream& out) const
{
	switch(kind) {
	case ADMINISTRATOR:
		out << "3\t2\t" // action 3=employee, kind 2=administrator
			<< number << "\t" << name << "\t" << age
			<< "\t" << boss->number << endl;
		break;
	case MANAGER:
		out << "3\t1\t" // action 3=employee, kind 1=manager
			<< number << "\t" << name << "\t" << age << endl;
		break;
	case KEEPER:
		out << "3\t3\t" // action 3=employee, kind 3=keeper
			<< number << "\t" << name << "\t" << age
			<< "\t" << cage->getKind() << "\t" << boss->number << endl;
		break;
	}
}

// vim:sw=4:ai:aw:ts=4:

