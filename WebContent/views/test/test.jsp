<%@ taglib uri="/mytag" prefix="my"%>
<%@ taglib uri="/function" prefix="ss"%>
<!DOCTYPE>
<html>
<head>
<title>test</title>
<script src="jquery.min.js"></script>
<script type="text/javascript">
	function doSubmit(){
		/* var form = $("#form1");
		var filename = $("input[name=file]").val();
		alert(filename);
		form.action="/Servlet/upload.do?filename="+filename;
		form.submit(); */
		
		var filename = $("input[name=filename]").val();
	/* 	alert(filename);
		$.get("http://localhost:8080/Servlet/upload.do?filename=\""+filename+"\"",function(data,status){
			alert(data+" "+status);
		});  */
		alert(filename);
		$.ajax({
			url:"/Servlet/upload.do",
			type:"post",
			data:{
				filename:filename,
			},
			success:function(data){
				alert(data);
			}
		})
	}
	
	//$.get(url,callback)
	$("#upload").click(function(){
		//var filename = $("input[name=file]").val();
		alert("test");
		/* $.get("/Servlet/upload.do?filename="+filename,function(data,status){
			alert(data+" "+status);
		}); */
	});
	
	function callback(data,status){
		alert(data+" "+status);
	}
	
</script>


</head>
<body>
	<form  id="form1"  enctype="multipart/form-data">
		select a file<input type="file" name="filename" multiple="multiple" /> 
		<input id="upload" type="button" onclick="doSubmit()" value="Upload" />
	</form>

	<my:show />
	<br> this is test ${ss:append() }
</body>

</html>

