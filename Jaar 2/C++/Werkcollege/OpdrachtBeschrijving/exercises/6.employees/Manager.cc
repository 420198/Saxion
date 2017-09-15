//
// Created by sklar on 1/9/2017.
//

#include "Manager.h"
#include "asserts.h"    // voor: require, check, notreached en ensure
#include "Animal.h"
#include "Cage.h"
#include "Employee.h"
using namespace std;

Manager::Manager(int number, const string& name, int age)
: Employee(number,name,age)
, employees( new vector<Employee*> )
{
   // employees = new vector<Employee*>;
    employees->push_back(this); // Also manages himself
}

Manager::~Manager() {
    delete employees;
}

// for managers
// Add the given employee to the managers department
void Manager::addEmployee(Employee *employee)
{
	require(employee!=nullptr);
	require(!employee->hasBoss());

	// Prevent duplicates
	vector<Employee *>::iterator  i = findEmployee(employee);
	check(i == employees->end());	// employee must not yet exist!
	employees->push_back(employee);
}

// for managers
// Remove the given employee from the managers department
void Manager::removeEmployee(Employee *employee)
{
	require(employee!=nullptr);
	require(employee->hasBoss(this));
	vector<Employee *>::iterator  i = findEmployee(employee);
	check(i != employees->end());	// employee must exist!
	employees->erase(i);
}

// for managers
// Internal: Lookup an employee in this a manager's department
vector<Employee*>::iterator Manager::findEmployee(Employee *employee) const
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
float Manager::getSalary() const
{
    check(employees != nullptr);
    return 5000 + employees->size() * 500; // employee count
}

void Manager::print(ostream& os) const
{
	os << number << "\t" << name << "\t"
    << age << "\t" << getSalary() << " euro";
    os << "\thas " << employees->size() << " employees";
}

// =====================================
void Employee::saveFile(ostream& out) const
{
    out << "3\t1\t" // action 3=employee, kind 1=manager
    << number << "\t" << name << "\t" << age << endl;
}

// output operator
ostream& operator<<(ostream& os, const Manager& employee)
{
	os << employee.number << "\t" << employee.name << "\t"
       << employee.age << "\t" << employee.getSalary() << " euro";
    os << "\thas " << employee.employees->size() << " employees";
	return os;
}
