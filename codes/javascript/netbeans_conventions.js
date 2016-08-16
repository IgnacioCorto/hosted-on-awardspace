//new this return  <-- para usar FUNCTION como CLASS

/*var IgnacioClase = function() { /**/
function IgnacioClase() { /**/

    //PRIVADOS
    var var1 = 1;
    function method1() {
        console.log(1);
    };/**/

    //ESTATICOS
    IgnacioClase.var2 = 2;
    IgnacioClase.method2 = function() {
        console.log(2);
    };/**/

    //PUBLICOS
    this.var3 = 3;
    this.method3 = function() {
        console.log(3);
    };/**/

    //PROCESOS
    console.log(4);/**/

    //ESCONDIDO DEL NAVIGATOR
    return {
        run: function() {
            console.log(5);
            method1();
        }
    };/**/
    
    //ESCONDIDO DEL NAVIGATOR
    /*return function(){
        this.run = function() {
            console.log(5);
            method1();
        };
    };/**/    
    
    
};

var obj_global = {
    variable: "dato",
    funcion: function() {
    }
};



console.log(this);

var obj = new IgnacioClase();
console.log(obj);
//obj.run();          //RETURN METHOD 1
//(new obj()).run();  //RETURN METHOD 2
//obj(); run();       //POLUTES NAMESPACE

/*IgnacioClase(); /**/
console.log(var3);
method3(); /**/
