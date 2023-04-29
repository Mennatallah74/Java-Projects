@echo off
javac *.java
ECHO check Normal.arxml
java Main Normal.arxml
ECHO check Empty.arxml
java Main Empty.arxml
ECHO check Empty.c
java Main Empty.c
pause



