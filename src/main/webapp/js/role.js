$(document).ready(function(){
	
	$('.btn-xoa').click(function(){
		
		//$(this) // đại diện cho thẻ đang click
		
		var id = $(this).attr("id-role")
		var This = $(this)
		
		$.ajax({
		  method: "GET",
		  url: `http://localhost:8080/crm_project_22/api/role/delete?id=${id}`,
		  //data: { name: "John", location: "Boston" }
		})
		  .done(function( result ) {
			  console.log(result, "data", result.data);
		    	if(result.data == true){
					//This.parent().parent().remove()
					This.closest('tr').remove();
				}
		  });
	})
})