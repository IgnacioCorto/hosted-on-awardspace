
//Muestra un nodo, o lo oculta recursivamente con hideChilds()
//Formato: node1_2_3
//Usar jQuery 1.2 para IE6

function showChilds(obj,n_nodo) {

    var selector = new RegExp('^'+n_nodo+'_[0-9]+$','gi') ;
    
    var padre = $(obj); //.parent('tr');
    var tree_sign = padre.find('td>span.tree_sign');
    
    var allChilds
        = padre.nextAll('[id^='+n_nodo+']')
               .filter(function() {
                    //alert(this.id);
                    return this.id.match(selector);
               });
    

    if(allChilds.filter(':visible').length>0) {
        tree_sign.text('+');
        allChilds.hide();
        allChilds.each( function(i,e){
            hideChilds(e,e.id);
            } );
    }
    else{
        tree_sign.text('-');
        allChilds.show();
    }
    
    drawZebra();
   
}


//igual que showChilds(), pero sin el show();

function hideChilds(obj,n_nodo) {

    var selector = new RegExp('^'+n_nodo+'_[0-9]+$','gi') ;
    
    var padre = $(obj); //.parent('tr');
    var tree_sign = padre.find('td>span.tree_sign');
    
    var allChilds
        = padre.nextAll('[id^='+n_nodo+']')
               .filter(function() {
                    //alert(this.id);
                    return this.id.match(selector);
               });
    

    if(allChilds.filter(':visible').length>0) {
        tree_sign.text('+');
        allChilds.hide();
        allChilds.each( function(i,e){
            hideChilds(e,e.id);
            } );
    }

}

//Para dibujar una Tabla Zebra

function drawZebra() {
    var tr_list = $('table.ReportTable tr').not('gvfooterstyle');
    var tr_list_visible = tr_list        .filter('tr:visible');
    var tr_list_zebras  = tr_list_visible.filter('tr:even');

    tr_list.removeClass('gvalternatingrowstyle');    
    tr_list_zebras.addClass('gvalternatingrowstyle');    
}

$(function(){ drawZebra(); })