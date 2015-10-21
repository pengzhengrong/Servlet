	function doSubmit(){
		var filename = $("input[name=filename]").val();
		$.ajax({
			url:"/Servlet/upload.do",
			type:"post",
			data:{
				filename:filename
			},
			success:function(data){
				alert(data);
			}
		})
	}