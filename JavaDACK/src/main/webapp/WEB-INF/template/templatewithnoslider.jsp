<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en" ng-app="shop">
<head>
<meta charset="utf-8">
<title>Bootshop online Shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<tiles:insertAttribute name="style" />
</head>
<body>
	<div id="header">
		<div class="container">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="menu_bar" />
		</div>
	</div>
	<!-- Header End====================================================================== -->
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<tiles:insertAttribute name="sidebar" />
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>
	<tiles:insertAttribute name="footer" />
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<tiles:insertAttribute name="script" />
</body>
</html>