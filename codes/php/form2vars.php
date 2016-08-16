<html>
<head>
<title>form2vars</title>
</head>
<body>
    
<?php
//PUT THIS PHP SNIPPET BEFORE ANY FORM
//THEN SUBMIT THE FORM, AND BY THIS
//YOU WILL CREATE VARIABLES FOR EACH FIELD
//AND ALSO BOTH, AN INSERT AND UPDATE QUERY

if(count($_POST)){
    $variables = "### VARIABLES ###  \n";
    $insert = "### INSERT QUERY ### \n\$insert_query = \"INSERT INTO table ( ";
    $values = " ) \n\tVALUES ( ";
    $update = "### UPDATE QUERY ### \n\$update_query = \"UPDATE table SET";
    
    $first = true ;
    foreach ($_POST as $k=>$v){
        if($first) {
            $first = false ;
        } else {
            $update .= ", ";
            $insert .= ", ";
            $values .= ", ";
        }
        $variables .= "\$$k = mysql_escape_string(\$_POST['$k']);\n";
    
        $insert .= "$k";
        $values .= "'\$$k'";
        $update .= "\n\t$k = '\$$k'";
    }
    
    $variables .= "\n";
    $values .= " );\";\n";
    $update .= "\n\tWHERE id = '\$id';\";\n";
    
    echo '<pre>';
    echo $variables ,
        $insert,
        $values,
        "\n".$update;
    echo '</pre>';
    
    echo '<hr />';
}
//END OF SNIPPET!!
?>
   

<form method="post">
Username: <input type="text" name="user" /> <br />
Password: <input type="password" name="pass" /> <br />
<input type="submit" value="Login" />
</form>

</body>
</html>