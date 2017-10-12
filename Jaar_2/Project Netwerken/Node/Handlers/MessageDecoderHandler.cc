#include "MessageDecoderHandler.h"

MessageDecoderHandler::MessageDecoderHandler() {}

bool MessageDecoderHandler::keyRequest(string msg){
    json j;
    if(j = json::parse(msg)){
        return j["keyrequest"];
    } else{
        std::cout << "hallooooo" << std::endl;
    }

    return j["keyrequest"];
}
