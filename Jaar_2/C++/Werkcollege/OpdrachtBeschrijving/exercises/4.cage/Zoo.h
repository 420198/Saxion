#ifndef	ZOO_H
#define	ZOO_H 6.1

/** @file Zoo.h
 * The class Zoo that administrates a zoo.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include <string>		// for: std::string
#include <map>			// for: std::map<K,V>
#include <vector>		// for: std::vector<T>


// tell compiler about classes
class Animal;
class Cage;
class Employee;


/** @class Zoo Zoo.h
 * A class to administrate a zoo.
 */
class Zoo
{
		// a, trivial, output operator to print a zoo
		friend
		inline std::ostream& operator<<(std::ostream& os, const Zoo& z) {
			return os << z.name;
		}

	private:

		// the name of this zoo
		const std::string				name;

		// the collection of cages containing animals
		// (the cages are created on demand)
		std::map<std::string,Cage*>		cages; // kind,cage

		// list of reuseable animal numbers
		std::vector<int>				free_animal_numbers;

		// highest animal number ever
		int								highest_animal_number = 0;

		// all employees
		std::map<int, Employee*>		employees; // number,employee

		// list of reuseable employee numbers
		std::vector<int>				free_employee_numbers;

		// highest employee number ever
		int				                highest_employee_number = 0;

	public:

		/// Zoo constructor, expects a, non-empty, name for the zoo.
		/// @param name	The name of the zoo.
		Zoo(const std::string&);

		/// Destructor cleans up everything
		~Zoo();

		/// Get the name of the zoo.
		const std::string& getName() const { return name; }

		// ---------------------
		/// @return a free animal number
		int getFreeAnimalNumber();

		/// Add the given animal with the given animal number to the zoo.
		/// @param number	The number of the animal
		/// @param animal	The animal to add
		void addAnimal(int,Animal*);

		/// Find the cage for animals of the given type.
		/// A new cage will be created if needed.
		/// @param kind	The animal category of the cage sought
		Cage *findCage(const std::string&);

		/// Remove the animal with the given animal number from the zoo.
		/// @param number	The animal number
		void removeAnimal(int);

		/// Print a list of all cages and the animals within.
		void printCages() const;

		// ---------------------

		/// @return a free employee number.
		int getFreeEmployeeNumber();

		/// Is the employee with the given number a manager?
		/// @param number	The number of the employee
		bool isManager(int) const;

		/// Add the given employee with the given employee number to the zoo.
		/// @param number	The employee number
		/// @param employee	The employee
		void addEmployee(int,Employee*);

		/// Link the given employee to a manager with the given employeenumber and vice versa.
		/// @param number	The employee number of the manager
		/// @param employee	The employee to be added to the department of the manager.
		void linkToManager(int,Employee*);

		/// List all managers
		void printManagers() const;

		/// Remove an employee.
		/// @param number	The employee number of the employee.
		void removeEmployee(int);

		/// List of all employees
		void printEmployees() const;

		/// Tell the total salary of all employees together
		void salaryCosts() const;

		// ===========================================================
		/// Save the zoo data in file.
		void saveFile(std::ostream& out) const;
};


// vim:sw=4:ai:aw:ts=4:
#endif	/*ZOO_H*/
