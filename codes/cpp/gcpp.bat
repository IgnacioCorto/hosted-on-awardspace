@echo off
REM ***** ESTE ARCHIVO BORRA: a.exe *****

IF EXIST a.exe DEL a.exe
D:\ignacio\apps\devcpp\bin\g++ %1 %2 %3 %4 %5 %6 %7 %8 %9
IF %ERRORLEVEL% NEQ 0 (
  ECHO.
  ECHO COMPILER ERROR: Diablo! Que vaina ma' jevi!
)
IF EXIST a.exe a
IF EXIST a.exe DEL a.exe