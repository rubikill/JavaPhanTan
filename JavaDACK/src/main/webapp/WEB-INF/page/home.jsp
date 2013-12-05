<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="span9">
	<div class="well well-small">
		<h4>
			Featured Products <small class="pull-right">200+ featured
				products</small>
		</h4>
		<div class="row-fluid">
			<div id="featured" class="carousel slide">
				<div class="carousel-inner">
					<div class="item active">
						<ul class="thumbnails">
							<li class="span3">
								<div class="thumbnail">
									<i class="tag"></i> <a href="product_details.html"><img
										src='<c:url value="/resources/themes/images/products/b1.jpg"/>'
										alt=""></a>
									<div class="caption">
										<h5>Product name</h5>
										<h4>
											<a class="btn" href="product_details.html">VIEW</a> <span
												class="pull-right">$222.00</span>
										</h4>
									</div>
								</div>
							</li>
						</ul>
					</div>
					<div class="item">
						<ul class="thumbnails">
							<li class="span3">
								<div class="thumbnail">
									<i class="tag"></i> <a href="product_details.html"><img
										src='<c:url value="/resources/themes/images/products/5.jpg"/>'
										alt=""></a>
									<div class="caption">
										<h5>Product name</h5>
										<h4>
											<a class="btn" href="product_details.html">VIEW</a> <span
												class="pull-right">$222.00</span>
										</h4>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<a class="left carousel-control" href="#featured" data-slide="prev">&lsaquo;</a>
				<a class="right carousel-control" href="#featured" data-slide="next">&rsaquo;</a>
			</div>
		</div>
	</div>
	<h4>Latest Products</h4>
	<ul class="thumbnails">
		<li class="span3">
			<div class="thumbnail">
				<a href="product_details.html"><img
					src='<c:url value="/resources/themes/images/products/6.jpg"/>'
					alt="" /></a>
				<div class="caption">
					<h5>Product name</h5>
					<p>Lorem Ipsum is simply dummy text.</p>
					<h4 style="text-align: center">
						<a class="btn" href="product_details.html"> <i
							class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
							class="icon-shopping-cart"></i>
						</a> <a class="btn btn-primary" href="#">$222.00</a>
					</h4>
				</div>
			</div>
		</li>
	</ul>
</div>