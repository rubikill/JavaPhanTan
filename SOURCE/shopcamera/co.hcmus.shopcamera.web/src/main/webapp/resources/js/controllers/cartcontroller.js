'use strict';

//Cart controller
function cartCtrl($scope, $rootScope, $location, $routeParams, Cart, History) {
    $scope.total = 0;
    //Add Product to cart
    $scope.addToCart = function(productId) {
        Cart.addProductToCart({
            id: productId //Product id
        }, function(data) {
            console.log("data",data);
            $rootScope.cart = data;
            $scope.total = 0;
             angular.forEach($rootScope.cart,function(value,index){
                $scope.total = $scope.total + value.price;
            });
             console.log("total",$scope.total);
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

    //Change amount
    $scope.plus = function(item) {
        item.count++;

        //update cart here
        $scope.updateCart();
    }

    //Change amount
    $scope.sub = function(item) {
        if(item.count > 1){
            item.count--;

            //update cart here
            $scope.updateCart();
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

    $scope.bill = {};

    //Check out
    $scope.checkOut = function () {
        History.checkout({

        }, JSON.stringify($scope.bill), function (data) {
            $rootScope.cart = null;
            alertify.error("Check out success");
        }, function (respone) {
            
        });
    }

    $scope.updateCart = function () {
        Cart.updateCart({

        }, JSON.stringify($rootScope.cart), function (data) {

        }, function (respone) {
            // body...
        });
    }
}