/** @file Main.cc
 * The implementation of the command and control functions.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */
//
// ===============================================================
//       IN PRINCIPE HOEF JE IN DEZE FILE NIETS TE VERANDEREN
//    TENZIJ JE NIEUWE CLASSES TOEVOEGT OF BESTAANDE VERWIJDERT
// ===============================================================
//
#include <iostream>     // for: std::cin, std::cout, std::cerr
#include <fstream>      // for: std::ostream
#include <string>       // for: std::string
#include <cstdlib>      // for: EXIT_FAILURE, EXIT_SUCCESS
#include "Zoo.h"		// for: class Zoo
#include "Employee.h"	// for: class Employee
#include "Animal.h"		// for: class Animal
#include "ansi.h"       // for: ansi color codes
#include "asserts.h"    // for: require, check, notreached and ensure
using namespace std;


// For color coded feedback (iff supported no your platform)
const char *c_on  = AC_BLUE;        // color on (blue)
const char *c_err = AC_RED;         // color on (red)
const char *c_off = AA_RESET;       // color off (black)

// --------------------------------------------------------------------

// Dit programma kan ook snel gegevens inlezen uit een file
// en ze daar later ook weer in opbergen;
// - File 'dierentuin.txt' bevat correcte informatie
// (maar misschien dat die niet correct verwerkt wordt)
// - File 'foutetuin.txt' bevat strijdige informatie
// (die de dierentuin nu nog ten onrechte accepteert)
//
// Welke by default gebruikt wordt kan je hier kiezen:
const char *savefile = "good.txt";
//const char *savefile = "bad.txt";
// Je kan de name ook via de argumentenlijst door geven.
//
// PS Er zijn ook nog twee "reserve" versies van die files
// voor het geval dat je de originele per ongeluk met foute
// informatie overschrijft.

// -------------------
// forward declaraties
// About animals
void addAnimal(Zoo*);
void removeAnimal(Zoo*);
// About employees
void addEmployee(Zoo*);
void removeEmployee(Zoo*);
// Internal
static // = alleen zichtbaar in deze source file
void linkToManager(Zoo*,Employee*);
// Save all data to a file.
void saveFile(Zoo*);
// Load saved data from a file.
void loadFile(Zoo*);


int  main(int argc, const char *argv[])
{
#if	!defined(__unix__)
	try {   // On MS-Windows you have to catch various exceptions yourself.
#endif
		// Is er een SaveFile naam argument meegegeven ?
		if(argc > 1)
			savefile = argv[1];

		// Maak de dierentuin
		Zoo *zoo = new Zoo("Artis");
		cout << c_on << "Welcome to " << zoo->getName() << c_off << endl;

		bool stop = false;
		while(!stop) {
			// List all choices
			cout << c_on << "\nSelect action:" << endl;
			cout << "  1\tadd animal" << endl;
			cout << "  2\tremove animal" << endl;
			cout << "  3\tadd employee" << endl;
			cout << "  4\tremove employee" << endl;
			cout << "  5\tshow cages" << endl;
			cout << "  6\tshow employees" << endl;
			cout << "  7\tsalary costs" << endl;
			cout << "  8\tload zoo" << endl;
			cout << "  9\tsave zoo" << endl;
			cout << "  0\tstop program" << c_off << endl;

			// Ask use for choice
			cout << c_on << "Your choice: " << c_off << flush;
			int  choice = 0;	cin >> choice;

			// Do action
			switch(choice) {
			case 0: stop = true; break;
				// interactive actions
			case 1: addAnimal(zoo); break;
			case 2: removeAnimal(zoo); break;
			case 3: addEmployee(zoo); break;
			case 4: removeEmployee(zoo); break;
				// procedures
			case 5: zoo->printCages(); break;
			case 6: zoo->printEmployees(); break;
			case 7: zoo->salaryCosts(); break;
				// special actions
			case 8: loadFile(zoo); break;
			case 9: saveFile(zoo); break;
				// and finaly
			default: cerr << c_err << "Bad choice" << c_off << endl; break;
			}// end actions
		}// end while

		delete zoo;

#if	!defined(__unix__)
	} catch(const std::logic_error& e) {   // Handle the most specific class first
		cerr << c_err << e.what() << c_off << endl;
		return EXIT_FAILURE;
	} catch(const std::exception& e) {     // Any left-over exception types
		cerr << c_err << e.what() << c_off << endl;
		return EXIT_FAILURE;
	} catch(...) {     						// Anything left-over
		cerr << c_err << "Unexpected exception occurred!" << c_off << endl;
		return EXIT_FAILURE;
	}
#endif
	cout << c_on << "Goodbye!" << c_off << endl;
	return EXIT_SUCCESS;
}


// -------------------

void addAnimal(Zoo *zoo)
{
	require(zoo != nullptr);

	cout << c_on << "Tell kind, the name and the age of the animal: " << c_off << flush;
	string kind;	cin >> kind;
	string name;	cin >> name;
	int age;
	do {
		cin >> age;
		if(age < 0) {
			cerr << c_err << "Illegal age!" << endl;
			cout << c_on << "give age: " << c_off << flush;
		}
	} while(age < 0);

	int number = zoo->getFreeAnimalNumber();
	zoo->addAnimal(number, new Animal(number, kind, name, age));
}// addAnimal


void removeAnimal(Zoo *zoo)
{
	require(zoo != nullptr);

	cout << c_on << "number: " << c_off << flush;
	int number;	cin >> number;

	zoo->removeAnimal(number);
}// removeAnimal

// -------------------

