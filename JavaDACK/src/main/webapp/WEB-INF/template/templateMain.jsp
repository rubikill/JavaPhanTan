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

	<tiles:insertAttribute name="style" />
</head>
<body>
	<div id="wrapper">
		<!-- Sidebar -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">SB Admin</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<tiles:insertAttribute name="menu_bar" />
				<tiles:insertAttribute name="header" />
			</div><!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">
			<tiles:insertAttribute name="content" />
		</div><!-- /#page-wrapper -->
	</div><!-- /#wrapper -->

	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<tiles:insertAttribute name="script" />
</body>
</html>