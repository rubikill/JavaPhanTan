'use strict';

//Account controller
function accountCtrl($scope, $rootScope, $location, LoginService, localize, Account){
	//this var use for form login
	$scope.account = {};

	$scope.login = function () {
		LoginService.login($scope.account).success(function(user) {
			$rootScope.user = user;
			$rootScope.logged = true;
			$scope.errMessage = undefined; // success
			$location.path("#/");
		}).error(function(msg) {
			$scope.errMessage = localize.getLocalizedString(msg);
		});
	};

	//this car use for reg form
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