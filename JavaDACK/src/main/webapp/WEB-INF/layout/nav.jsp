<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav navbar-nav side-nav">
	<li class=${nav == "home"? 'active' : ''}>
		<a href="/"><i class="fa fa-dashboard"></i> Dashboard</a>
	</li>
	<!-- <li><a href="charts"><i class="fa fa-bar-chart-o"></i> Charts</a></li> -->
	<li class=${nav == "account"? 'active' : ''}>
		<a href="account"><i class="fa fa-user"></i> Account Manage</a>
	</li>	
	<li class=${nav == "producttype"? 'active' : ''}>
		<a href="producttype"><i class="fa fa-tag"></i> Product Type</a>
	</li>
	<li class=${nav == "products"? 'active' : ''}>
		<a href="products"><i class="fa fa-suitcase"></i> All Product</a>
		</li>	
	<li class=${nav == "promotions"? 'active' : ''}>
		<a href="promotions"><i class="fa fa-bullhorn"></i> Promotion Manage</a>
	</li>
	<li class=${nav == "orders"? 'active' : ''}>
		<a href="orders"><i class="fa fa-file-text-o"></i> Orders Manage</a>
	</li>
</ul>