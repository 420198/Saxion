//
// Created by micha on 3/23/2017.
//

#ifndef SOCKETSHIT_MESSAGEDECODERHANDLER_H
#define SOCKETSHIT_MESSAGEDECODERHANDLER_H

#include "../libs/json.hpp"
//#include "../RSAKeys/GenerateKeypair.h"

using nlohmann::json;

#include <iostream>
using namespace std;


class MessageDecoderHandler {
    string message;

public:
    MessageDecoderHandler();

    bool keyRequest(string msg);
    string decodeMessage(string msg);

};


#endif //SOCKETSHIT_MESSAGEDECODERHANDLER_H
