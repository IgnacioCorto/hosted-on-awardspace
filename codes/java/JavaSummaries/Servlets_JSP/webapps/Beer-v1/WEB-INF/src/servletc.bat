@echo off
cls
echo ===THIS BAT GOES IN WEB-INF folder===
echo ===CHECK THE ".;" IN -classpath===
echo.
javac -d ../classes -classpath ".;C:\Archivos de programa\Apache Software Foundation\Tomcat 6.0\lib\servlet-api.jar" -Xlint:unchecked %1.java

