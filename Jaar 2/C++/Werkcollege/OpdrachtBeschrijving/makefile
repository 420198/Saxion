#
#	@(#)makefile	2.0	AKK/ACT
#
DIRS:=$(dir $(sort $(wildcard */makefile)))

# make: tell targets
help:
	@echo "The make targets are:"
	@echo "  make docs - regenerate doxygen docs"
	@echo "  make programs - compile & link all programs"
	@echo "  make clean - remove object files and programs"
	@echo "  make realclean - also remove codeblocks directories"
	@echo "  make pristine - also remove doxygen docs"
	@echo "They operate on subdirs:" $(DIRS)


# make programs: compile all programs
programs:
	for dir in $(DIRS) ; do cd $$dir ; $(MAKE) ; cd .. ; done

# make docs: generate doxygen code
docs:
	for dir in $(DIRS) ; do cd $$dir ; $(MAKE) docs ; cd .. ; done

# make clean: remove .o and executables
clean:
	for dir in $(DIRS) ; do cd $$dir ; $(MAKE) clean ; cd .. ; done

# make realclean: also remove the codeblocks dirs
realclean:
	for dir in $(DIRS) ; do cd $$dir ; $(MAKE) realclean ; cd .. ; done

# make pristine: also remove the doxygen docs
pristine:
	for dir in $(DIRS) ; do cd $$dir ; $(MAKE) pristine ; cd .. ; done
