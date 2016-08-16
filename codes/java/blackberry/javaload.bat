@echo off
pushd "C:\Ignacio\software\eclipse\plugins\net.rim.ejde\vmTools"
javaloader load %1
popd
pause