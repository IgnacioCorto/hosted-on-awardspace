// JavaScript Document
var ebdy13 = {};
ebdy13.is_logged = false;
ebdy13.duration = 300;
ebdy13.delay = 1;

ebdy13.videoParams = [];


ebdy13.videoParams.push({
        title:'el baile <strong>del motoconcho</strong>',
	url:'http://brightcove.vo.llnwd.net/pd16/media/1084781208001/201312/3334/1084781208001_2900819710001_Motoconcho-v3.mp4',
	stops:[
		[7,8,'pasito de merengue'],
		[9,11,'dale la patá y aceléralo'],
		[11,12,'dale una vueltica'],
		[13,13.99,'aceléralo'],
		[14,14.99,'te fuíte']
		]
	});

ebdy13.videoParams.push({
        title:'el baile de <strong>la guagua</strong>',
	url:'http://brightcove.vo.llnwd.net/pd16/media/1084781208001/201312/3334/1084781208001_2900819765001_Guagua-v3.mp4',
	stops:[
		[7,8,'pasito de merengue'],
		[8,10,'agárate como puedas'],
		[10,13,'acomódate con el molote'],
		[14,15,'agárrate como puedas']
		]
	});

ebdy13.videoParams.push({
        title:'el baile <strong>del empuja&iacute;to</strong>',
	url:'http://brightcove.vo.llnwd.net/pd16/media/1084781208001/201312/3898/1084781208001_2900918575001_Empujaito-v3.mp4',
	stops:[
		[7,8,'pasito de merengue'],
		[9,10,'ponte en pose y remenea'],
		[11,12,'tira los pasitos dando empujoncitos'],
		[12,13,'ay pero qué calor'],
		[14,15,'tira los pasitos dando empujoncitos'],
		[15,16,'ay pero qué calor']
		]
	});

/*
ebdy13.videoParams.push({
        title:'el baile <strong>dándose amor</strong>',
	url:'http://brightcove.vo.llnwd.net/pd16/media/1084781208001/201312/3160/1084781208001_2893864007001_Dandose-Amor.mp4',
	stops:[
		[6,8,'coge tu ladito'],
		[9,11,'dándose amor'],
		[11,11.99,'manda un cariñito'],
		[12,14,'acomódate en el tumulto']
		]
	});
*/        


function appendVideoWidget(obj, index){
	var videoTitle = ebdy13.videoParams[index].title;
	var videoUrl = ebdy13.videoParams[index].url;
	var videoStops = ebdy13.videoParams[index].stops;
	
	var pasos = '';
	for(var i=0;i<videoStops.length;i++){
		pasos += '<li inicio="'+videoStops[i][0]+'" final="'+videoStops[i][1]+'"><span>'+(i+1)+'</span> '+videoStops[i][2]+'</li>\n';
	}
	
	var html = '\
   <a href="javascript:void(0);" class="rewind btnLink">x</a>\
   <div style="float:left;" class="video_pasitos">\n\
        <div class="blackbox">\
        <video width="500" height="280" preload="auto" id="videoplayer" >\
            <source src="'+videoUrl+'" type="video/mp4" />\
            Este reproductor requiere HTML 5 - Puedes usar <a href="https://www.google.com/intl/es/chrome/browser/">Google Chrome</a><br />\
            <a href="'+videoUrl+'">Descargar este video</a>\
        </video>\n\
        </div>\
        <button id="play" class="btnLink" onClick="videoplayer(event)">&gt;</button>\
    </div>\
\
    <div id="lista_videos" class="video_botones">\
        <div class="ttl_btn">\
        <h3>'+videoTitle+'</h3>\n\
        <p>Coloca el mouse sobre cada paso para repetirlo</p>\n\
        </div>\
        <ul>\
            '+pasos+'\
        </ul>\
    </div>\
\
    <div style="clear:both;"></div>\
\
    <img id="cargando" src="player_bucle/imgs/cargando.gif" />	\
	';
	
	jQuery('.ungif .fullview ').empty()
	obj.append(html);
	
	obj.find("*").click(function(event){
		event.stopPropagation();
	});
	
	obj.find(".rewind").click(function(event){
		jQuery(".ungif .numero").css({display:'none'});
		jQuery(".ungif .numero").hide({duration:0, queue:true});
		
		event.stopPropagation();
		
		var clicked = jQuery(this);
		var theParent = clicked.parents(".ungif");
		var theLeft = theParent.attr('data-left');
		
		theParent.find(".video_botones li").css({top:'-10px'});
		
		theParent.find(".fullview").fadeOut(ebdy13.duration).empty();
		theParent.animate({width:'234px', left:theLeft+'px'},ebdy13.duration);
		theParent.find(".preview").fadeIn(ebdy13.duration);
		jQuery(".ungif").not(theParent).delay(ebdy13.duration*ebdy13.delay).fadeIn(ebdy13.duration).promise().done(
			function(){
				jQuery(".ungif .numero").removeClass('centrado').show({duration:0, queue:true});
			}
		);

	});

	crear_player_bucle();	
}



