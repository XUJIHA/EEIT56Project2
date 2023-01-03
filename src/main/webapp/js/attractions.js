$(function(){
        $('.delete').click(function(){
            let id=$(this).attr("id");
            Swal.fire({
              title: 'Are you sure?',
              text: "You won't be able to revert this!",
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
              	console.log(id)
        $.ajax({
              url:'/Team3_Hibernate/deleteServlet',
              method:"post",
              dataType:"text",
              data: {"id":id},
        })
            .done(function () {
                location.reload();
                console.log("delete")
             })//done
             .fail(function(error) {
                 console.log(error)
             })//fail end
            }//if
          })//then
      })//click end

        //圖片彈出
     $('.img').click(function(){
         let id=$(this).attr("src");
         console.log(id);
        Swal.fire({
          imageUrl: id,//'https://placeholder.pics/svg/300x1500'
          imageHeight: 500,
          imageAlt: 'image'
        })
    });

    //顯示圖片
    $('#file1').change(function(){
        $("#frames").html('');
        for (var i = 0; i < $(this)[0].files.length; i++) {
            $("#frames").append('<img src="'+window.URL.createObjectURL(this.files[i])+'" width="100px" height="100px"/>');
        }
    });

});