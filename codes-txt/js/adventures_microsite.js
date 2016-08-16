/*
Desarrollado por Ignacio Cortorreal
http://cortorreal.com
*/

var adventures = {
	 showLightbox: function(id) {
		$('.section.ccer .lightbox').show(); 
		$('.section.ccer .lightbox .content2').cycle(id);
	},
	
	gotoServicios: function (id) {
		$('.header .nav a:eq(1)').trigger('click');
		$('.section.ccer .content').cycle(id);
	},
	
	servicioSlide: function (id) {
		$('.section.ccer .content').cycle(id);
	},
	
	topNavSelected: function (n_old, n_new){
		$(n_old).removeClass('selected');
		$(n_new).addClass('selected');
	},
	
	showMap: function (myLat,myLang) {
		$(window)
			.load(function(){
	
				if (GBrowserIsCompatible()) {
				var map = new GMap2(document.getElementById("map_canvas"));
				
				var mylatlng = new GLatLng(myLat,myLang);
				map.setCenter(mylatlng, 14);
				
				/*GEvent.addListener(map,"click", function(overlay,latlng) {     
				  if (latlng) {   
					var myHtml
					  = "Lat: " + latlng.lat() + "<br />"
					  + "Lng: " + latlng.lng() + "<br />"
					  + "Zoom: " +map.getZoom()+ "<br />"
					  ;
					map.openInfoWindow(latlng, myHtml);
				  }
				});*/
				
				map.addControl(new GSmallMapControl());
				map.addControl(new GMapTypeControl());
				map.addOverlay(new GMarker(mylatlng));
				}			
			})
			.unload(function(){
				GUnload();
			});	
	
	}	
	
	
};



$(function(){
	
	//SMOOTH SCROLLING EVENTS
	$('a[href^=#]')
		//.attr('onclick','return false;')
		.click(function(event){
			var contenedor = $('html,body');
			var anAnchor = event.target.href.split('#')[1]; //.substr(1,-1);
			var scrollToUp = $('a[name='+anAnchor+']');
	
			var myData = scrollToUp.offset().top; //scrollToUp.offset().top - contenedor.offset().top + contenedor.scrollTop();
			contenedor.animate({scrollTop:myData}, 2000);
			return false;
		});


	//TOP NAV SELECTED
	$('.header .nav a').click(function(){
		$('.header .nav a').removeClass('selected');
		$(this).addClass('selected');
	});
	
	//$('.header .nav a:first').addClass('selected');
	
	
	
	//FANCY SCROLLBARS
	$('.scroller').jScrollPane({
		verticalDragMinHeight: 21,
		verticalDragMaxHeight: 21,
		horizontalDragMinWidth: 13,
		horizontalDragMaxWidth: 13
	});	
	
	$('.section.ccer .lightbox').hide();
	
	
	//PARALLAX BACKGROUND
	(function () {
		var a = document.body,
			e = document.documentElement,
			mb = $('.bigbg2').get(0);
		$(window).unbind("scroll").scroll(function () {
			var absScroll = Math.max(e.scrollTop, a.scrollTop);
			mb.style.backgroundPosition = "center " + -(absScroll/8) + "px";
			
			var anchors = $('a[name]');
			
			for(var i=anchors.size()-1;i>-1;i--){
				if(absScroll>=(anchors.eq(i).offset().top-200)){
					adventures.topNavSelected($('.header .nav a.selected'), $('.header .nav a').eq(i));
					break;
				}
			}
			
			return false;
		})
	})();
	
	
	//BG MOUSE FOLLOWING
	$(".section.home").mousemove(function(e){
		moveimages(e.pageX,e.pageY);
	});
	
	function moveimages(mx,my){
		//CENTER CURSOR
		
		var cx = $(window).width()/2;
		var cy = 333; //$(window).height()/2;
		
		if(mx==null && my==null){
			mx=cx;
			my=cy;
		}
		if(my>600) my=600;
		
		
		var dx = (mx-cx)/8;
		var dy = (my-cy)/8;
		
		var d2x = (mx-cx)/3;
		var d2y = (my-cy)/2;		
		
		$(".bgfollow1").css({display:'block', position:'absolute', left:(cx+dx)+'px', top:(cy+dy)+'px'})	 
		$(".bgfollow2").css({display:'block', position:'absolute', left:(cx+d2x)+'px', top:(cy+d2y)+'px'})	 
	}
	moveimages(null,null);
		
	
	//SLIDER LIST	
	
	$('.section.ccer .content').cycle({
		startingSlide: 0,
		timeout:0,
		fx:'scrollHorz',
		pause:1,
		next:   '#serv_right', 
		prev:   '#serv_left',
		after: function() {}
	});	
	
	
	$('.section.agencia .content').cycle({
		startingSlide: 0,
		timeout:0,
		fx:'fade',
		pause:1,
		next:   '#agen_right', 
		prev:   '#agen_left',
		before: function(a1,a2,op) {
			var navlist = $('.section.agencia .extraicons a');
			navlist.eq($(a1).attr('data-index')).removeClass('selected');
			navlist.eq($(a2).attr('data-index')).addClass('selected');
		}
	});		
	
	/*$('.section.blog .content').cycle({
		startingSlide: 0,
		timeout:0,
		fx:'scrollVert',
		pause:1,
		next:   '#blog_right', 
		prev:   '#blog_left',
		after: function() {}
	});*/
		
	$('.section.ccer .lightbox .content2').cycle({
		startingSlide: 0,
		timeout:0,
		fx:'scrollVert',
		pause:1,
		next:   '#light_left', 
		prev:   '#light_right',
		after: function() {}
	});	
			
});


