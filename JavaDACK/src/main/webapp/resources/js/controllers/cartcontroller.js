'use strict';

function cartCtrl($scope, $rootScope, $location, $routeParams, Cart) {
    $scope.addToCart = function(productId) {
        Cart.addProductToCart({
            id: productId
        }, function(data) {
            $rootScope.cart = data;
            //console.log(data);
        }, function(response) {
            //console.log(response);
        });
    }

    $scope.removeFromCart = function(productId) {
        Cart.removeProductFromCart({
            id: productId
        }, function(data) {
            $rootScope.cart = data;
            //console.log(data);
        }, function(response) {
            //console.log(response);
        });
    }

    $scope.plus = function(amount) {
    	console.log(amount++);
    }

    $scope.sub = function(amount) {
    	console.log(amount--);
    }
}
