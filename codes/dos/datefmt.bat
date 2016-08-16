@echo off
:: file = makenew.bat
::
:: description = this batch file uses current date and time to create a file with a unique filename

::
:: Date         Author    Change/Update
:: 04-Jun-2005  AGButler  Original
::
 
:: set variables
set tdtd=none
set ttrn=none

 
:: get the date and time and then into single variable
for /F "tokens=1-4 delims=/ " %%i in ('date /t') do set tdtd=%%k%%j%%i
for /F "tokens=1-8 delims=:. " %%i in ('time /t') do set ttrn=%%i%%j%%k%%l
set tufn=%tdtd%_%ttrn%.txt
 
:: now create the file
type NUL>%tufn%
 
:EOF
