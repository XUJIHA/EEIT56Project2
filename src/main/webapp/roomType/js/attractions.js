$(function(){
    $('.delete').click(function(){
		let id=$(this).attr("id");
		//console.log(id);
	    Swal.fire({
		  title: 'Are you sure?',
		  text: "You won't be able to revert this!",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Yes, delete it!'
		}).then((result) => {
// 			console.log(result)
		  if (result.isConfirmed) {
// 			$.get('/jspExercise/deleteServlet',{id:id},function (result) {
// 				$("#div10").html(result);
// 				$("#div11").hide();
// 				console.log(result)
// 				//location.reload();
//                 })
		  console.log(id)
			$.ajax({
			  url:'/jspExercise/deleteServlet',
			  method:"get",
			  dataType:"text",
			  data: {"id":id},
			  success:function(res){console.log(res)
				  console.log("delete")
				  location.reload();},
			  error:function(err){console.log(err)},

			})
		    Swal.fire(
		      'Deleted!',
		      'Your file has been deleted.',
		      'success'
		    )
		  }
		})
    })
        //
         $('.img').click(function(){
         	let id=$(this).attr("src");
		 	console.log(id);
	        Swal.fire({
			  imageUrl: id,//'https://placeholder.pics/svg/300x1500'
			  imageHeight: 500,
			  imageAlt: 'image'
			})
		});
       
});