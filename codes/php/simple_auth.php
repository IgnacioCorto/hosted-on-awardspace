<?php
session_start();

/* Data */
define('MASTER_USER','millionaire');
define('MASTER_PASS','millonario');


/* Logout */
if( isset($_GET['logout']) ) {
    $_SESSION['logged'] = false ;
    header("location: {$_SERVER['PHP_SELF']}");
}


/* Login */
if($_POST['user']==MASTER_USER && $_POST['pass']==MASTER_PASS) {
    $_SESSION['logged'] = true ;
}


/* Show the Form */
if(!$_SESSION['logged']) {
    echo <<<EOT
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

EOT;
    die();
}

/*
The Simple Auth logic has finished here.
You can end the script here, and use it as an include.
*/

echo "Bienvenido al Sistema.<br />
      Gracias por venir.<br /><br />
      <a href='?logout'>Salir</a><br />";
