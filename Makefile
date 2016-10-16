MAINFILE = Main

sourcefiles = $(MAINFILE).java

classfiles = $(sourcefiles:.java=.class)

all : $(classfiles)

%.class : %.java
	javac -d . -classpath . $<

clean:
	rm -f *.class

run:
	java $(MAINFILE)

test:
	perl tests/tester.pl $(MAINFILE)
	# java $(MAINFILE) < tests/input > tests/output
	# diff -b tests/expectedoutput tests/output
