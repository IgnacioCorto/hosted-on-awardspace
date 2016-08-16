#!C:\xampp\perl\bin\perl.exe -w

##########################
##### ENVIRONMENT ########
##########################


$seclist{'Environment'}.='CONTENT_LENGTH : <b>'.$ENV{CONTENT_LENGTH}."</b><br />";
$seclist{'Environment'}.='HTTP_REFERER : <b>'.$ENV{HTTP_REFERER}."</b><br />";
$seclist{'Environment'}.='HTTP_USER_AGENT : <b>'.$ENV{HTTP_USER_AGENT}."</b><br />";
$seclist{'Environment'}.='QUERY_STRING : <b>'.$ENV{QUERY_STRING}."</b><br />";
$seclist{'Environment'}.='REMOTE_ADDR : <b>'.$ENV{REMOTE_ADDR}."</b><br />";
$seclist{'Environment'}.='REMOTE_HOST : <b>'.$ENV{REMOTE_HOST}."</b><br />";
$seclist{'Environment'}.='SERVER_NAME : <b>'.$ENV{SERVER_NAME}."</b><br />";



##########################
##### DIRECTORIES ########
##########################

$dirtoget=".";
opendir(IMD, $dirtoget) || die("Cannot open directory");
@thefiles= readdir(IMD);
closedir(IMD);

foreach $f (@thefiles) {
 unless ($f=~/^\./) { 
  $seclist{'Directories'} .= "$f<br />";
 }
}


##########################
###### FILES I/O #########
##########################

# -e -z -s   -r -w -x   -T -B

$archivo_a_borrar='Copia de psword.txt';
if(-e $archivo_a_borrar)  # existe
	{$fe='Presente'} 
	else {$fe='No Existe'}
$seclist{'Files I/O'}.="$fe --> ";
unlink($archivo_a_borrar);
$seclist{'Files I/O'}.="File <b>$archivo_a_borrar</b> unlinked.<br /><br />";

$seclist{'Files I/O'}.='<i><u>The lines that add <b>username password</b> is commented
to avoid duplicated records.</u></i><br />';

#use Fcntl qw(:flock :seek); 
open(DAT, '>>psword.txt') || die("Could not open file!");
#Shared Exclusive Non-Blocking Unlock
flock(DAT, LOCK_EX); #LOCK_SH LOCK_EX LOCK_NB LOCK_UN
#Bytes Offset, Beginnig Current End
seek(DAT, 0, SEEK_SET); #SEEK_SET SEEK_CUR SEEK_END 
#print DAT "username password\n" ;  # Commented to avoid Duplicates
close(DAT); 

$data_file="wrestledata.txt";

$seclist{'Files I/O'}.='<i><u>The lines that add <b>Randy Orton</b> are commented
to avoid duplicated records.</u></i><br /><br />';
# open(DAT,">>$data_file") || die("Cannot Open File");
# print DAT "Randy Orton|Boo|RKO\n"; 
# close(DAT); 

open(DAT, $data_file) || die("Could not open file!");
@raw_data=<DAT>;
close(DAT); 

foreach $wrestler (@raw_data)
{
 chomp($wrestler);
 ($w_name,$crowd_re,$fav_move)=split(/\|/,$wrestler);
 $seclist{'Files I/O'} .= 
 "When <b>$w_name</b> is in the ring, 
  the crowd might <b>$crowd_re</b> 
  when the <b>$fav_move</b> is used.<br />\n";
}

##########################
##### ASSOCIATIVES #######
##########################

$assoc{'pleito_de_hoy_y_ahora'} = 'con ely' ;
delete($assoc{'pleito_de_hoy_y_ahora'});


%pleitos = ( 1 , 'dinero' , 2 , 'sexo' , 3 , 'programacion' ) ;
@arPleitos = %pleitos ;
$seclist{'Associative'} .= "Associative List: <b>@arPleitos</b> <br />" ;
$data = length($pleitos{2}) ;
$seclist{'Associative'} .= "Length of sexo: <b>$data</b> <br />" ;
$data = substr($pleitos{2},1,2) ;
$seclist{'Associative'} .= "Letters 2 & 3: <b>$data</b> <br />" ;


##########################
######## ARRAYS ##########
##########################

@numbers = (0,1,2);
$seclist{'Arrays'} .= "Number List: <b>@numbers</b> <br />" ;
$numbers[3] = 3 ;
$seclist{'Arrays'} .= "A 3 added: <b>@numbers</b> <br /><br />" ;
splice(@numbers,2,2) ;
$seclist{'Arrays'} .= "spliced (remove) 2 and 3: <b>@numbers</b> <br />" ;
splice(@numbers,2,3,2,3,4) ;
$seclist{'Arrays'} .= "spliced (added) 2, 3 and 4: <b>@numbers</b> <br /><br />" ;

$a = shift(@numbers) ;
$seclist{'Arrays'} .= "shift the array: <b>@numbers</b> <br />" ;
unshift(@numbers,$a) ;
$seclist{'Arrays'} .= "unshift it back: <b>@numbers</b> <br />" ;
$a = pop(@numbers) ;
$seclist{'Arrays'} .= "pop: <b>@numbers</b> <br />" ;
push(@numbers,$a) ;
$seclist{'Arrays'} .= "push: <b>@numbers</b> <br />" ;
$seclist{'Arrays'} .= "<b>unshift/shift</b> adds to <b>lower</b> indexes<br />" ;
$seclist{'Arrays'} .= "<b>push/pop</b> adds to <b>higher</b> indexes<br /><br />" ;

@letters = ('c');
$letters[1] = 'b';
splice(@letters,2,1,'a');
chomp(@letters);
$seclist{'Arrays'} .= "Letter List: <b>@letters</b> <br />" ;
sub ascend{$a gt $b} ### AN ASCENDING SORT
@letters = sort(ascend @letters);
$seclist{'Arrays'} .= "Sorted with function: <b>@letters</b> $cics $lets <br />" ;
@letters = reverse(@letters);
$seclist{'Arrays'} .= "Reversed: <b>@letters</b> <br />" ;
@letters = sort(@letters);
$seclist{'Arrays'} .= "Sorted Normal: <b>@letters</b> <br /><br />" ;

$data_string = join('--',@letters);
$seclist{'Arrays'} .= "join: <b>$data_string</b> <br />" ;
@data_array = split(/--/,$data_string);
$seclist{'Arrays'} .= "split: <b>@data_array</b> <br />" ;



##########################
######### BASIC ##########
##########################

$divlist='';
$i=0;
unless($i>10) { $seclist{'Basic'}.="<div>unless #$i (crei que era un bucle)</div>"; $i++;}

##########################
########## HTML ##########
##########################

$variable = 'Esto es una variable';

print <<HEADER;
Content-type: text/html

	<html>
	<head>
	<title>WOW, QUE BUENO</title>
	</head>
	<body>
HEADER


foreach $secciones (keys %seclist) {
print <<CONTENT;
	<fieldset>
	<legend>$secciones</legend>
	$seclist{$secciones}
	</fieldset>
	<br />
CONTENT
}

print <<FOOTER;
	<fieldset>
	<legend>Inicio</legend>
	<h1>Acabo de escribir una pagina web con perl!</h1>
	<h2>$variable</h2>
	$divlist
	</fieldset>

	</body>
	</html>
FOOTER


