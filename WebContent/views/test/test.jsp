<%@ taglib uri="/mytag" prefix="my"%>
<%@ taglib uri="/function" prefix="ss"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<title>test</title>
<script src="jquery.min.js"></script>
<script src="test.js"></script>
</head>
<body>
	<form action="/Servlet/upload.do"  id="form1"  enctype="multipart/form-data" method="post">
		select a file<input type="file" name="filename" multiple="multiple" /> 
		<!-- <input id="upload" type="button" onclick="doSubmit()" value="Upload" /> -->
		<input id="upload" type="submit"  value="Upload" />
	</form>
	
	<form action="/Servlet/down.do" id="form2" method="post">
		<input value="文件下载资源1" readonly="readonly">
		<input type="submit"  value="Download">
	</form>

	<my:show />
	<br> this is test ${ss:append() }
</body>

</html>

