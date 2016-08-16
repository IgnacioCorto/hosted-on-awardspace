                                               
// *thanks to javascriptkit*                   //   [ B A S I C ]


function cat(name) {                           // ### DEFINING A CLASS ###
	this.name = name;
	this.talk = function() {
		alert( this.name + " say meeow!" )
	}
} 


cat1 = new cat("felix");                       // ### CONSTRUCTING OBJECTS ### 
cat1.talk() //alerts "felix says meeow!";

cat2 = new cat("ginger");
cat2.talk() //alerts "ginger says meeow!";


cat.prototype.changeName = function(name) {    // ### ADDING CLASS METHODS ### 
	this.name = name;               
}


firstCat = new cat("pursur");                  // ### INSTANTIATE OBJECT ### 
firstCat.changeName("Bill");
firstCat.talk() //alerts "Bill says meeow!"



// *thanks to webreference*          //   [ A D V A N C E D ]


function superClass() {              // ### NORMAL SUPER CLASS 1 ### 
  this.supertest = superTest;  
}

function ignaClass() {               // ### NORMAL SUPER CLASS 2 ### 
  this.ignatest = ignaTest;  
}

function subClass() {
  this.inheritFrom = superClass;
  this.inheritFrom();               // ### INHERITING 1ST CLASS ### 
  this.inheritFrom = ignaClass;
  this.inheritFrom();               // ### INHERITING 2ND CLASS ### 

  this.subtest = subTest;           // ### ATTACHING METHOD subTest ### 
}

function superTest() {              // ### METHOD 1 DECLARATION ### 
  return "superTest";
}
  
function subTest() {                // ### METHOD 2 DECLARATION ### 
  return "subTest";
}

function ignaTest() {               // ### METHOD 3 DECLARATION ### 
  return "ignaTest";
}

 var newClass = new subClass();     // ### INSTATIATING 'subClass' ### 

  alert(newClass.subtest());        // yields "subTest"
  alert(newClass.supertest());      // yields "superTest"
  alert(newClass.ignatest());       // yields "ignaTest"


