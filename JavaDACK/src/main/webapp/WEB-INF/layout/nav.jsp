<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav navbar-nav side-nav">
	<li class=${nav == "home"? 'active' : ''}>
		<a href="/admin"><i class="fa fa-dashboard"></i> Dashboard</a>
	</li>
	<!-- <li><a href="charts"><i class="fa fa-bar-chart-o"></i> Charts</a></li> -->
	<li class=${nav == "account"? 'active' : ''}>
		<a href="/admin/account"><i class="fa fa-user"></i> Account</a>
	</li>	
	<li class=${nav == "manufacturer"? 'active' : ''}>
		<a href="/admin/manufacturer"><i class="fa fa-file-text-o"></i> Manufacturer</a>
	</li>
	<li class=${nav == "producttype"? 'active' : ''}>
		<a href="/admin/producttype"><i class="fa fa-tag"></i> Product Type</a>
	</li>
	<li class=${nav == "products"? 'active' : ''}>
		<a href="/admin/products?Page=1"><i class="fa fa-suitcase"></i> All Product</a>
		</li>	
	<li class=${nav == "promotions"? 'active' : ''}>
		<a href="/admin/promotions"><i class="fa fa-bullhorn"></i> Promotion</a>
	</li>
	<li class=${nav == "paymenttype"? 'active' : ''}>
		<a href="/admin/paymenttype"><i class="fa fa-file-text-o"></i> Payment type</a>
	</li>
	
	<li class=${nav == "orders"? 'active' : ''}>
		<a href="/admin/orders"><i class="fa fa-file-text-o"></i> Orders</a>
	</li>
</ul>