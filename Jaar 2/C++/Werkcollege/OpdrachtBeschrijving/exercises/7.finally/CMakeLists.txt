cmake_minimum_required(VERSION 3.6)
project(7_finally)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
    ansi.h
    assert_error.cc
    assert_error.h
    asserts.h
    common.h
    main.cc
    where.h Union.cc Union.h Ticket.cc Ticket.h)

add_executable(7_finally ${SOURCE_FILES})