// SEE: http://stackoverflow.com/questions/8822907/html5-cross-browser-iframe-postmessage-child-to-parent


// CSS
/*
html,body{margin:0;padding:0; overflow: hidden;}
#resizable { width:400px; height:100px; border:10px solid blue; } 
*/


// PARENT FRAME

var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
var eventer = window[eventMethod];
var messageEvent = eventMethod == "attachEvent" ? "onmessage" : "message";

eventer(messageEvent,function(e) {
    var data = e.message ? "message" : "data" ;
    console.log(e[data]); //run function//
    
    jQuery('#iframeignaciolocal').height(e[data].height+50);
    
}, false);


// CHILD FRAME

jQuery(function(){
    
    setInterval(function(){

        var newheight = Math.round(Math.random()*10)*100;
        document.getElementById('resizable').style.height = newheight+'px';
        
        var height_v2 = jQuery('html,body').height();

        parent.postMessage({height:height_v2},"*");
        console.log(new URL(document.referrer).hostname, height_v2); //HOSTNAME

    },1000);    
    
});


// ORIGINAL CHILD EXAMPLE
parent.postMessage("loadMyOrders","*");  //  `*` on any domain  

