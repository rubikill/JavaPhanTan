'use strict';

function menuCtrl($location, $scope, $rootScope) {
	$scope.path = $location.path();

	$scope.$on('$locationChangeSuccess', function() {
		$scope.path = $location.path();
		console.log($scope.path);
	});
}