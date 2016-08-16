set bbdrive=/cygdrive/j/BlackBerry/music/
set hdddrive=/cygdrive/d/ignacio/music/

"C:\Archivos de programa\ICW\Bin\rsync.exe" -avr %hdddrive% %bbdrive% --exclude-from=bb_exclude.txt
"C:\Archivos de programa\ICW\Bin\rsync.exe" -avr %bbdrive% %hdddrive% --exclude-from=bb_exclude.txt

pause