@echo off
cls
echo ===THIS BAT GOES IN WEB-INF folder===
javac -classpath ".;C:\Archivos de programa\Apache Software Foundation\Tomcat 6.0\lib\servlet-api.jar" -d ../classes %1.java

