//
// Created by sklar on 1/11/2017.
//
#include "Ticket.h"
#include "asserts.h"

Ticket::Ticket(int credit) : credit(credit)
{
    if(credit<=0){
        throw std::logic_error("Cant order tickets without credit");
    }
}

std::ostream &operator<<(std::ostream &os, const Ticket* ticket) {
    os << "credit: " << ticket->credit;
    return os;
}