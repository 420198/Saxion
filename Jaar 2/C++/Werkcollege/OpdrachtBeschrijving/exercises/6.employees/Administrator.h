#ifndef ADMINISTRATOR_H
#define ADMINISTRATOR_H

#include "Employee.h"

class Administrator : public Employee {
    //friend std::ostream &operator<<(std::ostream &, const Administrator &);

public:
    Administrator(int number, const std::string &name, int age);

    /// Calculate the salary of this employee
    float getSalary() const;

    // =====================================
    /// Save this employee to a file
    void saveFile(std::ostream &) const;


protected:

private:
};

#endif // ADMINISTRATOR_H