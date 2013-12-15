'use strict';

//Cart controller
function cartCtrl($scope, $rootScope, $location, $routeParams, Cart) {

    //Add Product to cart
    $scope.addToCart = function(productId) {
        Cart.addProductToCart({
            id: productId //Product id
        }, function(data) {
            $rootScope.cart = data;
            alertify.success("You have added a product to Cart");
        });
    }

    //Remove a product from cart
    $scope.removeFromCart = function(productId, index) {
        //Close modal confirm remove
        $('#removeProduct').modal('hide');

        Cart.removeProductFromCart({
            id: productId
        }, function(data) {
            alertify.error("You have removed a product to Cart");
            //Remove on UI
            $rootScope.cart.splice(index, 1);
        });
    }

    //Chang amount
    $scope.plus = function(item) {
        item.count++;

        //update cart here
    }

    //Chang amount
    $scope.sub = function(item) {
        if(item.count > 1){
            item.count--;

            //update cart here
        }
    }

    //deleted item
    $scope.selectedItem = {};

    //Confirm remove product
    //Just only set selected product
    $scope.confirmRemove = function (id, index) {
        $scope.selectedItem.id = id;
        $scope.selectedItem.index = index;
    }

    //Check out
    $scope.checkOut = function () {
        if($rootScope.user == null || $rootScope.user == undefined){
            alertify.error("You have to login first");
        }
    }
}
