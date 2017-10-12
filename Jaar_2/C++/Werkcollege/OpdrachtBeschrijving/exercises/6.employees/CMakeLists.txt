cmake_minimum_required(VERSION 3.6)
project(6_employees)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
    Administrator.cc
    Administrator.h
    Animal.cc
    Animal.h
    ansi.h
    assert_error.cc
    assert_error.h
    asserts.h
    Cage.cc
    Cage.h
    common.h
    Employee.cc
    Employee.h
    Keeper.cc
    Keeper.h
    Main.cc
    Manager.cc
    Manager.h
    where.h
    Zoo.cc
    Zoo.h)

add_executable(6_employees ${SOURCE_FILES})