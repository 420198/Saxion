//
// Created by micha on 3/27/2017.
//

#ifndef SOCKETSHIT_GENERATEKEYPAIR_H
#define SOCKETSHIT_GENERATEKEYPAIR_H

#include <../cryptopp/rsa.h>
#include <../cryptopp/osrng.h>
#include <../cryptopp/base64.h>
#include <../cryptopp/files.h>
using namespace CryptoPP;


class GenerateKeypair {
public:
    void GenKeyPair();
    void test();
};


#endif //SOCKETSHIT_GENERATEKEYPAIR_H
