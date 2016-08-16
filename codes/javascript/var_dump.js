//array of properties of an object
function var_dump(obj){
	var out=new Array();
	var i=0;
	for(x in obj) {
	   out[i] = x;
	   i++;
	}
	return out.sort();
}
//var_dump(cantidades);