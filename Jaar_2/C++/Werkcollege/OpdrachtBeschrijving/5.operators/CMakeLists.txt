cmake_minimum_required(VERSION 3.6)
project(5_operators)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
    ansi.h
    assert_error.cc
    assert_error.h
    asserts.h
    common.h
    main.cc
    Marriage.cc
    Marriage.h
    Person.cc
    Person.h
    TestLess.cc
    TestLess.h
    TestPrint.cc
    TestPrint.h
    UnitTest.cc
    UnitTest.h
    where.h)

add_executable(5_operators ${SOURCE_FILES})