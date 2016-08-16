@echo off

IF EXIST %1.class (
echo ***preparing***
del  %1.class
) 


echo ***compiling***
"C:\Archivos de programa\Java\jdk1.6.0_02\bin\javac.exe"  %1.java


IF ERRORLEVEL 1 (
echo ======================================================
pause
)