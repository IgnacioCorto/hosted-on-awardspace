/*
Ignacio Cortorreal
http://luis3ignacio.blogspot.com
ignacio@cortorreal.com
*/
	
var winScrollLeft 
  = winScrollTop 
  = winWidth 
  = winHeight 
  = docWidth 
  = docHeight 
  = maxScrollLeft 
  = maxScrollTop 
  = scrollingRatio 
  = 0;


var doorState
  = scrollInfoState 
  = videoState 
  = 1; 
var bgColorState 
  = helperState
  = 0;


jQuery(function(){
	
	var glowangle = 0;
	setInterval(function(){
		  glowangle+=3;
		 $(".glowcenter img.glow").rotate(glowangle);
	},50);	
	setTimeout(function(){ hideLoader(); }, 3000);

	
	function calculateSteps(){
		winWidth = $(window).width();
		winHeight = $(window).height();
		
		docWidth = Math.floor($('#dimesion_recipient').width());
		docHeight = Math.floor($('#dimesion_recipient').height());
//		docWidth = $(document).height();
//		docHeight = $(document).height();

		maxScrollLeft = docWidth - winWidth;
		maxScrollTop = docHeight - winHeight;
		
		jQuery('[parspeed][parwhen]').each(function(i,e){
			var p_start = jQuery(e).attr('parstart');
			if(p_start==undefined)
				jQuery.data(e,'parstart', winWidth);
			else {
				jQuery.data(e,'parstart', p_start);
			}
		});
		
		executeParallax();
	}
	
	
	function parallaxPiece00(selector){
		var v_start = jQuery.data(selector,'parstart')*1;      
		var v_when = jQuery(selector).attr('parwhen')/100;
		var v_speed = jQuery(selector).attr('parspeed')/100;
		var v_stop = jQuery(selector).attr('parstop');
		var v_plus = jQuery(selector).attr('parplus');
		
		scrollLeftRatio = scrollingRatio-v_when;
		var actualMovement = scrollLeftRatio*winWidth*v_speed;
		
		var to_move = v_start;
		if(v_plus!=undefined)  to_move += (v_plus*1);	
		
		if(v_stop==undefined) {
			if(scrollLeftRatio>0){
				//jQuery(selector).animate({'left': to_move + 'px'}, 50); //, 'easeInOutSine', null);
				to_move -= actualMovement;
			}
		} else {
			var pf1 = scrollLeftRatio / (1-v_when);
			to_move -= (pf1*v_stop);
		}
		
		jQuery(selector).css('left',to_move+'px');
		//jQuery(selector).animate({'left': to_move + 'px'}, {duration:41,queue: true} ); //, 'easeInOutSine', null);
	}
	
	

	function executeParallax(){
		winScrollLeft = $(window).scrollLeft();
		winScrollTop = $(window).scrollTop();
		
		//scrollingRatio = winScrollLeft/maxScrollLeft;
		scrollingRatio = winScrollTop/maxScrollTop;

		var scrollLeftRatio = scrollingRatio;
		var actualMovement = scrollLeftRatio*winWidth;

		
		jQuery('[parspeed]').each(function(i,e){
			parallaxPiece00(e);
		});
		

		var scrollPercent = Math.round(scrollLeftRatio*10000)/100;
		
		jQuery('.scroller_size').html(''
			+'<br /> % scroll: <strong>' + scrollPercent + '%</strong>'
			+'<br /> scroll: ('+winScrollLeft+' , '+winScrollTop+')'
			+'<br /> win: ('+winWidth+' , '+winHeight+')'
			+'<br /> doc: ('+docWidth+' , '+docHeight+')'
			+'<br /> max: ('+maxScrollLeft+' , '+maxScrollTop+')'
			);
	
	
		
		/*
		jQuery('[parstart][parstop]').each(function(i,e){
			var p_start = jQuery(e).attr('parstart')*1;
			var p_stop = jQuery(e).attr('parstop')*1;   //pixel_stop - css_left
			var p_diff = p_stop - p_start;
			var p_percent = winScrollLeft / maxScroll;
			var new_pos = Math.floor(p_start+p_diff*p_percent);
		
			console.log('probando 2:', winScrollLeft, maxScroll);
		
			
			if(jQuery(e).hasClass('nubes')){
				console.log(p_stop);
				console.log(p_start);
				console.log(p_diff);
				console.log(p_percent);
				console.log(new_pos);
			}
			jQuery(e).css({left:new_pos+'px'});
		});
		//*/
		
		//jQuery('#guagua_magica').animate({left:'740px'}, 300, 'easeInOutQuad', null);
		
		
		//jQuery('#guagua_magica').css({left:'740px'});
		//jQuery('#guagua_magica').css({left:'-450px'});
		//jQuery('#guagua_magica').css({left:Math.round(winWidth-1430)+'px'});
		
		
		

		//PUERTA AUTOMATICA	
		if(scrollingRatio>=0.21 && scrollingRatio<=0.30){
			if(doorState!=2){
				doorState=2;
				jQuery('.guagua2').unbind('hover');	
				jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-open')+'px'}, 300, 'easeInOutQuad', null);
			}
		} else {
			if(doorState!=1) {
				doorState=1;
				jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-close')+'px'}, 300, 'easeInOutQuad', null);
				jQuery('.guagua2').hover(	
					function(){ jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-open')+'px'}, 300, 'easeInOutQuad', null); },
					function(){ jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-close')+'px'}, 300, 'easeInOutQuad', null); }
				);
			}
		}
		

		//CAJA INFO INICIO
		if(scrollingRatio<=0.01){
			if(scrollInfoState!=1){
				scrollInfoState=1;
				jQuery('.scroll_info_box').fadeIn(300);
			}
		} else {
			if(scrollInfoState!=2){
				scrollInfoState=2;
				jQuery('.scroll_info_box').fadeOut(300);
			}
		}



		//VENTANA VIDEO
		if(scrollingRatio>=0.99){
			if(videoState!=2){
				videoState=2;
				//jQuery('.VentanaVideo').jqmShow(300);
			}
		} else {
			if(videoState!=1){
				videoState=1;
				//jQuery('.VentanaVideo').jqmHide(300);
			}
		}


		//HELPER MEN
		if(scrollingRatio>(V_WSCENE*0.01+0.05) && scrollingRatio<(V_WSCENE*0.01+0.09)){
			if(helperState!=1){
				helperState=1;
				jQuery('#r_helper_1').fadeIn();		
			}
		} else if(scrollingRatio>(V_WSCENE*0.02+0.04) && scrollingRatio<(V_WSCENE*0.02+0.08)){
			if(helperState!=2){
				helperState=2;
				jQuery('#r_helper_2').fadeIn();		
			}
		} else if(scrollingRatio>(V_WSCENE*0.03+0.04) && scrollingRatio<(V_WSCENE*0.03+0.08)){
			if(helperState!=3){
				helperState=3;
				jQuery('#r_helper_3').fadeIn();		
			}
		} else if(scrollingRatio>(V_WSCENE*0.04+0.06) && scrollingRatio<(V_WSCENE*0.04+0.10)){
			if(helperState!=4){
				helperState=4;
				jQuery('#r_helper_4').fadeIn();		
			}
		} else {
			helperState=0;
			jQuery('.r_helper_wrapper').fadeOut();
		}



		//BACKGROUND COLOR    efa6c3  8a55a3  e74864   efa460
		
		function animateBgColor(bgcolor){
			jQuery("body").animate({backgroundColor: bgcolor}, { duration: 300, queue: false } );				
		}
	
		if(scrollingRatio<(V_WSCENE*(0.01-0.00023))){
			if(bgColorState!=1){
				bgColorState=1;
				animateBgColor("#75afc3");			
			}
		} else if(scrollingRatio<(V_WSCENE*(0.02-0.00097))){
			if(bgColorState!=2){
				bgColorState=2;
				animateBgColor("#efa6c3");			
			}
		} else if(scrollingRatio<(V_WSCENE*(0.03-0.00084))){
			if(bgColorState!=3){
				bgColorState=3;
				animateBgColor("#8a55a3");			
			}
		} else if(scrollingRatio<(V_WSCENE*(0.04-0.00084))){
			if(bgColorState!=4){
				bgColorState=4;
				animateBgColor("#e74864");			
			}
		} else if(scrollingRatio<0.9999){
			if(bgColorState!=5){
				bgColorState=5;
				animateBgColor("#efa460");			
			}
		}


		var g_stat = 0;
		var g_pos = 0;
		var g_w = $('#guagua_magica').width();
		var r_extr = winWidth - 250;
		var l_extr = -g_w+350;
		var w_extr = r_extr - l_extr;
		var st_desp = 450 + r_extr;
		
		
		var arr_pos = [
			0,
			0.36, 
			0.60,
			0.80,
			1
			];	
		
		var arr_stops = [
			-g_w+495, 
			winWidth-395,
			-g_w+495, 
			winWidth-395,
			-g_w+495
			]
	
//		var arr_pos = [0, 0.2373, 0.5368, 0.829, 1];	
//		var arr_stops = [
//			0, 
//			r_extr, 
//			-g_w+640, //left
//			r_extr, 
//			-g_w+290, //left
//			winWidth-g_w-360  //right
//			];	



		
		if(scrollingRatio<=arr_pos[1]){
			
			g_pos = arr_stops[0] + (scrollingRatio - arr_pos[0])/(arr_pos[1] - arr_pos[0]) * (arr_stops[1] - arr_stops[0]);
			//console.log(g_pos, arr_stops[0], (arr_stops[1] - arr_stops[0]));			
			
		} else if(scrollingRatio>=arr_pos[1] && scrollingRatio<arr_pos[2]) {
			
			g_pos = arr_stops[1] + (scrollingRatio - arr_pos[1])/(arr_pos[2] - arr_pos[1]) * (arr_stops[2] - arr_stops[1]);
			
			
		} else if(scrollingRatio>=arr_pos[2] && scrollingRatio<arr_pos[3]) {
			
			g_pos = arr_stops[2] + (scrollingRatio - arr_pos[2])/(arr_pos[3] - arr_pos[2]) * (arr_stops[3] - arr_stops[2]);
			
		} else if(scrollingRatio>=arr_pos[3]) {
			
			g_pos = arr_stops[3] + (scrollingRatio - arr_pos[3])/(arr_pos[4] - arr_pos[3]) * (arr_stops[4] - arr_stops[3]);
			
		}
		
		jQuery('#guagua_magica').css({left:Math.round(g_pos)+'px'});
		//jQuery('#guagua_magica').animate({left: Math.round(g_pos) + 'px'}, 41); //, 'easeInOutSine', null);
		
	   $("#dcmt_pointer").rotate({
		  angle: (128.4 - (188-193*scrollLeftRatio)), // - (193*scrollLeftRatio), //0, 
		  //animateTo:128.4 - 188 - (193*scrollLeftRatio), //0, 
		  easing: $.easing.easeOutElastic
	   });
		//rotation_oscillate(-5,188);
				
		
		return false;	
	}


	//TRIGGER PARALLAX
	jQuery(window).unbind("scroll").scroll(executeParallax);
	jQuery(window).unbind("resize").resize(calculateSteps);
	calculateSteps();
				
			
			
	$('#SendPhrase').click(function() {
		var Usuario = $('input[name="user_id"]').val();
		var Phrase = $('textarea[name="phrase"]').val();

		if(Usuario != "" && Phrase != "")
		{
			$('input#SendPhrase').attr('disabled', 'disabled');
			$.ajax({
			  type: 'POST',
			  url: '/agora/ajax/enviar_frase/',
			  data: "usuario=" + Usuario + "&frase=" + Phrase,
			  success: function(result){
				//alert('Gracias por tu apoyo.');
				$('textarea.phrase_textarea').val("");
				$('.Gracias').jqm().jqmShow({overlay: 70});

				$('.Caja2').animate({
					height: 1,
					top: -20
				}, 500);
				$('a.Boton2').removeClass('selected');
				if(result == "Facebook")
				{
					postToFeed(Phrase);
				}
				
				$('input#SendPhrase').removeAttr('disabled');
			  }
			});
		}
		else
		{
			alert('Debes introducir una frase para apoyarlos.');
		}
	
	  return false;
	});
	
	
	//LIGHTBOX
	jQuery("#Splash_BG, #Box_Inscrito, #Box_Ganadores, .VentanaVideo, #Box_Elegido, #Box_Verificar, #Ganadores_v2,"
			+".v1premiosfans, .v1ofertasemana, .VentanaSigo").jqm({
		overlay:90 
		,toTop:true
		,onShow: function(hash){
			//*
			//hash.w.show();
			hash.o.fadeIn(300);
			hash.w.fadeIn(300);
//			console.log(
//			'window:', winWidth, winHeight, 
//			'dialog:', hash.w.width(), hash.w.height(),
//			'CLASS:', hash.w.attr('class')
//			); 
			/**/
			hash.w.css('margin-top', ((winHeight-hash.w.height())/2)+'px');
			
			jQuery('.VentanaSigo .jqScroller').jScrollPane({
				verticalDragMinHeight: 20,
				verticalDragMaxHeight: 20,
				horizontalDragMinWidth: 20,
				horizontalDragMaxWidth: 20
			}); 
		}
		,onHide: function(hash){
			hash.o.fadeOut(300);
			hash.w.fadeOut(300);		
		}
	});
	
	//GALERIA DE GANADORES
	jQuery(".winners_thumbs").cycle({
			startingSlide: 0,
			timeout:0, //1000
			pager:'.banner_pager',
			fx:'scrollHorz',
			pause:0, //1
			next:   '#winner_left', 
			prev:   '#winner_right',
			after: function() {
				
			}
		});



	//OFERTAS MODA
	jQuery("#container_moda").cycle({
			startingSlide: 0,
			timeout:0, //1000
			fx:'scrollHorz',
			pause:0, //1
			next:   '#moda_left', 
			prev:   '#moda_right',
			after: function() {
				
			}
		});

	//OFERTAS MODA
	jQuery("#container_entret").cycle({
			startingSlide: 0,
			timeout:0, //1000
			fx:'scrollHorz',
			pause:0, //1
			next:   '#entret_left', 
			prev:   '#entret_right',
			after: function() {
				
			}
		});

	//OFERTAS MODA
	jQuery("#container_superm").cycle({
			startingSlide: 0,
			timeout:0, //1000
			fx:'scrollHorz',
			pause:0, //1
			next:   '#superm_left', 
			prev:   '#superm_right',
			after: function() {
				
			}
		});

	//OFERTAS MODA
	jQuery("#container_casa").cycle({
			startingSlide: 0,
			timeout:0, //1000
			fx:'scrollHorz',
			pause:0, //1
			next:   '#casa_left', 
			prev:   '#casa_right',
			after: function() {
				
			}
		});


	//PREMIOS PARA JUMBO FANS
	jQuery(".v1premiosfans .parafans .secciones a").click(function(){
		jQuery('.v1premiosfans').jqmHide();
		if( jQuery(this).hasClass("moda") ){ jQuery('#v2moda').jqmShow(); jQuery('.bombillos span:eq(0)').click(); }
		else if( jQuery(this).hasClass("entret") ){ jQuery('#v2entret').jqmShow(); jQuery('.bombillos span:eq(1)').click(); }
		else if( jQuery(this).hasClass("super") ){ jQuery('#v2superm').jqmShow(); jQuery('.bombillos span:eq(2)').click(); }
		else if( jQuery(this).hasClass("casa") ){ jQuery('#v2casa').jqmShow(); jQuery('.bombillos span:eq(3)').click(); }
	});


	//GALERIA DE GANADORES
	jQuery(".winners_thumbs img").click(function(){
		jQuery('#winner_name_holder').html( jQuery(this).attr('data-name') );
		jQuery('#winner_prize_holder').html( jQuery(this).attr('data-prize') );
		jQuery('#winner_avatar_holder').attr('src', jQuery(this).attr('src') );
	});
	
	
	
	
	
	//DESCUENTOMETRO: AGUJA
	function rotation_oscillate(dmin, dmax){
		/*
	   $("#dcmt_pointer").rotate({
		  angle:128.4 - dmin, //0, 
		  animateTo:128.4 - dmax, 
		  easing: $.easing.easeOutElastic,   // easeOutElastic easeOutBounce
		  callback: function(){ rotation_oscillate(dmax,dmin); } 
	   });
	   */
	   
	   $("#dcmt_pointer").rotate({
		  angle:128.4 - 180, //0, 
		  animateTo:128.4 - 150, 
		  easing: $.easing.easeOutElastic
	   });
	   
	}
	//rotation_oscillate(-5,188);		

	
	
	
	function animate_gotolike(pixels){
		jQuery('.fb_goto_like').animate({
			top: '-='+pixels+'px'
		  }, {
			duration: 500,
			specialEasing: {
			  top: 'easeInOutSine'
			},
			complete: function() {
			  animate_gotolike(-pixels);
			}
		  });
	}
	animate_gotolike(20);	
	
	
	function animate_helicoptero(pixels){
		jQuery('.helicoptero').animate({
			bottom: '-='+pixels+'px'
		  }, {
			duration: 1000,
			specialEasing: {
			  top: 'easeInOutExpo'
			},
			complete: function() {
			  animate_helicoptero(-pixels);
			}
		  });
	}
	animate_helicoptero(20);	
	

	function animate_helicopteros(pixels){
		jQuery('.helicopteros').animate({
			bottom: '-='+pixels+'px'
		  }, {
			duration: 2000,
			specialEasing: {
			  top: 'easeInOutExpo'
			},
			complete: function() {
			  animate_helicopteros(-pixels);
			}
		  });
	}
	animate_helicopteros(20);	
	


	function animate_redbus(step){
		switch(step){
			case 1:
				jQuery('.big_loader .redbus').css({width:'0%',float:'left', backgroundPosition:'left top'});
				var towards = '100%';
				break;
			case -1:
				jQuery('.big_loader .redbus').css({width:'100%',float:'right', backgroundPosition:'right top'});
				var towards = '0%';
				break;
		}
		
		jQuery('.big_loader .redbus').animate({
			width: towards
		  }, {
			duration: 5000,
			specialEasing: {
			  top: 'easeInOutQuad'
			},
			complete: function() {
			  animate_redbus(step*-1);
			}
		  });
	}
	animate_redbus(1);	


	
//	jQuery('#puerta_guagua_2').hover(	
//		function(){ jQuery('#puerta_guagua').attr('src', jQuery('#puerta_guagua').attr('data-open')); },
//		function(){ jQuery('#puerta_guagua').attr('src', jQuery('#puerta_guagua').attr('data-closed')); }
//	)
	//.click(function(){
	//	jQuery('#Splash_BG').jqmShow();
	//})
	;
	
	jQuery('.guagua2').hover(	
		function(){ jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-open')+'px'}, 300, 'easeInOutQuad', null); },
		function(){ jQuery('#puerta_guagua_3_d').animate({left:jQuery('#puerta_guagua_3_d').attr('data-close')+'px'}, 300, 'easeInOutQuad', null); }
	)

	jQuery('.descuentometro_box').hover(	
		function(){ 
			jQuery(this).animate({bottom:'+=160px'}, 300, 'easeInOutQuad', 
				function(){
					jQuery('.ribbonbases').stop().animate({left:'541px', bottom:'101px'}, 300, 'easeInOutQuad', null); 
					/*left: 466px; bottom: 86px; --> left:541px; bottom:101px;*/
				}
			); 
			//jQuery('.descuentometro_box .voy').stop().animate({top:'+=400px'}, 300, 'easeInOutQuad', null); 
			//jQuery('.descuentometro_box .voy').hide(); 
		},
		function(){ 
			jQuery(this).animate({bottom:'-=160px'}, 300, 'easeInOutQuad', null);  
					jQuery('.ribbonbases').stop().animate({left:'466px', bottom:'86px'}, 300, 'easeInOutQuad', null); 
			//jQuery('.descuentometro_box .voy').stop().animate({top:'-=400px'}, 300, 'easeInOutQuad', null); 
			//jQuery('.descuentometro_box .voy').show(); 
		}
	)


	jQuery('.bombillos span').click(function(){
		jQuery('html, body').animate({scrollTop:jQuery(this).attr('data-percent')*maxScrollTop/100}, 1000);
		jQuery('.bombillos span').removeClass('on');
		jQuery(this).addClass('on');
	});
	
	
	jQuery('.fb_goto_like').click(function(){
		jQuery('html, body').animate({scrollTop:0.2373*maxScrollTop}, 1000);
		return false;
	});
	
			
});





// END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - END OF INIT - 

function tickScroll(){
	jQuery('html, body').animate({scrollTop:'+=1 '}, 50);
}




function hideLoader(){
	//hide_loader=true;
	if(hide_loader) { $('.big_loader').fadeOut(); }
	else { hide_loader=true; }
}


function mostrarGanadores(){
	//jQuery('#Box_Ganadores').jqmShow();
	jQuery('#Ganadores_v2').jqmShow();
	jQuery(".winners_thumbs img:first").click();
}


	
function mostrarSplash(){
	$('.splash_login').toggle(25,function(){

		jQuery('a.twitter-follow-button').each(function(i,e)
		{
	
			var tweet_button = new twttr.TweetButton( $( e ).get( 0 ) );
			tweet_button.refresh();
		});
			jQuery.ajax({ url: 'http://platform.twitter.com/widgets.js', dataType: 'script', cache:true});
	});
	
}
	
function mostrarSplashLikeFollow(){
	$('.SplashLikeFollow').toggle('slow');
}
	
	
	
	
	
	
	
function postToFeed(txt) {
	// calling the API ...
	var obj = {
	  method: 'feed',
	  link: 'http://jumbofans.com/agora/',
	  picture: 'http://jumbofans.com/images/logo_soy.jpg',
	  name: 'Yo voy primero',
	  description: txt
	};
	
	function callback(response) {
	 // document.getElementById('msg').innerHTML = "Post ID: " + response['post_id'];
	}
	
	FB.ui(obj, callback);
}



/* ************* ORIGINAL FACEBOOK FUNCTIONS ************* */
   
function fbauth()
{
	/*
	FB.ui({
			client_id: FB_APP_ID,
			method: 'oauth',
			scope: 'email,publish_stream',
			redirect_uri: FB_APP_SITEURL,
			response_type: 'code'
		},
		function(response) {
			console.log(response);
		}	  
	);
	*/

	document.location.href="https://www.facebook.com/dialog/oauth/?scope=email,user_likes,publish_stream&client_id="+FB_APP_ID+"&response_type=code&redirect_uri="+FB_APP_SITEURL;
}

function fblogout()
{
	FB.logout(function(response) {
	  // user is now logged out
	  document.location.href=FB_APP_LOGOUT;
	});
}

function get_user_data(id)
{
	FB.api('/me', function(response) {
		$.ajax({
		  type: 'POST',
		  url: FB_APP_BASEURL+'ajax/fblogin/',
		  data: "fbid=" + id + "&first_name=" + response.first_name + "&last_name=" + response.last_name + "&email=" + response.email,
		  success: function(data){
			  //alert('Exito.');
			  parent.location.reload();
		  }
		});
	});
}



/* ************* IGNACIO FACEBOOK FUNCTIONS ************* */

function verificarLike(fbid){
	FB.api('/me/likes/'+ENTITY_FB_ID, function(response) {
		
		if(typeof response.data[0]!='undefined') {
			jQuery.ajax({
				type: 'POST',
				data: "fbid=" + fbid,
				url: "/agora/ajax/fb_like",
				success: function(data){
	
					jQuery.ajax({
						type: 'GET',
						url: "/agora/assets/php/engel/app.settings.php",
						success: function(data){
							top.location.href=FB_APP_BASEURL+'index/bienvenido';
						}
					});
					
				}
			});
			
			
		}
	});
}



/* ************* TWITTER FUNCTIONS ************* */

function verificarFollow(user,follows){
	jQuery.ajax({
		url: "https://api.twitter.com/1/friendships/exists.json?user_id_a="+user+"&user_id_b="+follows+"&"+(new Date()).getTime()+"&callback=?",
		dataType: "json",
		success: function(data){
			if(data==true)  storeFollow(user,follows);
		}
	});
}

function storeFollow(user,follows){
	jQuery.ajax({
		type: 'POST',
		data: "ttid=" + user,
		url: "/agora/ajax/tt_follow",
		success: function(data){
			top.location.href=FB_APP_BASEURL+'index/bienvenido';
		}
	});
}

/* ************* STORE EMAIL ************* */

function storeEmail(user){
	var email = jQuery('#f_fill_email').val();
	
	jQuery.ajax({
		type: 'POST',
		data: "user="+user+"&email=" + email,
		url: "/agora/ajax/store_email",
		success: function(data){
			
			jQuery('#email_result').html(data);
			if(data.indexOf('Email actualizado.')>-1) {
				jQuery('#form_email, #Box_Elegido p.ganador').remove();
				jQuery('#email_result').css({paddingTop:'50px'});
			}
				
		}
	});
}

