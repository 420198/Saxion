# ------------------------------------------------
#  Deze makefile gaat er van uit dat het programma
#  uit alle .c and .cc source files bestaat.
# ------------------------------------------------
# VARIABELEN
# ----------

# Hieronder zonodig aanpassen naar behoefte
# Waar zitten eventuele extra .h files voor het programma ...
INCDIR	=
# ... en waar zitten eventuele extra libraries
LIBDIR	=

# -------------------------------------------
# Hieronder hoef je zelden iets aan te passen
# -------------------------------------------
# Vertel make welke compiler en welke C++ versie we willen gebruiken
CCC=g++ -std=c++11
CXX=g++ -std=c++11
CC =g++ -std=c++11

# Dit laat make zelf de sources uitzoeken op basis van de filenamen
HEADERS		:= $(wildcard *.h)
SOURCE.c	:= $(wildcard *.c)
SOURCE.cc	:= $(wildcard *.cc)
SOURCE.cpp	:= $(wildcard *.cpp)

# make bedenkt zo zelf de namen van de .o files
OBJECTS	= $(SOURCE.c:.c=.o) $(SOURCE.cc:.cc=.o) $(SOURCE.cpp:.cpp=.o)

# idem, maak een lijst van alle sources
SOURCES	= $(SOURCE.c) $(SOURCE.cc) $(SOURCE.cpp)

# het te maken programma heet 'main'
PROGRAM	:= main

# Laat de compiler (zo nodig) ook de extra .h files vinden
#CPPFLAGS += -I$(INCDIR)
# en zet de warnings aan
CPPFLAGS += -Wmain -Wall -Wextra -fexceptions
# En, optioneel, extra debugging informatie toevoegen
CPPFLAGS += -g
# NB de -g optie zorgt voor extra informatie
# 	 voor de gdb / ddd debuggers.

# Welke bibliotheken hebben we nodig (en van waar)
#LDLIBS	= -L$(LIBDIR) -lxxx -lyyy

# ---------------------------------------------------------------
# misschien nodig voor oudere make versies
## Regels zodat make ook weet hoe je van .cc of .cpp naar .o komt
#.SUFFIXES	: .o .cc .cpp
#.cc.o	:
#	$(COMPILE.cc) $<
#.cpp.o	:
#	$(COMPILE.cpp) $<
# ---------------------------------------------------------------
# DOELEN
# ------

# Het hoofdoel is alle programma's
MAIN	: main

# Hoe maak je 'main'
main	: $(OBJECTS)
	$(LINK.cc) -o $@ $(OBJECTS) $(LDLIBS)

# Bepaal de onderlinge afhankelijkheden van de files.
_deps	: $(HEADERS) $(SOURCES)
	$(CXX) -MM $(CPPFLAGS) $(SOURCES) > _deps
include _deps

# Hou opruiming
clean		:
	-rm -f main *.o _deps
realclean	:
	-rm -rf main *.o _deps bin/ obj/
pristine	:
	-rm -rf main *.o *.depend *.layout_deps bin/ obj/ docs rtf

# Maak de doxygen files
docs	: doxyfile ../common/doxydefault docs/index.html opdracht.dox $(HEADERS) $(SOURCES)
	doxygen
docs/index.html	:
