(function(){
  var div_id = 'ign_holder';
  var script_id = 'ign_script';

	function loadXMLString(txt)
	{
		try //Internet Explorer
		{
			xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			xmlDoc.async="false";
			xmlDoc.loadXML(txt);
			return xmlDoc;
		}
		catch(e)
		{
			try //Firefox, Mozilla, Opera, etc.
			{
				parser=new DOMParser();
				xmlDoc=parser.parseFromString(txt,"text/xml");
				return xmlDoc;
			}
			catch(e) {alert(e.message)}
		}
		
		return null;
	}   
  
  function dotree(id,level,parents){
    //if(counter>50) return; else counter++;
    //if(parents.length>3) return;
    var level = level*1;

    switch(id){
      case 112: id=772; break;
      case 8: id=770; break;
      case 113: id=771; break;
      case 78: id=774; break;
      case 54: id=773; break;
    }
	
    if(parents.indexOf(id)>-1 ) { return '';};
  
    var ignxml = loadXMLString(IT[id]);
	if(ignxml==undefined || ignxml==null) {console.log(IT[id]); return '';}
	
	try{
    var name = ignxml.getElementsByTagName('name')
        [0].childNodes[0].nodeValue;
    var shop = ignxml.getElementsByTagName('shop')
        [0].childNodes[0].nodeValue;
    var type = ignxml.getElementsByTagName('type')
        [0].childNodes[0].nodeValue;
    var price = ignxml.getElementsByTagName('price')
        [0].childNodes[0].nodeValue;
	}catch(e){ return 'ID here: '+id+' <a href="/items" target="_blank">Items/Recipes</a><br clear="all" />'; }
    
    //console.log(level+' '+id, parents, '$', price, ' -- ', name, ' -- ', shop);
    //if(level==' - -') bigitems.set(parents[0], name+' -- '+shop);
    //return;

    var output 
      ='<img src="http://media.playdota.com/items/'+id+'/thumb.jpg" align="left" style="padding:0 5px 0 '+(level*18)+'px;" />'  
      +'<b>$'+price+'</b> &nbsp;  &nbsp; ('+id+') <br />'
      +name+'<br /> <i>'+shop+'</i> <br clear="all" />';
    
    var ta = parents.clone();
    ta.push(id);

    if(type!='basic') {
		try{
		
		for(x in ignxml.getElementsByTagName('rkey')){
		  var cid = 1*ignxml.getElementsByTagName('rkey')[x*1]
		    .childNodes[0].nodeValue;
		  var ctxt = ignxml.getElementsByTagName('rtext')[x*1]
		    .childNodes[0].nodeValue;
		  if(ctxt!='none') {
			  output += "<b>"+ctxt+"</b><br />";
			  //console.log(cid, ctxt);
		  }
		  var data = dotree(cid,level+1,ta);
		  if(data!=undefined) output += data;
		}
		}catch(e){ /*console.log(e);*/ }
	}

    return output;     
  }


  //console.log('testing');
  //console.log($$('img.tcattdimgresizer').size());


  $$('#'+div_id).each(function(e,i){e.remove();});
  document.getElementsByTagName('body')[0]
    .appendChild(
       new Element('div', { 'id': div_id}).hide().update('X')
    );

  $$('#'+script_id).each(function(e,i){e.remove();});
  document.getElementsByTagName('body')[0]
    .appendChild(
       new Element('script', { 'id': script_id,
         'src':'http://www.playdota.com/cache/items.js?'+(new Date().getTime()),
         'onload':"alert('loaded')"
       })
    );

  $$('img.tcattdimgresizer, a[id^=it] img').each(function(e,i){
    e.stopObserving();
    e.observe('click',function(event){
      var iid = /items\/(\d+)\/thumb\.jpg/.exec(e.src)[1]*1;
      var x = Event.pointerX(event);
      var y = Event.pointerY(event);
      var content = '<a href="javascript:void(0);" onclick="$(this).up().toggle();" style="float:right;">[X}</a>'
		+'<span style="display:none;">'+iid+'</span>'
		;

      $$('#'+div_id+' span').each(function(e,i){
        //console.log(iid,e.innerHTML,e.innerHTML==iid);
        if(e.innerHTML!=iid) $(div_id).hide();
      });

	  var dotree_rst = dotree(iid,0,[]);
	  
      $(div_id)
        .update(content+dotree_rst)
        .setStyle({
            background:'red',
            padding:'5px',
            position:'absolute',
            left:(x+48)+'px',
            top:(y-48)+'px',
            width:'222px',
            font:'10px/10px Arial'
        });

      $(div_id).toggle();
    
      //console.log(content);
      //console.log(dotree(iid,0,[]));
      //console.log(IT[iid]);
    });
    
  });

  return;
})();