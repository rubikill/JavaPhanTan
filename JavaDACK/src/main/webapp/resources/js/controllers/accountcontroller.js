'use strict';

function accountCtrl($scope, $rootScope, $location, LoginService, localize){
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
	// 	Account.login({

	// 	}, $scope.account, function (data) {
	// 		console.log(data);
	// 		$rootScope.currentAccount = $scope.account;
	// 		$location.path("/");
	// 	}, function (response) {
	// 		console.log(response);
	// 	});


}