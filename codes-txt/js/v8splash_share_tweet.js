function compartirTestV8Twitter() {
	
	var width  = 575,
		height = 400,
		left   = ($(window).width()  - width)  / 2,
		top    = ($(window).height() - height) / 2,
		url    = 'http://twitter.com/home?status=He+tomado+el+Test+de+%40V8SplashRD+y+mi+resultado+fue%3A+'
			   + $('.testv8_resultado .datos_resultado:visible h2.titulo').html()
			   + '%3B+%C2%BFC%C3%BAal+ser%C3%A1+el+tuyo%3F+' + encodeURIComponent(CI_Base_Url+'index.php/welcome/home'),
		opts   = 'status=1' +
				 ',width='  + width  +
				 ',height=' + height +
				 ',top='    + top    +
				 ',left='   + left;

	window.open(url, 'twitte', opts);

	return false;
	  
}



function compartirTestV8Facebook() {
	//alert('here');
	
	var imagen_url = CI_Base_Url+'assets/images/';


	if($.cookie('v8splash_bando')=='femenino'){
		imagen_url += 'fb_testv8_femenino.jpg' ; 
	} else {
		imagen_url += 'fb_testv8_masculino.jpg' ; 
	}
	

	FB.init({appId: '174461909230617', status: true, cookie: true, xfbml: true});
	
	FB.ui(
	{
		method: 'stream.publish',
		message: 'He tomado el Test V8 Splash',
		attachment: {
			name: 'Mi Test V8 Splash',
			caption: '{*actor*} ha tomado es Test V8 su resultado dice que es: ' + $('.testv8_resultado .datos_resultado:visible h2.titulo').html()
				+ '; ' + $('.testv8_resultado .datos_resultado:visible p.descripcion').html(),
			'media': [{
				'type': 'image',
				'src': imagen_url, 
				'href': CI_Base_Url + "index.php/welcome/home#anchor_crear_v8splash" } 
			],
			href: CI_Base_Url + "index.php/welcome/home#anchor_crear_v8splash" 
			},
			action_links: [
				{ text: 'V8 Splash', href: CI_Base_Url + "" }
			],
			user_message_prompt: 'Invita a tus camigos a inventar sus versiones de V8 Splash'
		}
	);
	
	return false;
}

