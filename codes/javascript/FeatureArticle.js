// JavaScript Document


// FEATURE TABS
function showFeaturedTab(jstab,obj) {
	jQuery('.FeaturedTabs li').removeClass('selected');
	jQuery('.jsFeatureBox').hide();
	jQuery('.'+jstab).show();
	jQuery(obj).parent().addClass('selected');
}
showFeaturedTab('jsArticles', jQuery('#defaultFeatureTab') );


// FEATURE ARTICLES
function mostrarFeatured(id) {
	jQuery('.featurelist').hide().eq(id).show();
	jQuery('.featurelist_pag a').removeClass('selected');
	jQuery('.featurelist_pag a#fal'+id).addClass('selected');
}

jQuery('.featurelist').each( function(i,e){
	jQuery('.featurelist_pag').append('<li><a href="javascript:void(0);" id="fal'+i+'" onclick="mostrarFeatured('+i+')">'+(i+1)+'</a></li>');
} ) ;

mostrarFeatured(0);



// F***ING TEASERS
function mostrarTeaser(id) {
	jQuery('.TeaserElement').hide().eq(id).show();
	jQuery('.TeaserPag a').removeClass('selected');
	jQuery('.TeaserPag a#ttl'+id).addClass('selected');
}

jQuery('.TeaserElement').each( function(i,e){
	jQuery('.TeaserPag').append('<li><a href="javascript:void(0);" id="ttl'+i+'" onclick="mostrarTeaser('+i+')">'+(i+1)+'</a></li>');
} ) ;

mostrarTeaser(0);




// FECHAS
jQuery('div.fechota').each( function(i,e){
	datosFecha = jQuery(e).children('.fecha1').text().toString().split('/');
	
	dia = datosFecha[1];
	switch( Number(datosFecha[0]) ) {
		case 1: mes='Ene' ; break;
		case 2: mes='Feb' ; break;
		case 3: mes='Mar' ; break;
		case 4: mes='Abr' ; break;
		case 5: mes='May' ; break;
		case 6: mes='Jun' ; break;
		case 7: mes='Jul' ; break;
		case 8: mes='Ago' ; break;
		case 9: mes='Sep' ; break;
		case 10: mes='Oct' ; break;
		case 11: mes='Nov' ; break;
		case 12: mes='Div' ; break;
	}
	
	jQuery(e).children('.mes1').text(mes);
	jQuery(e).children('.dia2').text(dia);
	jQuery(e).children('.fecha1').hide();
	
});






// VISITADO OPINADO VOTADO
function showLosMasTab(jstab,obj) {
	jQuery('.LosMas li').removeClass('selected');
	jQuery('.jsLosMasBox').hide();
	jQuery('.'+jstab).show();
	jQuery(obj).parent().addClass('selected');
}
showLosMasTab('jsVisitados', jQuery('#defaultLosMasTab') );






// RECENT NEWS
currentNews = 0 ;

function mostrarNews(id) {
	jQuery('.newslist').hide().eq(id).show();
}


function mostrarPrevNews(obj) {
	if(currentNews>0) {
		currentNews--;
		mostrarNews(currentNews);
	} 
	esconderPrevNextNewsButtons(); 
}

function mostrarNextNews(obj) {
	if(currentNews < (jQuery('.newslist').size()-1) ) {
		currentNews++;
		mostrarNews(currentNews);
	} 
	esconderPrevNextNewsButtons(); 
}

function esconderPrevNextNewsButtons() {
	$('.newsListPrev, .newsListNext').css('visibility','visible');
	if( currentNews==0 ) 
		$('.newsListPrev').css('visibility','hidden');
	if( currentNews==(jQuery('.newslist').size()-1) ) 
		$('.newsListNext').css('visibility','hidden');
}


jQuery('.newslist_pag')
	.append('<li><a onclick="mostrarPrevNews(this)" class="newsListPrev" href="javascript:void(0);" > &laquo; Anterior </a></li>')
	.append('<li><a onclick="mostrarNextNews(this)" class="newsListNext" href="javascript:void(0);" > Siguiente &raquo; </a></li>');

mostrarNews(0);
esconderPrevNextNewsButtons(); 








