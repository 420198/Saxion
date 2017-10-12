#include <iostream>
#include "Union.h"
#include <stdexcept>

using namespace std;

// This is just an empty file
// Everything else is up to you
int main() {
    Union *anUnion = Union::getUnion();

    for (int i = 0; i < 10; i++) {
        anUnion->createTickets(1, 200);
    }
    cout << anUnion->getTickets().size() << " tickets have been created" << endl;

    for (int i = 0; i < 10; i++) {
        anUnion->createTickets(1, 0);
    }

    for (Ticket* ticket : anUnion->getTickets()) {
        for (int i = 0; i < 3; i++) {
            try{
                anUnion->ticketValid(ticket);
                cout << "Entered zoo" << endl;
            } catch (const std::logic_error &e) {
                cerr << "error: " << e.what() << endl;
            }
        }
    }
    return 0;
};