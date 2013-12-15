'use strict';

function productCtrl($scope, $rootScope, $location, Product, $routeParams, Cart) {

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
    }, function(data) {
        //console.log(data);
        $scope.listProducts = data;
        $scope.numberOfPages = Math.ceil($scope.listProducts.length / $scope.pageSize);

        //console.log($scope.numberOfPages);
    }, function(response) {
        console.log(response);
    });

    $scope.next = function(argument) {
        if ($scope.currentPage < $scope.numberOfPages) {
            $scope.currentPage++;
        }
    }

    $scope.prev = function(argument) {
        if ($scope.currentPage > 1) {
            $scope.currentPage--;
        }
    }

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

    //SORT Don't touch
    $scope.predicate = '+name';
}

function productTypeCtrl($scope, $rootScope, ProductType, $routeParams) {
    //List product type
    $scope.listProductTypes = [];

    $scope.selectedProductType = $routeParams.typeId;

    ProductType.getProductTypes({

    }, function(data) {
        //console.log(data);
        $scope.listProductTypes = data;
    }, function(response) {
        console.log(response);
    });
}

/**
*	Product details controller
*	Get details of product
*/
function productDetailsCtrl($scope, $rootScope, $location, $routeParams, ProductDetails, Product, Cart, Rating) {
    $scope.rating = 1;

    Product.getProductById({
        id: $routeParams.id
    }, function(data) {
        $scope.product = data;
        //console.log(data);
        ProductDetails.getProductDetails({
            id: $routeParams.id
        }, function(data) {
            $scope.product.details = data;
            console.log($scope.product);

            Rating.getRate({
                productId: $routeParams.id
            }, {
                'email': $rootScope.user.email
            }, function(data) {
                if (data.isRate) {
                    $scope.rating = data.rateEmail;
                }
                $scope.rateAverage = data.rateAverage;
                //console.log(data);
            }, function(response) {
                // body...
            });

        }, function(response) {
            //console.log(response);
        });
    }, function(response) {

    });

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

    $scope.$watch('rating', function(newValue, oldValue, scope) {
        if ($rootScope.user != null && $rootScope.user != undefined) {
            Rating.doRate({
                productId: $routeParams.id
            }, {
                'email': $rootScope.user.email,
                'star': $scope.rating
            });
        }
    });
}
