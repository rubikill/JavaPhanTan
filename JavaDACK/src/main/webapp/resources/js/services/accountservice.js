'use strict';

shopsv.factory('Account', function($resource) {
	return $resource('/:action', {
		action: "@action"
	}, {
		login : {
			method : 'POST',
			params : {
				action : "login"
			}
		},
		register : {
			method : 'POST',
			params : {
				action : "register"
			}
		}
	});
});



shopsv.service('LoginService', function($http, $rootScope, localize) {
	var self = this;	
	var user = {};
	var logged = false;

	/**
	 * Check that the current user is still logged when loading the service
	 */
	$http.get("/ping").success(function(pUser) {
		$rootScope.logged = true;
		$rootScope.user = pUser;
	}).error(function(){
		$rootScope.logged = false;
	});

	/**
	 * @method isLogged
	 * @return true if the user is logged on the server.
	 */
	self.isLogged = function() {
		return logged;
	}

	/**
	 * Login the user with the given credentials (auth) on the server.
	 * 
	 * @method login
	 * @param auth,
	 *            the user credentials (e.g { user : "toto", password: "secret" }
	 * @return a promise.
	 */
	self.login = function(auth) {
		return $http.post("/login", auth, {
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(pUser, headers) {
			logged = true;
			user = pUser;

			// refire the 401 request!
			$rootScope.requests401.forEach(function(req) {
				$http(req.config).then(function(response) {
					req.deferred.resolve(response);
				});
			});

			$rootScope.requests401 = []; // everything has been re-fired
			$rootScope.$broadcast('event:login'); // broadcast login success
		});
	}

	/**
	 * Call logout on the server! This will destroy the user session (cookie
	 * based session)
	 * 
	 * @method logout
	 * @return a promise.
	 */
	self.logout = function() {
		return $http.get("/logout").success(function() {
			$rootScope.$broadcast('event:logout');
			logged = false;
			user = {};
		});
	}

	/**
	 * Return the name and email of the user currently logged in.
	 * 
	 * @method getUser
	 * @return the user name and email.
	 */
	self.getUser = function() {
		return user;
	}
});