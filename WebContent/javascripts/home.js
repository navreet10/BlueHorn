/**
 * 
 */

 $(document).ready(function(){
	 var rem = 141;
	 $('.repliesDiv').hide();
	 $('.commentsDiv').hide();
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
	 var called = false;
	 $('.likeLinks').click(function (event) {
		 if (!called) {
			 var idPost = $(this).attr('id');
			 var dataString ='idPost='+ idPost;
			 $.ajax({  
				    type: "POST",  
				    url: "Like",
	             data: dataString,
	             success: function(data){
	                 window.location = 'http://localhost:8080/BlueHorn/home.jsp';
	               }                
				  });
			 called = true;
		 }
		 
		 
	 });
	 $('.replyLinks').click(function (event) {
			 var idPost = $(this).attr('id');
			 var id = 'writeReply' + idPost.substring(9);
			 $("#"+id).show();
		 
		 
	 });
	 $('.replyButton').click(function (event) {
			 var idPost = $(this).attr('id');
			 var id = 'replyContenet' + idPost.substring(12);
			 var dataString ='idPost='+ idPost + "&posttext=" + $ ("#" + id).val();
			 
			 $.ajax({  
				    type: "POST",  
				    url: "Reply",
	             data: dataString,
	             success: function(data){
	                 window.location = 'http://localhost:8080/BlueHorn/home.jsp';
	               }                
				  });
			
		 
		 
	 });
	 $('.commentLinks').click(function (event) {
		
			 var idPost = $(this).attr('id');
			 var id = 'seeComments'+idPost.substring(8);
			 
			 $("#"+id).show();	
			 
		 
		 
	 });
	 
	 // news feed/////////////////////////
	 
	 called = false;
	 $('.likeLinksN').click(function (event) {
		 alert( " in");
		 if (!called) {
			 var idPost = $(this).attr('id');
			 var dataString ='idPost='+ idPost;
			 $.ajax({  
				    type: "POST",  
				    url: "Like",
	             data: dataString,
	             success: function(data){
	                 window.location = 'http://localhost:8080/BlueHorn/newsFeed.jsp';
	               }                
				  });
			 called = true;
		 }
		 
		 
	 });
	 $('.replyLinksN').click(function (event) {
			 var idPost = $(this).attr('id');
			 var id = 'writeReply' + idPost.substring(9);
			 $("#"+id).show();
		 
		 
	 });
	 $('.replyButtonN').click(function (event) {
			 var idPost = $(this).attr('id');
			 var id = 'replyContenet' + idPost.substring(12);
			 var dataString ='idPost='+ idPost + "&posttext=" + $ ("#" + id).val();
			 
			 $.ajax({  
				    type: "POST",  
				    url: "Reply",
	             data: dataString,
	             success: function(data){
	                 window.location = 'http://localhost:8080/BlueHorn/newsFeed.jsp';
	               }                
				  });
			
		 
		 
	 });
	 $('.commentLinksN').click(function (event) {
		
			 var idPost = $(this).attr('id');
			 var id = 'seeComments'+idPost.substring(8);
			 
			 $("#"+id).show();	
			 
		 
		 
	 });
}); 

