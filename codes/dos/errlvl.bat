@ECHO OFF
SET I=0

:START
SET /A I=I+1
VERIFY>NULL

ECHO ---TESTING---  

IF %I% EQU 10 GOTO END
IF ERRORLEVEL 1 GOTO BAD

ECHO ALL WENT GOOD
GOTO END

:BAD
ECHO THERE WAS AN ERROR
GOTO START

:END
ECHO IT'S OVER ...


