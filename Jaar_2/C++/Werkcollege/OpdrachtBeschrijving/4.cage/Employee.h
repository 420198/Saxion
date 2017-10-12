#ifndef	EMPLOYEE_H
#define	EMPLOYEE_H 6.1

/** @file Employee.h
 * The class Employee describes an employee.
 *
 * @author R.A.Akkersdijk@saxion.nl
 * @version 6.1 2016/10/17
 */

#include <string>   // voor: std::string
#include <vector>   // voor: std::vector<T>
#include <iostream> // voor: std::ostream


// tell compiler Cage is a class
class Cage;


/** @class Employee Employee.h
 * A class to describe employees of the zoo.
 */
class Employee
{
		// an output operator to print employees
		friend std::ostream& operator<<(std::ostream&, const Employee&);

	public:

		/** @enum Type
		 * Employee type codes (non-zero)
		 * Note: Also used in Main.cc
		 */
		enum Type {
			MANAGER = 1,		///< the code for a manager
			ADMINISTRATOR,	    ///< the code for an administrator
			KEEPER			    ///< the code for an animalkeeper
		};

	private:

		// Personal data
		const Type	 		kind;
		const int		    number;
		const std::string	name;
		int				    age;

		// All ordinary employees 
		Employee			*boss = nullptr;			// works for ...

		// Keepers only
		Cage			    *cage = nullptr;			// feeds animals in ...

		// Managers only
		std::vector<Employee*>	*employees = nullptr;	// including self

	public:

		/// Construct an employee
		/// @param kind		The employee type
		/// @param number	The unique employee number
		///		@pre the employee number must be >= 0
		/// @param name		The employee's name
		///		@pre the employee name must be non-empty
		/// @param age		The employee's age
		///		@pre the employee age must be >= 0
		Employee(Type,int,const std::string&,int);

		/// Delete an employee (and tell your Manager you're gone away)
		~Employee();

		/// Get this employee's number
		/// @return the employee's number
		inline int getNumber() const {
			return number;
		}

		/// Get this employee's type
		/// @return the employee's typecode
		inline Type getKind() const {
			return kind;
		}

		/// Does this employee have the given employee number?
		inline bool hasNumber(int a_number) const {
			return (a_number == number);
		}

		/// Is this employee a manager?
		inline bool isManager() const {
			return kind == MANAGER;
		}
		/// Is this employee an administrator?
		inline bool isAdmin() const {
			return kind == ADMINISTRATOR;
		}
		/// Is this employee an animalkeeper?
		inline bool isKeeper() const {
			return kind == KEEPER;
		}

		/// Assign a cage to this animalkeeper
		void setCage(Cage*);

		/// Assign the given manager to this employee
		void setBoss(Employee*);

		/// Does this employee has the given manager as boss?
		bool hasBoss(Employee *a_boss) const {
			return a_boss == boss;
		}

		/// Does this employee have a manager?
		bool hasBoss() const {
			return boss != nullptr;
		}

		/// Add the given employee to the administrators department
		void addEmployee(Employee*);

		/// Remove the given employee from the administrators department
		void removeEmployee(Employee*);

	private:

		/// Internal: Lookup an employee in this administrator's department
		std::vector<Employee*>::iterator  findEmployee(Employee*) const;

	public:

		/// Calculate the salary of this employee
		float getSalary() const;

		/// Print this employee to the ostream
		void print(std::ostream&) const;

		// =====================================
		/// Save this employee to a file
		void saveFile(std::ostream&) const;
};


// vim:sw=4:ai:aw:ts=4:
#endif	/*EMPLOYEE_H*/
