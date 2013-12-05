<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Sidebar ================================================== -->
<div id="sidebar" class="span3">
	<div class="well well-small">
		<a id="myCart" href="product_summary.html"><img
			src='<c:url value="/resources/themes/images/ico-cart.png"/>'
			alt="cart">3 Items in your cart <span
			class="badge badge-warning pull-right">$155.00</span></a>
	</div>
	<ul id="sideManu" class="nav nav-tabs nav-stacked">
		<li class="subMenu open"><a> ELECTRONICS [230]</a>
			<ul>
				<li><a class="active" href="products.html"><i
						class="icon-chevron-right"></i>Cameras (100) </a></li>
			</ul></li>
	</ul>
	<br />
	<div class="thumbnail">
		<img
			src='<c:url value="/resources/themes/images/products/panasonic.jpg"/>'
			alt="Bootshop panasonoc New camera" />
		<div class="caption">
			<h5>Panasonic</h5>
			<h4 style="text-align: center">
				<a class="btn" href="product_details.html"> <i
					class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
					class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">$222.00</a>
			</h4>
		</div>
	</div>
	<br />
	<div class="thumbnail">
		<img
			src='<c:url value="/resources/themes/images/products/kindle.png"/>'
			title="Bootshop New Kindel" alt="Bootshop Kindel">
		<div class="caption">
			<h5>Kindle</h5>
			<h4 style="text-align: center">
				<a class="btn" href="product_details.html"> <i
					class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
					class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">$222.00</a>
			</h4>
		</div>
	</div>
	<br />
	<div class="thumbnail">
		<img
			src='<c:url value="/resources/themes/images/payment_methods.png"/>'
			title="Bootshop Payment Methods" alt="Payments Methods">
		<div class="caption">
			<h5>Payment Methods</h5>
		</div>
	</div>
</div>
<!-- Sidebar end=============================================== -->