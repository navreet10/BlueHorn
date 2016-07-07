/**
 * 
 */

 $(document).ready(function(){
	 var rem = 141;
	 $("#text").html(rem + " characters remaining");
	 $("#post").keyup(function() {
		 var rem = 141 - $("#post").val().length;
		 $("#text").html(rem + " characters remaining");
	 });
	 $( "#target" ).submit(function( event ) {
		  if($("#search").val() != "") {
			  event.preventDefault();
			  var dataString ='search='+ $("#search").val();
			  $.ajax({  
				    type: "POST",  
				    url: "Search",
                    data: dataString,
	                success: function(data){
	                    window.location = 'http://localhost:8080/BlueHorn/SearchResults.jsp';
	                  }                
				  });
		  }  else if ($("#post").val() == "") {
			  alert('Empty Post');
			  event.preventDefault();
		  } else if ($("#post").val().length >141){
			  alert('More than 141 characters');
			  event.preventDefault();
		  }
		  
		});
}); 

