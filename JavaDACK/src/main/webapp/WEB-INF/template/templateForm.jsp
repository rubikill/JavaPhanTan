<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Camera shop Admin page</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/bootstrap.css" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/signin.css" >
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="content" />
	</div> <!-- /container -->
</body>
</html>