//
// Created by sklar on 1/11/2017.
//
#ifndef INC_7_FINALLY_TICKET_H
#define INC_7_FINALLY_TICKET_H

#include <ostream>

class Union;

class Ticket {
    friend class Union;
    friend std::ostream &operator<<(std::ostream &os, const Ticket *ticket);

private:
    int credit;

    Ticket(int credit);
};
#endif //INC_7_FINALLY_TICKET_H