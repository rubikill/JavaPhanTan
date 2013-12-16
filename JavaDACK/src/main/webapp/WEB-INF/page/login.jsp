<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-signin" role="form">
	<h2 class="form-signin-heading">Please sign in</h2>
	<div class="alert alert-danger">ERROR MESSAGE</div>
	<input class="form-control" placeholder="Email address" required="" autofocus="" type="text">
	<input class="form-control" placeholder="Password" required="" type="password">
	<label class="checkbox">
		<!-- <input value="remember-me" type="checkbox"> Remember me -->
		<a href="/admin/forgotpass" class="pull-right">Forgot password?</a>
	</label>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>