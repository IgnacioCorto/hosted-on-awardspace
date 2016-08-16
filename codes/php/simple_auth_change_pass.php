<?php
session_start();

function read_txt($filename) {
	$fp = fopen($filename,'rt');
	$size = filesize($filename) ;
	if($size && $size>0) $string = fread($fp,$size) ;
	fclose($fp);
	return $string;
}

function write_txt($filename, $string) {
	$fp = fopen($filename,'wt');
	fwrite( $fp,$string );
	fclose($fp);
}

/* Password Reset */
function password_reset(){
    global $data_file;
    
    $login_data 
        = '<?php /*'.PHP_EOL
        . sha1('123456').PHP_EOL
        . sha1('admin').PHP_EOL
        . '*/ ?>' ;
    write_txt($data_file, $login_data);
}

#if($_COOKIE['bypass']=='ignacio') $_SESSION['logged']=true;

$data_file = 'login.dat.php' ;


/* Data */
//$login_data = explode(' ',read_txt($data_file));
$login_data = file($data_file);

define('MASTER_PASS',trim($login_data[1]));
define('MASTER_USER',trim($login_data[2]));


/* Logout */
if( isset($_GET['logout']) ) {
    $_SESSION['logged'] = false ;
    header("location: {$_SERVER['PHP_SELF']}");
}


/* Login */
if(
       sha1($_POST['user'])==MASTER_USER 
    && sha1($_POST['pass'])==MASTER_PASS
) {
    $_SESSION['logged'] = true ;
}


/* Show the Form */
if(!$_SESSION['logged']) {
    ?>
    <form method="post" action="">
        <table>
            <tr>
                <td>Username</td>
                <td><input name="user" value="" type="text" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input name="pass" value="" type="password" /></td>

            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="sent" value="Login" /></td>
            </tr>
        </table>
    </form>
    <?php
    die();
}


/* Change Password */
if(isset($_GET['change'])){
    ?>
    <a href="<?php echo $_SERVER["SCRIPT_NAME"]?>">Volver</a> <br />
    <?php

    if(
           $_SESSION['logged']
        && sha1($_POST['old_pass'])==MASTER_PASS
        && $_POST['new_pass']==$_POST['confirm_pass']
    ) {
        $login_data 
            = '<?php /*'.PHP_EOL
            . sha1($_POST['new_pass']).PHP_EOL
            . MASTER_USER.PHP_EOL
            . '*/ ?>' ;
        write_txt($data_file, $login_data);    
        var_dump($login_data);
        ?>
        Password Actualizado
        <?php
    } else {
        ?>
        <form method="post">
            <table>
                <tr>
                    <td>Contrase&ntilde;a Anterior</td>
                    <td><input name="old_pass" value="" type="password" /></td>
                </tr>
                <tr>
                    <td>Contrase&ntilde;a Nueva</td>
                    <td><input name="new_pass" value="" type="password" /></td>
                </tr>
                <tr>
                    <td>Confirmar Contrase&ntilde;a</td>
                    <td><input name="confirm_pass" value="" type="password" /></td>
                </tr>

                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="sent" value="Cambiar" /></td>
                </tr>
            </table>
        </form>
        <?php
    }
    die;
}

/*
The Simple Auth logic has finished here.
You can end the script here, and use it as an include.
*/

?> 
Bienvenido al Sistema.<br />
Gracias por venir.<br />
<a href='?change'>Cambiar</a> |
<a href='?logout'>Salir</a><br /><br />

