#!C:\xampp\perl\bin\perl.exe -w
#C:\xampp\htdocs\cgi-bin\index.cgi
print "Content-type: text/plain\n\n";

print "\n\n============================= (4) ASSOCIATIVE ARRAYS ==============================\n\n";

%minombre = (
'pn','Luis',
'sn','Ignacio',
'pa','Cortorreal',
'sa','De La Cruz'
);

@arreglo = %minombre ;

print "\n 2do. Nombre: $minombre{'sn'}  (usan llaves) ";
print "\n Array: ".@arreglo.'-'.$#arreglo." --> @arreglo ";

print "\n keys: "; foreach $keys(keys %minombre){ print "$keys ";}
print "\n values: "; foreach $values(values %minombre){ print "$values ";}

print "\n You are called -$ENV{'USER'}- and you are ";
print "using display -$ENV{'DISPLAY'}-\n";

$cadena = "Ignacio" ;
sub HolaMundo {	print "\n Hola Mundo @_"; }
sub mySqrt { $_[0]**.5; }
sub Alterar { local($cadena); $cadena = "De La Cruz"; }

$numero = 36 ;
&HolaMundo('Ignacio','IwbRMaP');
print "\n Raiz de $numero: ".&mySqrt($numero);
print "\n Alterar: ".&Alterar($numero);
print "\n Cadena: ".$cadena." -- retenida al usar local() " ;

print "\n\n============================= (3) REGULAR EXPRESSIONS =============================\n\n";

$_ = "The quick brown fox";
if(/\bThe/)
	{print "Exitoso\n\n";}
else 
	{print "Fallido\n\n";}
	
$_ = "lOndOn loNdoN " ;
$lond = 'lond';
s/(${lond}on)/\1:london/gi;
print  $_." -- ".$1."\n";
tr/lond/1096/;
print  'Transtation: '.$_."\n";


$_ = "Lord Whopper of Fibbing \n";
print "\nText: ".$_;
print "RegExp: /pp/ \n";
/pp/;
print "Before: $` \nDuring: $& \nAfter: $'";

$_ = "Capes:Geoff::Shot putter:::Big Avenue";
@personal = split(/:+/);
print "\nSplit any :'s --> @personal".@personal;
$_ = $personal[1];
@letters = split(//);
print "\nSplit of Letters --> @letters";
print "\nMany Ignacios: "."Ignacio, "x12;

$ignacio = "ignacio\n";
chop($ignacio);
print "\nChopped: -".$ignacio.'-';
print "\nsubstr: -".substr($ignacio,2,5).'-';

print "\n\n============================= (2) FILES + CONDITIONS ==============================\n\n";

$file = 'psword.txt';		# Name the file
open(INFO, $file);		# Open the file
@lines = <INFO>;		# Read it into an array
close(INFO);			# Close the file

foreach $line (@lines) {
	print ++$i.": $line";
}
$age = 26;
if ($age != 18) { print "\nNo tengo 18 años!!!\n" }


print "\n\n=================================== (1) ARRAYS ===================================\n\n";

$raizcubica27 = 27 ** (1/3) ;
$minombre = 'Ignacio';
$miapellido = "De La Cruz";
@nombre = ('Luis','Ignacio','Cortorreal','De La Cruz');

print pop(@nombre)."\n";

print "Interpolacion: $raizcubica27 $minombre $miapellido \n";
print "Ultimo Apellido: $nombre[3] \n";
print "@nombre" . " \n";

print @nombre . " \n";	# By itself
print $#nombre . " \n";	# By itself
print "@nombre" . " \n";	# Embedded in double quotes
print @nombre."" . " \n";	# In a scalar context

