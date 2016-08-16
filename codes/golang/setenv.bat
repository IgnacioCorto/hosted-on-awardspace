REM --for: 8g version 6178 release.2010-09-06 release, or up!

set GOBIN=c:\go\bin\
set GOROOT=c:\go\
set GOARCH=386
set GOOS=windows
REM set GOOS = mingw | windows
REM set PATH = %PATH%;%GOBIN%

del hello.8, hello.exe
bin\8g hello.txt
bin\8l -o hello.exe hello.8
hello