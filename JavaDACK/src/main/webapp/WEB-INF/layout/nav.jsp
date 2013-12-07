<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navbar ================================================== -->
<div id="logoArea" class="navbar">
	<a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span> 
		<span class="icon-bar"></span>
	</a>

	<div class="navbar-inner">
		<a class="brand" href="/">
			<img src='<c:url value="/resources/themes/images/logo.png"/>' alt="Bootsshop" />
		</a>
		<form class="form-inline navbar-search" method="post" action="products">
			<!-- Search box-->
			<input id="srchFld" class="srchTxt" type="text" style="padding-left: 25px;"/>

			<!-- Select Category -->
			<select class="srchTxt">
				<option>All</option>
				<option>CLOTHES</option>
			</select>

			<button type="submit" id="submitButton" class="btn btn-primary">Go</button>
		</form>
		<ul id="topMenu" class="nav pull-right">
			<li class=""><a href="special_offer">Specials Offer</a></li>
			<li class=""><a href="contact">Contact</a></li>

			<!-- Hide if user has loged in-->
			<li class="">
				<a href="#login" role="button" data-toggle="modal" style="padding-right: 0">
					<span class="btn btn-large btn-success">Login</span>
				</a>				
			</li>
		</ul>
	</div>
</div>


<div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
		<h3>Login Block</h3>
	</div>
	<div class="modal-body">
		<form class="form-horizontal loginFrm">
			<div class="control-group">
				<input type="text" id="inputEmail" placeholder="Email">
			</div>
			<div class="control-group">
				<input type="password" id="inputPassword" placeholder="Password">
			</div>
			<div class="control-group">
				<label class="checkbox"> <input type="checkbox">
					Remember me
				</label>
			</div>
		</form>
		<button type="submit" class="btn btn-success">Sign in</button>
		<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
	</div>
</div>