@echo off
cls
echo ===THIS BAT GOES IN WEB-INF folder===
set JSPPATH=C:\Archivos de programa\Apache Software Foundation\Tomcat 6.0\lib\
javac -classpath ".;%JSPPATH%servlet-api.jar;%JSPPATH%jsp-api.jar" -d ../classes %1.java