function showAgregarFactura(){
    if(ebdy13.is_logged) {
        jQuery('html,body').animate({
                    scrollTop: jQuery("[name=seccion_agregar_factura]").offset().top
                }, 1000).promise().done(function(){
                    jQuery(".form_add_factura").slideDown('slow');
                });
    } else {
        showSocialLogin();
    }
}

function showWebcamUpload(){
    if(ebdy13.is_logged) {
        jQuery('.lightbox_webcam_upload').show();
    } else {
        showSocialLogin();
    }
}

function showFileUpload(){
    if(ebdy13.is_logged) {
        jQuery('.lightbox_file_upload').show();
    } else {
        showSocialLogin();
    }
}

function showSocialLogin(){
    console.log('social');
    jQuery('html,body').animate({
                scrollTop: jQuery("[name=seccion_social_login]").offset().top
            }, 1000).promise().done(function(){
               jQuery('.social_login_buttons').slideDown('slow');
            });
}

function addFactura(){
        jQuery.ajax({
          url: "lib/ajax_store_factura.php",
          type: "POST",
          data: { factura : jQuery('input[name=factura]').val() },
          dataType: "json"
        })
        .done(function( msg ) {
            jQuery("div.form_add_factura *")
                    .slideUp('slow')
                    .remove();
            jQuery("div.form_add_factura")
                .html('<label><span>La factura ha sido agregada exitósamente</span></label>');
            
            console.log( msg );
        })
        .fail(function( jqXHR, textStatus ) {
            console.log( "Request failed: " + textStatus );
        });
}




/* DOCUMENT READY */

jQuery(function(){
	//234 | 955
	
	jQuery(".ungif").click(function(){
		var clicked = jQuery(this);

		jQuery(".ungif .numero").hide({duration:0, queue:true});
		
		jQuery(".ungif").not(this).fadeOut(ebdy13.duration);

		clicked.animate({left:'0px', width:'960px'},ebdy13.duration);
		clicked.find(".preview").fadeOut(ebdy13.duration);
		clicked.find(".fullview").delay(ebdy13.duration*ebdy13.delay).fadeIn(ebdy13.duration)
			.promise().done(function(){ 
				clicked.find(".numero").addClass('centrado').show();
				var fullview = clicked.find(".fullview");
				appendVideoWidget(fullview, clicked.attr('data-index'));
				
				var btn_count = 5; //fullview.find(".video_botones li").size();
				var wrap_height = 125; //fullview.find(".video_botones").height();
				var padding = 15;
				var pixels_padding = padding*(btn_count-1);
				var btn_height = (wrap_height-pixels_padding)/btn_count;
				
				fullview.find(".video_botones li")
                                        /*.height(btn_height)*/
                                        .css({opacity:1});
				
				fullview.find(".video_botones li").each(function(i,e){
					var millis = Number(i*30);
					var pixels = Number(i*(btn_height+padding));
					
					/*jQuery(e)
						//.delay(millis)
						.animate({opacity:1}, {duration:1000, easing:'easeInExpo', queue:false});*/
						
					jQuery(e)
						.delay(millis)
						.animate({top:pixels+'px'}, {duration:500, easing:'easeOutBack', queue:true});
				});
				
			});
		
	});

	
	jQuery("#thumb_list").cycle({
            fx:'scrollHorz',
            next:   '.vidgalnav .left', 
            prev:   '.vidgalnav .right',
            timeout:0
        });
	
        
        if(ebdy13.is_logged){
            jQuery('html,body').animate({
                scrollTop: jQuery("[name=seccion_grabar_pasitos]").offset().top
                }, 1000);
        }
        
        
});