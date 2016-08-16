//JavaScript Document

jQuery(document).ready( function() {

   jQuery("a.update_timestamp").click( function() {
      jQuery.ajax({
         type : "post",
         dataType : "json",
         url : myAjax.ajaxurl,
         data : {action: "adv_my_update_timestamp", creator : 'Ignacio Cortorreal'}  /*,
         success: function(response) {
            if(response.type == "success") {
               jQuery("div.current_timestamp").html(response.timestamp)
            }
            else {
               alert("Your vote could not be added. "+response.type
			   		+", "+response.timestamp)
            }
         }*/
      }).done(function(response){
			jQuery("div.current_timestamp").html(response.timestamp)
	  })  
	  
	  return false; 
   })

});
