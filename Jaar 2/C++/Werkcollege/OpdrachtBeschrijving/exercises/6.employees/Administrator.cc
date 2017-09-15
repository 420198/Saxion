#include "asserts.h"    // voor: require, check, notreached en ensure
#include "Administrator.h"
#include "Manager.h"
using namespace std;

Administrator::Administrator(int number, const std::string& name, int age)
:Employee(number,name,age)
{
}


// Calculate salary of employee
float Administrator::getSalary() const
{
    return 1000 + age * 50;
}


// =====================================
void Administrator::saveFile(ostream& out) const
{
    out << "3\t2\t" // action 3=employee, kind 2=administrator
    << number << "\t" << name << "\t" << age
    << "\t" << boss->getNumber() << endl;
}
