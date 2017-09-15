//
// Created by sklar on 1/11/2017.
//

#ifndef INC_7_FINALLY_UNION_H
#define INC_7_FINALLY_UNION_H

#include <list>
#include <ostream>
#include <set>
#include "Ticket.h"

class Union {
    friend std::ostream &operator<<(std::ostream &os, const Union &anUnion);

private:
    std::set<Ticket *> tickets;

    Union();

    ~Union();

public:
    Union(const Union &) = delete;   /// i.e. forbidden to use
    /// analoog operator=

    static Union *getUnion();

    void createTickets(int n, int credit = 100);

    const std::set<Ticket *> &getTickets() const;

    bool ticketValid(Ticket *ticket);
};

#endif //INC_7_FINALLY_UNION_H