<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-signin" role="form" action="../../j_spring_security_check" method="post">
	<h2 class="form-signin-heading">Please sign in</h2>
	<div class="alert alert-danger">${error}</div>
	<input class="form-control" placeholder="Email address" id="j_username" name="j_username" required="" autofocus="" type="text">
	<input class="form-control" placeholder="Password" id="j_password" name="j_password" required="" type="password">
	<label class="checkbox">
		<!-- <input value="remember-me" type="checkbox"> Remember me -->
		<a href="/admin/forgotpass" class="pull-right">Forgot password?</a>
	</label>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
