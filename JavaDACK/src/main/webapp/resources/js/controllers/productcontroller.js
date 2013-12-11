'use strict';

function productCtrl($scope, $rootScope, $location, Product, $routeParams){

	$scope.listProducts = [];

	// current page
	$scope.currentPage = 1;
	// number of items per page
	$scope.pageSize = 5;
	$scope.numberOfPages = 0;

	Product.getProducts({

	}, function (data) {
		console.log(data);
		$scope.listProducts = data;
		$scope.numberOfPages = Math.ceil($scope.listProducts.length / $scope.pageSize);

		console.log($scope.numberOfPages);
	}, function (response) {
		console.log(response);
	});

	//SORT Don't touch
	// $scope.predicate = '-comments.length';

	// $scope.sortByLikes = function() {
	// 	$scope.predicate = '-likes.length';
	// }

	// $scope.sortByComments = function() {
	// 	$scope.predicate = '-comments.length';
	// }

	// $scope.selectGroup = function(group) {
	// 	$scope.selectedGroup = group;
	// }
}


function productDetailsCtrl($scope, $rootScope, $location, $routeParams){

	console.log($routeParams.id);
}