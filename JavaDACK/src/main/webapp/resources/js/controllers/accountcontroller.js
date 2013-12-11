'use strict';

function accountCtrl($scope, Account, $rootScope, $location){
	$scope.account = {};

	$scope.login = function () {
		Account.login({

		}, $scope.account, function (data) {
			console.log(data);
			$rootScope.currentAccount = $scope.account;
			$location.path("/");
		}, function (response) {
			console.log(response);
		});
	}
}