//
// Created by sklar on 1/9/2017.
//

#ifndef UNTITLED1_KEEPER_H
#define UNTITLED1_KEEPER_H

#include "Employee.h"
#include <string>   // voor: std::string
#include <vector>   // voor: std::vector<T>
#include <iostream> // voor: std::ostream

// tell compiler Cage is a class
class Cage;
class Keeper : public Employee {
		friend std::ostream& operator<<(std::ostream&, const Keeper&);

public:
     Keeper(int number, const std::string& name, int age);

    ~Keeper();
    /// Assign a cage to this animalkeeper
    void setCage(Cage*);

    /// Calculate the salary of this employee
    float getSalary() const;

    /// Print this employee to the ostream
    void print(std::ostream&) const;

    // =====================================
    /// Save this employee to a file
    void saveFile(std::ostream&) const;
protected:

private:
		// Keepers only
		Cage *cage = nullptr;			// feeds animals in ...
};


#endif //UNTITLED1_KEEPER_H
