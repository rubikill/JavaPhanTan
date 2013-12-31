'use strict';

function homeCtrl($scope, Product, Cart) {
    $scope.listHotProduct = [];
    $scope.listNewProduct = [];

    Product.getProductsByManufacturer({
        id: '52a60375dcac65bfed509857'
    }, function(data) {
      //  console.log(data);
        $scope.listNewProduct = data;
    }, function(respone) {
        console.log(respone);
    });

    $scope.addToCart = function(productId) {
        Cart.addProductToCart({
            id: productId
        }, function(data) {
            $rootScope.cart = data;
            alertify.success("You have added a product to Cart");
        });
    }
}
