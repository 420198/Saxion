cmake_minimum_required(VERSION 3.6)
project(Node)

set(CMAKE_CXX_STANDARD 11)
link_libraries(ws2_32 wsock32)
include_directories("cryptopp/")
file(GLOB Dir1_Sources RELATIVE "cryptopp/" "*.cpp")
set(SOURCE_FILES UdpEcho/server.cpp UdpEcho/server.h libs/json.hpp Handlers/MessageDecoderHandler.h Handlers/MessageDecoderHandler.cc
        libs/mingw.mutex.h RSAKeys/Test.h RSAKeys/Test.cc)
add_executable(socketShit ${SOURCE_FILES} ${Dir1_Sources})