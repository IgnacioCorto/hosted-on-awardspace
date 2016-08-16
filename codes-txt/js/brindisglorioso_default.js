// ON DOCUMENT READY

jQuery(function(){
    
        // FONDOS
        var bgelems = [];
        
        bgelems.push(jQuery('.bg_parallax img.img02'));
        bgelems[bgelems.length-1].data('scroll', {
            movement:[601,551],
            scroll:[0,1000]});
        
        bgelems.push(jQuery('.bg_parallax img.img04'));
        bgelems[bgelems.length-1].data('scroll', {
            movement:[540,333],
            scroll:[82,950]});
        
        
        bgelems.push(jQuery('.bg_parallax img.img06')); //castillo
        bgelems[bgelems.length-1].data('scroll', {
            movement:[1363,1319],
            scroll:[800,1600]});
        
        
        bgelems.push(jQuery('.bg_parallax img.img05'));
        bgelems[bgelems.length-1].data('scroll', {
            movement:[1502,1211],
            scroll:[627,2607]});
        

        bgelems.push(jQuery('.bg_parallax img.img08')); //arbol bases
        bgelems[bgelems.length-1].data('scroll', {
            movement:[3060, 3160],
            scroll:[2508,3201]});
    
    
        function parallax_elements(newbgpos){
            jQuery(bgelems).each(function(i,e){
                var elem = bgelems[i];
                var data = elem.data('scroll');
                if(newbgpos===true) newbgpos = data.scroll[0]+1;

                if(newbgpos>data.scroll[0] && newbgpos<data.scroll[1]){
                    var rangescroll = data.scroll[1] - data.scroll[0]; 
                    var rangemovement = data.movement[1] - data.movement[0];
                    var percentscroll = (newbgpos - data.scroll[1]) / rangescroll;
                    var realpixel = (percentscroll * rangemovement) + Math.min.apply(null, data.movement);
                    TweenLite.to(elem,0.01, {left:realpixel+'px'});
                }
            });
        }

        parallax_elements(true);
        
        var bgparent = jQuery('.bg_parallax');
        var oldbgpos = bgparent.position().left;
        
        setInterval(function(){
            var newbgpos = Math.abs(bgparent.position().left);

            if(oldbgpos!=newbgpos){
                
               parallax_elements(newbgpos);
               oldbgpos=newbgpos;
            }
        },63);     
        
    
    
    //NAVEGACION PRINCIPAL
    jQuery('.navigation')
        .find('.principal')
        .data({section:'intro', bgleft:'0px', hidden:true})
        .end()
        .find('.l_sommelier')
        .data({section:'sommelier', bgleft:'-800px', hidden:true})
        .end()
        .find('.l_salud')
        .data({section:'salud', bgleft:'-1600px', hidden:true})
        .end()
        .find('.l_vinos')
        .data({section:'vinos', bgleft:'-2400px', hidden:true})
        .end()
        .find('.l_bases')
        .data({section:'bases', bgleft:'-3200px', hidden:true})
        .end()
        ;
        
        
    
    (function(){
        function shuffle(o){ //v1.0
            for(var j, x, i = o.length; i; j = Math.floor(Math.random() * i), x = o[--i], o[i] = o[j], o[j] = x);
            return o;
        };        
        
        function range(start, end)
        {
            var array = new Array();
            for(var i = start; i < end; i++)
            {
                array.push(i);
            }
            return array;
        }        
        
        var arrRandom = shuffle(range(0, jQuery('.section.intro .picdot').size())); //piclist.length

        var sPicdots = jQuery('.section.intro a.picdot');
        sPicdots.css({opacity:0,top:'+=10px'});
        
        if(!isMobile){
            sPicdots.each(function(i,e){
                sPicdots.eq(arrRandom.pop()).delay(i*200).animate({opacity:1,top:'-=10px'});
            });
        }
        
    })();
    
    
    
    if(0 && !isMobile){
        
        var parallaxSly = new Sly('.ign_viewport', {
            //interactive: '.controls',   //not draggable
            horizontal: true, 
            //itemNav: 'basic',

            //pagesBar: null, //'.pages',


            scrollBy: 100,  //pixels or items
            speed: 0,   //millis
            //easing: 'easeOutQuart',   //jquery.easing
            //scrollBar: '.scrollbar',

            //dynamicHandle: 1,    //resize handle
            dragHandle: 1,
            clickBar: 1,

            mouseDragging: 1,
            touchDragging: 1,
            releaseSwing: 1
        });
        parallaxSly.init();
        
    }
    
    
    jQuery('.shape_sommelier_wrap').hide().animate({width:'-=345px',left:'+=172px'});
    jQuery('.section.sommelier .shape_sommelier').hide().animate({left:'-=172px'});
    jQuery('.section.sommelier .whitebox').hide().animate({top:'+=560px'});

    jQuery('.shape_salud_wrap').hide().animate({width:'-=299px',left:'+=149px'});
    jQuery('.section.salud .shape_salud').hide().animate({left:'-=149px'});
    jQuery('.section.salud .click_scroll').hide().animate({width:'-=97px',left:'+=49px'});

    jQuery('.shape_bases_wrap').hide().animate({width:'-=443px',left:'+=221px'});
    jQuery('.section.bases .shape_bases').hide().animate({left:'-=221px'});
    jQuery('.section.bases .whitebox').hide().delay(100).animate({top:'+=560px'});


    
    var sectionFuncs = {};
    
    sectionFuncs.sommelier = function(){
        jQuery('.shape_sommelier_wrap').show().animate({width:'+=345px',left:'-=172px'});
        jQuery('.section.sommelier .shape_sommelier').show().animate({left:'+=172px'});
        jQuery('.section.sommelier .whitebox').show().delay(100).animate({top:'-=560px'});
        return false;
    };

    sectionFuncs.salud = function(){
        jQuery('.shape_salud_wrap').show().animate({width:'+=299px',left:'-=149px'});
        jQuery('.section.salud .shape_salud').show().animate({left:'+=149px'});
        jQuery('.section.salud .click_scroll').show().animate({width:'+=97px',left:'-=49px'});
    };

    sectionFuncs.bases = function(){
        jQuery('.shape_bases_wrap').show().animate({width:'+=443px',left:'-=221px'});
        jQuery('.section.bases .shape_bases').show().animate({left:'+=221px'});
        jQuery('.section.bases .whitebox').show().delay(100).animate({top:'-=560px'}, 
            function(){
                
                var basesSly = null; 
                basesSly = new Sly('.texto_scroll',{
                    scrollBy: 100,  //pixels or items
                    speed: 200,   //millis
                    //easing: 'easeOutQuart',   //jquery.easing
                    scrollBar: '.bases_texto_wrap .scrollbar',

                    //dynamicHandle: 1,    //resize handle
                    dragHandle: 1,
                    clickBar: 1,

                    mouseDragging: 1,
                    touchDragging: 1,
                    releaseSwing: 1
                });
                basesSly.init();
                
            }
        
        );
        
    };

    
    
    
    jQuery('.navigation a').click(function(){
        
        var oData = jQuery(this).data();
        var section = oData.section;
        var bgleft = oData.bgleft;
        var button = this;

        if(isMobile) {
            setScrollEvent(false);
            
            isQuietView = false;
            
            /// MOBILE SCROLLING ///
            var thisIndex = jQuery('.navigation a').index(this);
            var adjusts = {
                bases:113,
                vinos:139,
                salud:119,
                sommelier:168,
                intro:120
            };

            var contenedor = jQuery('.ign_viewport');
            var scrollToUp = jQuery('.section.'+section);
            var scrollData = scrollToUp.position().left;
            if(isMobile) scrollData += adjusts[section];


//            TweenLite.to(contenedor, 0.3, { scrollTo:{x:scrollData,y:0}, //scrollLeft:scrollData, scrollTop:0,
//                onComplete:function(){
//                    isQuietView = true;
//                    currentScrollLeft = contenedor.scrollLeft();
//                    
//                    if(oData.hidden && undefined!==sectionFuncs[section]){
//                        sectionFuncs[section]();
//                        oData.hidden = false;
//                    }
//                }}); 
            
            contenedor.animate({scrollLeft:scrollData, scrollTop:0}, 300, function(){
                isQuietView = true;
                currentScrollLeft = contenedor.scrollLeft();
                
                if(oData.hidden && undefined!==sectionFuncs[section]){
                    sectionFuncs[section]();
                    oData.hidden = false;
                }
                
                setTimeout(setScrollEvent, 400);
            });
            
            
        } else {
            
            /// DESKTOP TWEEN LITE ///
            TweenLite.to('.bg_parallax', 1, {left:bgleft , 
                onComplete:function(){
                    jQuery('.section.'+section).show();

                    jQuery('.navigation a')
                        .removeClass('selected')
                        .filter(button)
                        .addClass('selected');

                    if(oData.hidden && undefined!==sectionFuncs[section]){
                        sectionFuncs[section]();
                        oData.hidden = false;
                    }
                },
                onUpdate: function(){
                    parallax_elements(bgparent.position().left);
                }
            } );
            
        }
        
        return false;
    });
    
    
    var keyboardNav = {key:0,index:0,links:['.principal',
            '.l_sommelier', '.l_salud', '.l_vinos', '.l_bases']};
    
    function doKeyNav(KeyID){
        //console.log(event.which);
        var canMove = true;
        
        switch(KeyID){
            case 39:
                keyboardNav.index++;
                if(keyboardNav.index>=keyboardNav.links.length) {
                    keyboardNav.index=0;
                }
                break;
            case 37:
                keyboardNav.index--;
                if(keyboardNav.index<0) {
                    keyboardNav.index=keyboardNav.links.length-1;
                }
                
                break;
            default:
                canMove = false;
                break;
        }
        
        if(canMove) jQuery('.navigation '+keyboardNav.links[keyboardNav.index]).click();
    }
    

    
    jQuery(window).on('keyup',function(event){
        doKeyNav(event.which);
    });
    jQuery(window).focus();
    
    
    var isQuietView = true;
    var currentScrollLeft = 0;
    
    function setScrollEvent(activate){
        if(activate===false) {
            jQuery('.ign_viewport').off('scroll');
            return;
        }
        
        jQuery('.ign_viewport').on('scroll', function(event){

            clearTimeout(jQuery.data(this, 'scrollTimer'));
            jQuery.data(this, 'scrollTimer', setTimeout(function() {

                if(isQuietView) {
                    isQuietView = false;
                    var actScrl = contenedor.scrollLeft();
                    var diffScrl = actScrl - currentScrollLeft;

                    setScrollEvent(false);

                    if( Math.abs(actScrl - currentScrollLeft) > 20
                    && actScrl > currentScrollLeft) {
                        doKeyNav(39);
                    } else {
                        doKeyNav(37);
                    }

                }

            }, 300));


        }); //on scroll

    }
    
    
    
    
    
    
    
    
    /// START UP: IS MOBILE ///
    if(isMobile){
        var contenedor = jQuery('.ign_viewport');
        

          TweenLite.to(contenedor, 0, {scrollLeft:120, scrollTop:0
              ,onComplete:function(){
                  
                    setTimeout(function(){
                        currentScrollLeft = contenedor.scrollLeft();
                        setScrollEvent();
                    }, 500);
                  
              }
           });


        
        jQuery('.ign_viewport').scroll(function(event){
            jQuery('.top_counter').html(jQuery(this).scrollLeft());
        });
        
        //NAVIGATION
        var otherlinks = jQuery('.navigation a').not('.principal');
        var sandwich = jQuery('.navigation a.principal .sandwich');
        var infopasos = jQuery('.navigation a.principal .infopasos');
        var cerrarpasos = jQuery('.bannerSubirFoto .closeForm');
        
        otherlinks.click(function(){ otherlinks.hide(); });
        otherlinks.hide();
        
        sandwich.click(
            function(event){
                event.stopPropagation();
                
                if( otherlinks.filter(':visible').size()>0) {
                    otherlinks.hide();
                } else {
                    otherlinks.show();
                }
            }
        );
         
            
        var tlInfoPasos = new TimelineMax({paused:true});
        tlInfoPasos.addLabel('hidden');
        tlInfoPasos.fromTo('.bannerSubirFoto', 0.5, {top:"-2000px"}, {top:'32px'});            
        tlInfoPasos.addLabel('visible');
        
        
        function eventoInfoPasos(event){
            event.stopPropagation();

            if( tlInfoPasos.currentLabel()=='visible') {
                tlInfoPasos.tweenTo('hidden');
            } else {
                tlInfoPasos.tweenTo('visible');
            }

            /*
            if( jQuery('.bannerSubirFoto:visible').size()>0) {
                jQuery('.bannerSubirFoto').hide();
            } else {
                jQuery('.bannerSubirFoto').show();
            }
            */
        }
            
        infopasos.click(eventoInfoPasos);
        cerrarpasos.click(eventoInfoPasos);

            
        
//        var tl = new TimelineLite({paused:true});
//        tl.from(logo, 0.5, {left:"-=60px", ease:Back.easeOut})
//            .from(timelineLite, 0.5, {width:"0px", alpha:0}, "-=0.2")
//            .staggerFrom(tagline, 0.5, {top:"-=30px", rotation:"-40deg", 
//                alpha:0, scale:1.8, ease:Back.easeOut}, 0.2);          
        
        
        
                
    } else {
        //jQuery('.navigation .l_bases').click();
    }
    /// END: IS MOBILE ///
    

    
    
    //vinos scroll
        //SALUD
        
    jQuery('.commontext .vtfram').each(function(i,e){
        jQuery(e).sly({
                    scrollBy: 100,  //pixels or items
                    speed: 200,   //millis
                    //easing: 'easeOutQuart',   //jquery.easing
                    scrollBar: jQuery(e).parent().find('.scrollbar'),

                    dynamicHandle: 1,    //resize handle
                    dragHandle: 1,
                    clickBar: 1,

                    mouseDragging: 1,
                    touchDragging: 1,
                    releaseSwing: 1
                });
    });
        
    
    
    (function(){
        
        var tlVinosTodos = new TimelineMax({paused:true});
        
        if(isMobile){
            
            tlVinosTodos.addLabel('crianza');
            
            tlVinosTodos.fromTo('.section.vinos .botella_crianza .cover', 1, {opacity:"0.0"}, {opacity:"1.0"}, 0 );
            tlVinosTodos.fromTo('.section.vinos .botella_crianza', 1, {top:"0px"},  {top:"-525px"}, 0 );
            tlVinosTodos.fromTo('.botones_vinos .boton.crianza', 1, {top:"386px"}, {top:"10px"}, 0 );
            tlVinosTodos.fromTo('.botones_vinos .shape_vinos', 1, {top:"50px"}, {top:"190px"}, 0);
            tlVinosTodos.fromTo('.botones_vinos .texto_crianza', 1, {top:"-42px"}, {top:"-1000px"}, 0);
            
            tlVinosTodos.addLabel('ninguno');
            
            tlVinosTodos.fromTo('.section.vinos .botella_reserva .cover', 1, {opacity:"1.0"}, {opacity:"0.0"}, 1 );
            tlVinosTodos.fromTo('.section.vinos .botella_reserva', 1, {top:"135px"},  {top:"-206px"}, 1 );
            tlVinosTodos.fromTo('.botones_vinos .boton.reserva', 1, {top:"386px"}, {top:"10px"}, 1 );
            tlVinosTodos.fromTo('.botones_vinos .shape_vinos', 1, {top:"190px"}, {top:"50px"}, 1);
            tlVinosTodos.fromTo('.botones_vinos .texto_reserva', 1, {top:"1000px"}, {top:"-42px"}, 1);
            
            tlVinosTodos.addLabel('reserva');
            
        } else { 
       
            jQuery('.section.vinos .botella_crianza .cover').css( {opacity:"0.0"} );
            jQuery('.section.vinos .botella_crianza').css( {top:"-241px"} );
            jQuery('.botones_vinos .boton.crianza').css( {top:"416px"} );
            jQuery('.botones_vinos .boton.reserva').css( {top:"416px"} );

            jQuery('.botones_vinos .texto_crianza').css( {top:"0px"} );
            jQuery('.botones_vinos .texto_intro').css( {top:"1000px"} );
            jQuery('.botones_vinos .texto_reserva').css( {top:"1000px"} );

            var tlVinosTodos = new TimelineMax({paused:true});

            tlVinosTodos.addLabel('crianza');
            
            tlVinosTodos.to('.section.vinos .botella_crianza .cover', 1, {opacity:"1.0"}, 0 );
            tlVinosTodos.to('.section.vinos .botella_crianza', 1, {top:"-525px"}, 0 );
            tlVinosTodos.to('.botones_vinos .texto_crianza', 1, {top:"-1000px"}, 0 );
            tlVinosTodos.to('.botones_vinos .boton.crianza', 1, {top:"10px"}, 0 );

            tlVinosTodos.to('.botones_vinos .texto_intro', 1, {top:"0px"}, 0 );
            tlVinosTodos.fromTo('.botones_vinos .texto_crianza', 1, {top:"0px"}, {top:"-1000px"}, 0 );
           
            tlVinosTodos.addLabel('ninguno');
                
            tlVinosTodos.to('.section.vinos .botella_reserva .cover', 1, {opacity:"0.0"}, 1 );
            tlVinosTodos.to('.section.vinos .botella_reserva', 1, {top:"-195px"}, 1 );
            tlVinosTodos.to('.botones_vinos .texto_reserva', 1, {top:"0px"}, 1 );
            tlVinosTodos.to('.botones_vinos .boton.reserva', 1, {top:"10px"}, 1 );

            tlVinosTodos.to('.botones_vinos .texto_intro', 1, {top:"-1000px"}, 1 );
            tlVinosTodos.to('.botones_vinos .texto_reserva', 1, {top:"0px"}, 1 );
            
            tlVinosTodos.addLabel('reserva');  
            
        }

        
        tlVinosTodos.seek('ninguno');  

        jQuery('.botones_vinos .boton.crianza').click(
            function(){ 
                if(tlVinosTodos.currentLabel()=='crianza') tlVinosTodos.tweenTo('ninguno'); 
                else tlVinosTodos.tweenTo('crianza'); 
            }
        );

        jQuery('.botones_vinos .boton.reserva').click(
            function(){ 
                if(tlVinosTodos.currentLabel()=='reserva') tlVinosTodos.tweenTo('ninguno'); 
                else tlVinosTodos.tweenTo('reserva'); 
            }
        );     
        
        
        
            
    })();
    






    
    //SONIDO COPAS
    var copas_ready_count = 0;
    var canPlayAudio = false;
    var canAnimateCopas = true;
    
    function sonido_copas(funcion){
        if(canAnimateCopas) { 
            canAnimateCopas = false;
        } else {
            return;
        }
        
        var pngcopa_i = 0;
        var pngcopa = jQuery('.anim_copas_sp');
        var audio = null;
        
        if(canPlayAudio){
            audio = jQuery('audio').get(0);
            audio.pause();
            audio.currentTime = 0;
        }
        
        var anim_copa = setInterval(function(){
            if(++pngcopa_i>23) { 
                clearInterval(anim_copa);
                canAnimateCopas = true;
                return;
            }
            
            if(pngcopa_i==8){
                if(canPlayAudio){
                    audio.play();
                }
                funcion();
            }
            
            pngcopa.css({backgroundPosition:'left '+(pngcopa_i*-244)+'px'});
        }, 50);
        
    };    
    
    //INTRO: FOTO
    jQuery('.section.intro .showpic')
            .data({o_page:0, o_pages: piclist.length});
            //jQuery('.section.intro .picdot').size()
            
    function show_brindis(diff, obj){
        sonido_copas(function(){
            var oData = jQuery('.section.intro .showpic').data();
            oData.o_page += diff;
            if(oData.o_page<0) oData.o_page = oData.o_pages-1;
            if(oData.o_page>oData.o_pages-1) oData.o_page = 0;
            
            var src = '';
            var index = 0;
            
            if(obj===undefined){
                //src = jQuery('.section.intro .picdot img').eq(oData.o_page).attr('src');
                index = oData.o_page;
                src = piclist[index]['photo'];
            } else {
                src = jQuery(obj).find('img').attr('src');
                index = jQuery('.section.intro .picdot').index(obj);
            }
            
            jQuery('.section.intro .showpic img').attr('src', src);
            
            
            var igcaption = jQuery('.section.intro .igcaption');
            igcaption.find('h3').html(piclist[index]['author']);
            igcaption.find('p').html(piclist[index]['caption']);
     
            if(piclist[index]['haslikes']){
                igcaption.find('blockquote').show().html(piclist[index]['likes']);
            } else {
                igcaption.find('blockquote').hide().html('');
            }
            
            return false;
        });
    }
    
    
    jQuery('audio').one('canplay', function(){ canPlayAudio = true; sonido_copas(function(){}); }); 
    
   
    
    jQuery('.section.intro .showpic .home_flecha1_l').on('touchstart mousedown', function(){
        show_brindis(-1);
    });
    jQuery('.section.intro .showpic .home_flecha1').on('touchstart mousedown', function(){
        show_brindis(+1);
    });
    jQuery('.section.intro .picdot').on('touchstart mousedown', function(){
        show_brindis(0,this);
    });    
    
    
     
    
    
    
    
    
  
    //SOMMELIER: PAGINACION
    jQuery('.section.sommelier .paginate')
            .data({o_page:0, o_pages: jQuery('.section.sommelier .pregunta').size()});
    function show_pregunta(diff){
        var oData = jQuery('.section.sommelier .paginate').data();
        oData.o_page += diff;
        if(oData.o_page<0) oData.o_page = oData.o_pages-1;
        if(oData.o_page>oData.o_pages-1) oData.o_page = 0;
        jQuery('.section.sommelier .pregunta').hide().eq(oData.o_page).show();
        jQuery('.section.sommelier .paginate span').html(oData.o_page+1);
        return false;
    }
    show_pregunta(0);
    jQuery('.section.sommelier .paginate .prev').click(function(){
        show_pregunta(-1);
    });
    jQuery('.section.sommelier .paginate .next').click(function(){
        show_pregunta(+1);
    });
    
    
    
    //ENVIA TU PREGUNTA AL SOMMELIER
    jQuery('.sommelier .preguntas .redbtn').click(function(){
        jQuery('.sommelier .preguntas, .sommelier .formulario')
            .removeClass('hide_block')
            .hide();
        jQuery('.sommelier .formulario').show();
        jQuery('.sommelier .formulario textarea').val('');
    });
    

    

    //SALUD
    var brindisSly = null; 
    brindisSly = new Sly('.brindis_frame',{
        //interactive: '.controls',   //not draggable
        //horizontal: true, 

        smart: true,
        moveBy: 400,
        cycleBy: 'items',
        cycleInterval: 0,

        itemNav: 'basic',

        scrollBy: 1,  //pixels or items
        speed: 333,   //millis
        //easing: 'easeOutQuart',   //jquery.easing

        //dynamicHandle: 1,    //resize handle
        dragHandle: 1,
        clickBar: 1,

        mouseDragging: 1,
        touchDragging: 1,
        releaseSwing: 1
    });
    
    TweenMax.to('.section.salud .click_scroll', 0.5, {top:'-=6px', repeat:-1, yoyo:true});

    jQuery('.section.salud .click_scroll')
    .data({o_clicks:99,o_top:'94px',o_mid:true})
    .click('click', function(){
        var oData = jQuery(this).data();
        
        if(oData.o_mid){
            jQuery('.section.salud .shape_salud_wrap').animate({top:0});
            
            TweenMax.killTweensOf('.section.salud .click_scroll');
            TweenMax.to('.section.salud .click_scroll', 0.5, {top:'517px', 
                onComplete:function(){
                    TweenMax.killTweensOf('.section.salud .click_scroll');
                    TweenMax.to('.section.salud .click_scroll', 0.5, {top:'-=6px', repeat:-1, yoyo:true});
                }});
            
            jQuery('.section.salud .brindis_lista').animate({top:oData.o_top});
            oData.o_mid = false;
            brindisSly.init();
                        brindisSly.toStart(); 

        }
        
        if(oData.o_clicks<=4){
            brindisSly.activate(++oData.o_clicks); 
        } else {
            brindisSly.activate(oData.o_clicks=0); 
        }
    });



    jQuery('.section.salud .shape_salud').one('mousewheel', function(event) {
        jQuery('.section.salud .shape_salud .scroll').click();
    });


    
    //VINOS
    function texto_vino(index){
        var textos = ['.botones_vinos .texto_crianza',
            '.botones_vinos .texto_intro',
            '.botones_vinos .texto_reserva'];
        
        var elementos = jQuery('.botones_vinos')
                .find(textos.join(','));
        
        switch(index){
            case 0:
                jQuery(textos[0]).switchClass('out','');
                jQuery(textos[1]).switchClass('','txtdn');
                break;
            case 1:
                jQuery(textos[0]).switchClass('','out');
                jQuery(textos[2]).switchClass('','out');
                jQuery(textos[1]).switchClass('txtup','');
                jQuery(textos[1]).switchClass('txtdn','');
                break;
            case 2:
                jQuery(textos[2]).switchClass('out','');
                jQuery(textos[1]).switchClass('','txtup');
                break;
                
        }
        
    }
    
    
    if(false && !isMobile){
        jQuery('.botella_crianza').hover(
            function(){jQuery(this).add('*',this).switchClass('off','on'); texto_vino(0); },
            function(){jQuery(this).add('*',this).switchClass('on','off'); texto_vino(1); });

        jQuery('.botella_reserva').hover(
            function(){jQuery(this).add('*',this).switchClass('off','on'); texto_vino(2); },
            function(){jQuery(this).add('*',this).switchClass('on','off'); texto_vino(1); });
    }
    
 
    
    
    
    
    //BASES Y CONTACTOS
    jQuery('.section.bases .shape_bases a').click(function(){
        jQuery('.texto_bases, .texto_contacto')
            .removeClass('hide_block')
            .hide();
    
        var innerSection = jQuery(this).attr('data-show');
        jQuery('.'+innerSection).show();
        
        if(innerSection=='texto_contacto'){
            jQuery('.section.bases textarea').val('');
        }
    });
    
    
    
    
    
    //cerrar enviar pregunta
    jQuery('.section.sommelier .closeForm').click(function(){
        jQuery('.sommelier .preguntas, .sommelier .formulario')
            .removeClass('hide_block')
            .hide();
        jQuery('.sommelier .preguntas').show();
    });
        
    //cerrar enviar contacto
    jQuery('.section.bases .closeForm').click(function(){
        jQuery('.texto_bases, .texto_contacto')
            .removeClass('hide_block')
            .hide();
        jQuery('.texto_bases').show();
    });
        
    
    
    //terminos y condiciones
    jQuery('.lnkTyC').click(function(){
        jQuery('.termsConds').show();
        return false;
    });
    jQuery('.termsConds .closeForm').click(function(){
        jQuery('.termsConds').hide();
    });
        
        
        
    
    
    
	jQuery("#form_sommelier").validate({
	   errorElement: 'span',
            submitHandler: function(form) {
                    jQuery.post('assets/lib/send_form.php?sommelier', jQuery(form).serializeArray(),
                    function(data){
                        //console.log(data);
                    });
                    
                    jQuery('.sommelier .preguntas, .sommelier .formulario')
                        .removeClass('hide_block')
                        .hide();
                    
                    jQuery('.section.sommelier .gracias')
                            .animate({top:'-=700px'})
                            .delay(1500)
                            .animate({top:'+=700px'}, function(){
                                jQuery('.sommelier .preguntas').show();
                            });
                    
                    return false;	
            },
            rules: {
                    nombre: {
                            required: true,
                            minlength: 2
                    },
                    email: {
                            required: true,
                            email: true
                    },
                    pregunta: {
                            minlength: 12,
                            required: true
                    },
                    tyc: {
                            required: true
                    }
            }
	});
    
    
	jQuery("#form_contactos").validate({
	   errorElement: 'span',
            submitHandler: function(form) {
                    jQuery.post('assets/lib/send_form.php', jQuery(form).serializeArray());
                    
                    jQuery('.texto_bases, .texto_contacto')
                        .removeClass('hide_block')
                        .hide();
                    
                    jQuery('.section.bases .gracias')
                            .animate({top:'-=700px'})
                            .delay(1500)
                            .animate({top:'+=700px'}, function(){
                                jQuery('.texto_bases').show();
                            });
                    
                    return false;	
            },
            rules: {
                    nombre: {
                            required: true,
                            minlength: 2
                    },
                    email: {
                            required: true,
                            email: true
                    },
                    pregunta: {
                            minlength: 12,
                            required: true
                    },
                    tyc: {
                            required: true
                    }
            }
	});
    
    
    
    // ***** PARALLAX THINGS *****
    
    //NUBES
    (function(){
        
        var nubelems = jQuery('.bg_parallax img.nub1,'
            +'.bg_parallax img.nub2,'
            +'.bg_parallax img.nub3,'
            +'.bg_parallax img.nub4,'
            +'.bg_parallax img.nubg'
            );
        var nubes = [];
        nubelems.each(function(i,e){
            nubes.push(jQuery(e).position().left) ;
        });
        
        
        //+'.bg_parallax img.nubs'

        // INFINITE LOOPS
        nubelems.css({left:'+=600px'});
        (function(){
            function runIt(){
                nubelems.delay(0).animate({left:'-=1px'},100,runIt);
            }
            runIt();
        })();
        
        TweenMax.to('.bg_parallax img.nubs', 2, {top:'-=30px', repeat:-1, yoyo:true});
        
    })();
    
//    jQuery('.l_sommelier').click();
//    jQuery('.section.sommelier .redbtn').click();
    
});