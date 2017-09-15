#include "Zoo.h"
#include "Animal.h"		// for: class Animal
#include "Cage.h"		// for: class Cage
#include "Employee.h"	// for: class Employee
#include "asserts.h"    // for: require, check, notreached and ensure
using namespace std;

/** @file Zoo.cc
 * The implementation of class Zoo.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 1.5	2014/10/18
 */


Zoo::Zoo(const string& name)
	: name(name)
{
	require(!name.empty());
}

Zoo::~Zoo()
{
	// Delete all cages
	for (map<string,Cage*>::iterator i = cages.begin();
									 i != cages.end(); ++i)
	{
		delete i->second;
	}

	// Delete all ordinary employees ...
	for (map<int,Employee*>::iterator i = employees.begin();
					i != employees.end(); ++i)
	{
		Employee *employee = i->second;
		if (!employee->isManager()) {
			delete  employee;
			i->second = 0;	// prevent dangling pointer
		}
	}
	// ... and now the managers
	for (map<int,Employee*>::iterator i = employees.begin();
					i != employees.end(); ++i)
	{
		Employee *employee = i->second;
		if (employee) {
			delete  employee;
		}
	}
}

// ---------------------

// Find a free aninal number
int Zoo::getFreeAnimalNumber()
{
	int number = 0;
	// any free numbers?
	if(free_animal_numbers.empty()) {   // no, none
		number = ++highest_animal_number;     // invent a new one
	} else {
		// take last number from the list (cheap)
		number = free_animal_numbers.back();    // fetch last
		free_animal_numbers.pop_back();         // and remove it
	}
	return number;
}

// Add a new animal to some cage
void Zoo::addAnimal(int number, Animal *animal)
{
	require(animal != nullptr);
	require(animal->hasNumber(number));
	if(number > highest_animal_number)            // higher number?
		highest_animal_number = number;           // update bookkeeping
	Cage *cage = findCage(animal->getKind());    // find that cage
	check(cage != nullptr);						// sanitycheck
	cage->addAnimal(number, animal);		        // add animal to cage
}// addAnimal

// Find/Make a cage for some kind of animal
Cage *Zoo::findCage(const string& kind)
{
	require(kind != "");
	Cage *cage = nullptr;
	map<string,Cage*>::iterator  i = cages.find(kind);
	if(i == cages.end()) {							// does not exist
		cage = new Cage(kind);						// make new cage
		//cages.insert(pair<string,Cage*>(kind, cage));
		//cages.insert(make_pair(kind, cage));
		cages[kind] = cage;
	} else {
		cage = i->second;					// found it
	}
	return cage;
}// zoekCage

// Remove an animal
void Zoo::removeAnimal(int number)
{
	map<string,Cage*>::iterator  i;
	// For all cages ...
	for(i = cages.begin() ; i != cages.end() ; ++i) {  // zoek de cage op
		Cage *cage = i->second;
		Animal *animal = cage->getAnimal(number);			// look for animal in cage
		if(animal) {  // if found in that cage
			cage->erase(number); // remove that animal
			free_animal_numbers.push_back(number); // register free number
			return;
		}
	}
	cerr << "Animal " << number << " not found" << endl;
}// removeAnimal

// List of all cages and animals
void Zoo::printCages() const
{
	cout << "All cages:" << endl;
	if(cages.empty())
		cout << "\tno cages yet" << endl;
	else {
		map<string,Cage*>::const_iterator  i;
		for(i = cages.begin() ; i != cages.end() ; ++i) {
			cout << *i->second; // use << operator for Cage
		}
	}
}// printCages

// ---------------------

// Find a free employee number
int Zoo::getFreeEmployeeNumber()
{
	int number = 0;
	if(free_employee_numbers.empty()) {  // non available?
		number = ++highest_employee_number; // generate a new one
	} else {
		// use last from list
		number = free_employee_numbers.back();
		free_employee_numbers.pop_back();
	}
	return number;
}


bool Zoo::isManager(int number) const
{
	map<int,Employee*>::const_iterator i = employees.find(number);
	check(i != employees.end());	// has to exist!
	Employee *employee = i->second;
	check(employee != nullptr);
	return (employee->isManager());
}


// Add Employee (like addAnimal)
void Zoo::addEmployee(int number, Employee *employee)
{
	require(employee != nullptr);
	require(employee->hasNumber(number));
	require(employees.count(number)==0);	// no duplicates
	if(number > highest_employee_number)
		highest_employee_number = number;
	employees[number] = employee;
}// addEmployee

// Link an employee to a manager
void Zoo::linkToManager(int number, Employee *employee)
{
	require(employee != nullptr);
	map<int,Employee*>::iterator i = employees.find(number);
	check(i != employees.end());		// Does he exist?
	Employee *manager = i->second;
	check(manager != nullptr);
	check(manager->isManager());
	manager->addEmployee(employee);
	employee->setBoss(manager);
}// linkToManager

// Show all managers
void Zoo::printManagers() const
{
	map<int,Employee*>::const_iterator i;
	for(i = employees.begin() ; i != employees.end() ;  ++i) {
		Employee *employee = i->second;
		if(employee->isManager()) {
			cout << (*employee) << endl;
		}
	}
}// printManagers

// Remove an employee
void Zoo::removeEmployee(int number)
{
	map<int,Employee*>::iterator i = employees.find(number);
	if(i != employees.end()) {
		Employee *employee =  i->second;
		employees.erase(i);
		free_employee_numbers.push_back(number); // nummer vrijgeven
		cout << "Employee:" << (*employee) << " removed" << endl;
		delete employee;	// he will tell his manager
	} else {
		cerr << "Employee " << number << " not found" << endl;
	}
}// removeEmployee

// Print all employees
void Zoo::printEmployees() const
{
	cout << "All employees" << endl;
	if(employees.empty())
		cout << "\tnone yet" << endl;
	else {
		cout << "number\tname\tage\tsalary\t\tnotes" << endl;
		map<int,Employee*>::const_iterator i;
		for(i = employees.begin() ; i != employees.end() ; ++i) {
			Employee *employee = i->second;
			employee->print(cout);
			cout << endl;
		}
	}
}// printEmployees

// Tell total salary costs
void Zoo::salaryCosts() const
{
	cout << "Total salary costs are ";
	if(employees.empty())
		cout << "nothing yet" << endl;
	else {
		int salary = 0;
		map<int,Employee*>::const_iterator i;
		for(i = employees.begin() ; i != employees.end() ; ++i) {
			Employee *employee = i->second;
			salary += employee->getSalary();
		}
		cout << salary << " euro" << endl;
	}
}// salaryCosts

// ===========================================================
// Safe all information
void Zoo::saveFile(ostream& out) const
{
	// All cages
	map<string,Cage*>::const_iterator k;
	for(k = cages.begin() ; k != cages.end() ; ++k) {
		Cage *cage = k->second;
		cage->saveFile(out);
	}

	// All employees
	map<int,Employee*>::const_iterator i;
	for(i = employees.begin() ; i != employees.end() ; ++i) {
		Employee *employee = i->second;
		employee->saveFile(out);
	}
}// saveFile

// vim:sw=4:ai:aw:ts=4:

