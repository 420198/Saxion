//
//
//
//#include "Test.h"
//#include <string>
//using namespace std;
//#include <../cryptopp/rsa.h>
//#include <../cryptopp/osrng.h>
//#include <../cryptopp/base64.h>
//#include <../cryptopp/files.h>
//using namespace CryptoPP;
//
//#include <iostream>
//#include <stdio.h>
//#include <stdlib.h>
//#include <windows.h>
//#include <conio.h>
//
//int Test::test(int argc, char *argv[]) {
//    printf("Key noise collector");
//    if (argc < 2) {
//        printf("\nGenerates n bytes of noise, where n = # keystrokes you give it");
//        printf("\nUSAGE: keynoise [OUTPUT]");
//        return 0;
//    };
//
//    printf("\nAccessing output...");
//    FILE * output = fopen(argv[1],"wb");
//    if (NULL == output) {
//        printf("\nFile could not be opened for writing");
//        return 0;
//    };
//
//    printf("\nPOUND THEM KEYS\nPress ESC when done");
//    unsigned int sum;
//    unsigned int size = 0;
//    char k = getch();
//    while(k != 27) {
//        sum += k;
//        if (kbhit()) {
//            k = getch();
//            size++;
//            fputc((unsigned char) (sum % 256), output);
//        };
//    };
//    fclose(output);
//    printf("\n%u bytes generated",size);
//    return 0;
//
//}