//
// Created by sklar on 1/9/2017.
//

#ifndef UNTITLED1_MANAGER_H
#define UNTITLED1_MANAGER_H


#include <string>   // voor: std::string
#include <vector>   // voor: std::vector<T>
#include <iostream> // voor: std::ostream
#include "Employee.h"

class Manager : public Employee
{
    // an output operator to print employees
    friend std::ostream& operator<<(std::ostream&, const Manager&);


public:
    Manager(int number, const std::string& name, int age);

    ~Manager();

    // Add the given employee to the managers department
    void addEmployee(Employee*);

    /// Remove the given employee from the managers department
    void removeEmployee(Employee*);


	/// Calculate the salary of this employee
    float getSalary() const;

    /// Print this employee to the ostream
    void print(std::ostream&) const;

private:
    // Managers only
    std::vector<Employee*>	*employees = nullptr;	// including selfprivate:

    /// Internal: Lookup an employee in this managers department
    std::vector<Employee*>::iterator  findEmployee(Employee*) const;
};


#endif //UNTITLED1_MANAGER_H
