@echo off
echo ===local backup===
"C:\Archivos de programa\CWRSYNC\bin\rsync.exe" -avr  rsync://user@127.0.0.1/module/  /cygdrive/c/backup/  --password-file=password.txt
pause

rem (1) "../rsync.exe" %*
rem (2) chmod 0600 password.txt
rem (3) rsync ... < password.txt
