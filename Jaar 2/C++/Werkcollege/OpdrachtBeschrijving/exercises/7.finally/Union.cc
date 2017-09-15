//
// Created by sklar on 1/11/217.
//
#include "Union.h"
#include <stdexcept>
#include <iostream>
#include <algorithm>

using namespace std;

Union::Union() {}

Union *Union::getUnion() {
    static Union anUnion;
    return &anUnion;
}

void Union::createTickets(int n = 1, int credit) {
    for (int i = 0; i < n; i++) {
        try {
            Ticket *ticket = new Ticket(credit);
            tickets.insert(ticket);
        } catch (const logic_error &e) {
            cerr << "error: " << e.what() << endl;
        }
    }
}

const std::set<Ticket *> &Union::getTickets() const {
    return tickets;
}

std::ostream &operator<<(std::ostream &os, const Union &anUnion) {
    for (Ticket *ticket : anUnion.getTickets()) {
        os << ticket;
    }
    return os;
}

bool Union::ticketValid(Ticket *ticket) {
    if (tickets.count(ticket) != 0 && ticket->credit >= 100) {
        ticket->credit -= 100;
        return true;
    } else {
        if (ticket->credit == 0) {
            delete ticket;
            throw std::logic_error("Ticket has no money left and has been removed!");
        }
        return false;
    }
}

Union::~Union() {
    for (Ticket *p : tickets) {
        delete p;
    }
}
