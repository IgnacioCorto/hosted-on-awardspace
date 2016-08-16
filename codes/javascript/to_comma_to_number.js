
// from Numbers to Commas
function alFormato(numero,decimales) {
	nStr = String( numero.toFixed(decimales) );
	x = nStr.split('.');
	x1 = x[0];
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(x1)) {
		x1 = x1.replace(rgx, '$1' + ',' + '$2');
	}
	
	return x1 + x2;
}


// from Commas to Numbers
function alNumero(cadena) {
	return Number( cadena.replace(/,/g,'') );
}
