'use strict';

function productCtrl($scope, $rootScope, $location, Product, $routeParams, Cart){

	//List product
	$scope.listProducts = [];

	// current page
	$scope.currentPage = 1;
	// number of items per page
	$scope.pageSize = 6;
	$scope.numberOfPages = 0;

	Product.getProductsByType({
		//type id
		id: $routeParams.typeId
	}, function (data) {
		//console.log(data);
		$scope.listProducts = data;
		$scope.numberOfPages = Math.ceil($scope.listProducts.length / $scope.pageSize);

		//console.log($scope.numberOfPages);
	}, function (response) {
		console.log(response);
	});

	$scope.next = function (argument) {
		if($scope.currentPage < $scope.numberOfPages){
			$scope.currentPage++;
		}
	}

	$scope.prev = function (argument) {
		if($scope.currentPage > 1){
			$scope.currentPage--;
		}
	}

	$scope.addToCart = function (productId) {
		Cart.addProductToCart({
			id: productId
		}, function (data) {
			$rootScope.cart = data;
			//console.log(data);
		}, function (response) {
			//console.log(response);
		});
	}

	//SORT Don't touch
	$scope.predicate = '+name';
}

function productTypeCtrl($scope, $rootScope, ProductType, $routeParams) {
	//List product type
	$scope.listProductTypes = [];

	$scope.selectedProductType = $routeParams.typeId;

	ProductType.getProductTypes({

	}, function (data) {
		//console.log(data);
		$scope.listProductTypes = data;
	}, function (response) {
		console.log(response);
	});
}


function productDetailsCtrl($scope, $rootScope, $location, $routeParams){

	console.log($routeParams.id);
}