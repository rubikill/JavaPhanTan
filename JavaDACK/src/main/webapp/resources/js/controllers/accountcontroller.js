'use strict';

function accountCtrl($scope, $rootScope, $location, LoginService, localize, Account){
	$scope.account = {};

	$scope.login = function () {
		LoginService.login($scope.account).success(function(user) {
			$rootScope.user = user;
			console.log(user);
			$rootScope.logged = true;
			$scope.errMessage = undefined; // success
			$location.path("#/");
		}).error(function(msg) {
			$scope.errMessage = localize.getLocalizedString(msg);
		});
	};

	$scope.regUser = {};

	$scope.register = function () {
		console.log($scope.regUser);
		Account.register({

		}, $scope.regUser, function (data) {
			console.log(data);
		}, function (response) {
			console.log(response);
		});
	}
}