void addEmployee(Zoo *zoo)
{
	require(zoo != nullptr);

	// What kind of employee?
	cout << c_on << "Tell category "
				 	"[1=manager,2=administrator,3=keeper]: " << c_off << flush;
	int category;
	do {
		cin >> category;
		if((category < Employee::MANAGER) || (category > Employee::KEEPER)) {
			cerr << c_err << "Bad category!" << c_off << endl;
			cout << c_on << "category: " << c_off << flush;
		}
	} while((category < Employee::MANAGER) || (category > Employee::KEEPER));

	// General employee data
	cout << c_on << "Tell name and age of employee: " << c_off << flush;
	string name;	cin >> name;

	int age;
	do {
		cin >> age;
		if(age < 0) {
			cerr << c_err << "Bad age!" << endl;
			cout << c_on << "age: " << c_off << flush;
		}
	} while(age < 0);

	// get an employee number
	int number = zoo->getFreeEmployeeNumber();

	// make the employee
	Employee *employee = nullptr;
	switch(category)
	{

	case Employee::MANAGER:
		employee = new Employee(Employee::MANAGER, number, name, age);
		break;

	case Employee::ADMINISTRATOR:
		employee = new Employee(Employee::ADMINISTRATOR, number, name, age);
		linkToManager(zoo, employee);
		break;

	case Employee::KEEPER:
		// need more information
		cout << c_on << "what kind of animal: " << c_off << flush;
		string kind;	cin >> kind;
		Cage *cage = zoo->findCage(kind);
		//
		employee = new Employee(Employee::KEEPER, number, name, age);
		employee->setCage(cage);
		linkToManager(zoo, employee);
		break;
	}
	// ... and add to zoo
	zoo->addEmployee(number, employee);
}// addEmployee

// internal support.
static // = only visible in this file
void linkToManager(Zoo *zoo, Employee *employee)
{
	require(zoo != nullptr);
	require(employee != nullptr);

	cout << c_on << "For which manager does he work? " << c_off << endl;
	zoo->printManagers();

	int number = 0;
	cout << c_on << "manager number: " << c_off << flush;
	do {
		cin >> number;
		if((number < 0) || (!zoo->isManager(number))) {
			cerr << c_err << "Invalid number" << c_off << endl;
			cout << c_on << "manager number: " << c_off << flush;
		}
	} while(number <= 0);

	zoo->linkToManager(number, employee);
}// linkToManager


void removeEmployee(Zoo *zoo)
{
	require(zoo != nullptr);

	cout << c_on << "employee number: " << c_off << flush;
	int number;	cin >> number;

	zoo->removeEmployee(number);
}// removeEmployee



// ======================================================
// De code hieronder kan een complete dierentuin opbergen
// of weer inlezen van een file.
// Dan hoef je niet steeds alles opnieuw in te voeren.
// Caveat: Deze code gelooft alles, dus als de savefile
// fouten bevat dan zal de dierentuin ook fouten bevatten.

// Save all data to a file.
void saveFile(Zoo *zoo)
{
	require(zoo != nullptr);

	ofstream  out(savefile); // open output file
	if(!out) {
		cerr << c_err << "Oops, cannot open " << savefile << c_off << endl;
		return;
	}
	cout << c_on << "Saving to " << savefile << c_off << endl;

	zoo->saveFile(out);
	out << "0" << endl;
	out.close();

}// saveFile


// Load saved data from a file.
// Het eerste getal op een regel vertelt de actie (codes net zoals in het menu)
// 1=dier toevoegen, 3=employee toevoegen, 0=klaar
// (zie verder de diverse invoerprocedures)
void loadFile(Zoo *zoo)
{
	require(zoo != 0);

	ifstream  in(savefile);  // open de input file
	if(!in) {
		cerr << c_err << "File " << savefile << " not found" << c_off << endl;
		return;
	}
	cout << "Loading from " << savefile << endl;

	// While not yet EOF
	while(!in.eof())
	{
		// Read action code
		int action = -1;		in >> action;
		switch(action)
		{
		case 0: // Finished
			return;

		case 1: { // 1=add animal
				// read animal data
				int number = 0;		in >> number;
				string kind;		in >> kind;
				string name;		in >> name;
				int age = 0;		in >> age;
				zoo->addAnimal(number, new Animal(number, kind, name, age));
			}
			break; // 1=add animal

		case 3: { // 3=add employee
				// read employee data
				int category = 0;	in >> category;
				int number = 0;		in >> number;
				string name;		in >> name;
				int age = 0;		in >> age;
				Employee *employee = 0;
				switch(category)
				{
				case Employee::MANAGER: { // 1=make Manager
						employee = new Employee(Employee::MANAGER, number, name, age);
					}
					break;

				case Employee::ADMINISTRATOR: { // 2=make administrator
						employee = new Employee(Employee::ADMINISTRATOR, number, name, age);
						// get number of boss
						int boss = 0;	in >> boss;
						zoo->linkToManager(boss, employee);
					}
					break;

				case Employee::KEEPER: { // 3=make keeper
						employee = new Employee(Employee::KEEPER, number, name, age);
						// read animal kind
						string kind;	in >> kind;
						Cage *cage = zoo->findCage(kind);
						employee->setCage(cage);
						// get number of boss
						int boss = 0;	in >> boss;
						zoo->linkToManager(boss, employee);
					}
					break;

				default: // eh?
					cerr << c_err << "Bogus category " << category << "!" << c_off << endl;
					return;

				} // einde: category
				zoo->addEmployee(number, employee);
			}
			break; // end: add employee

		default: // eh?
			cerr << c_err << "Bogus action " << action << "!" << c_off << endl;
			return;
		} // einde: action
	} // einde: while input
} // einde: loadFile

// vim:sw=4:ai:aw:ts=4:

