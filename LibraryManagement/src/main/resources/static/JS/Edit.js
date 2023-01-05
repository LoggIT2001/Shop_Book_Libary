/**
 * 
 */
var loadFile = function(event){
	var image = document.getElementById("imm");
	image.src = URL.createObjectURL(event.target.files[0]);
};	 
var buttonedit = document.getElementById("btnedit");
if(buttonedit.value==="Save Book"){
   document.getElementById('title').disabled = false;
   document.getElementById('author').disabled = false;
   document.getElementById('category').disabled = false;
   document.getElementById('description').disabled = false;
   document.getElementById('re_date').disabled = false;
   document.getElementById('page').disabled = false;
   document.getElementById('price').disabled = false;
   document.getElementById('image').disabled = false;
}; 