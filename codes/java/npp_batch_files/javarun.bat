@echo off


if exist %1.class (
  echo *** borrando .class ***
  del %1.class
)

echo *** compilando .java ***
javac %1.java

if exist %1.class (
   echo *** ejecutando .class ***
   java %1
) 

pause
