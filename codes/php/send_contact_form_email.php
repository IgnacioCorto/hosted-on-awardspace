<?php
/*$para  = "";*/
$asunto = "Mensaje de Contacto...";
$mensaje =
	'<h2>Mensaje de Contacto</h2>
	<div><b>Nombre:</b> '.$_POST['nombre'].'</div>
	<div><b>E-mail:</b> '.$_POST['email'].'</div>
	<div><b>Tel&eacute;fono:</b> '.$_POST['telefono'].'</div>
	<div><b>Mensaje:</b> '.$_POST['mensaje'].'</div>
	<p>Generador</p>
	<p>Creador</p>';

$cabeceras  = "MIME-Version: 1.0\r\n"
			. "Content-type: text/html; charset=UTF-8\r\n"
			. "To: Dummy Email <dummy@email.com>\r\n"
			. "From: Dummy Email <dummy@email.com>\r\n"
			. "Reply-To: Dummy Email <dummy@email.com>\r\n"
			. "X-Mailer: Microsoft Office Outlook, Build 11.0.5510\r\n"
			;

mail($para, $asunto, $mensaje, $cabeceras );
header ("location: sender.php?confirmation");