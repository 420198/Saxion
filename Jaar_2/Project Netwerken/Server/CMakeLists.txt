cmake_minimum_required(VERSION 3.6)
project(Server)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/basic_types.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/cpprest_compat.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/fileio.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/http_helpers.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/http_server.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/http_server_api.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/http_server_asio.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/http_server_httpsys.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/nosal.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/resource.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/SafeInt3.hpp
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/uri_parser.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/web_utilities.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/details/x509_cert_utilities.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/astreambuf.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/asyncrt_utils.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/base_uri.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/containerstream.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/filestream.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/http_client.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/http_headers.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/http_listener.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/http_msg.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/interopstream.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/json.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/oauth1.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/oauth2.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/producerconsumerstream.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/rawptrstream.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/streams.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/uri.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/uri_builder.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/version.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/ws_client.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/cpprest/ws_msg.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplx.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxcancellation_token.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxconv.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxinterface.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxlinux.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxtasks.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/pplxwin.h
    packages/cpprestsdk.v140.windesktop.msvcstl.dyn.rt-dyn.2.9.1/build/native/include/pplx/threadpool.h
        Server/Source.cpp
        )

add_executable(Server ${SOURCE_FILES})