'use strict';

//Product controller

function productCtrl($scope, $rootScope, $location, Product, $routeParams, Cart) {

    //List product
    $scope.listProducts = [];

    // current page
    $scope.currentPage = 1;
    // number of items per page
    $scope.pageSize = 6;
    $scope.numberOfPages = 0;

    Product.getProductsByType({
        id: $routeParams.typeId //type id
    }, function(data) {
        $scope.listProducts = data;
        $scope.numberOfPages = Math.ceil($scope.listProducts.length / $scope.pageSize);
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
            alertify.success("You have added a product to Cart");
        });
    }

    //SORT Don't touch
    //Default sort by name
    $scope.predicate = '+name';

    $scope.check = [];

    $rootScope.compairItems = [];

    $scope.compair = function(item, isCheck) {
        if (isCheck) {
            if ($rootScope.compairItems !== undefined || $rootScope.compairItems !== null) {
                if ($rootScope.compairItems.length == 4) {
                    alertify.error("Only compair 4 product");
                } else {
                    $rootScope.compairItems.push(item);
                    alertify.success("You have added a product to compair list");
                }
            }

        } else {
            for (var i = 0; i < $rootScope.compairItems.length; i++) {
                if ($rootScope.compairItems[i].id == item.id) {
                    $rootScope.compairItems.splice(i, 1);
                    alertify.error("You have removed a product from compair list");
                }
            }
        }
    }
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
 *  Product details controller
 *  Get details of product
 */

function productDetailsCtrl($scope, $rootScope, $location, $routeParams, ProductDetails, Product, Cart, Rating) {
    $scope.rating = 1;

    //List product
    $scope.listRelatedProducts = [];
    // current page
    $scope.currentPage = 1;
    // number of items per page
    $scope.pageSize = 3;
    $scope.numberOfPages = 0;

    Product.getProductById({
        id: $routeParams.id
    }, function(data) {
        $scope.product = data;
        //console.log(data);
        ProductDetails.getProductDetails({
            id: $routeParams.id
        }, function(data) {
            $scope.product.details = data;

            var mail = "admin@local.host";
            if ($rootScope.user.email != null || $rootScope.user.email != undefined){
                mail = $rootScope.user.email;
            }
            Rating.getRate({
                productId: $routeParams.id
            }, {
                'email': mail
                //'admin@local.host'
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
        //Get related product
        Product.getProductsByType({
            id: $scope.product.productTypeId
            }, function(data){
                    $scope.listRelatedProducts = data;
                    $scope.numberOfPages = 1;
            }, function(response){
        });
    }, function(response) {

    });

    


    $scope.addToCart = function(productId) {
        Cart.addProductToCart({
            id: productId
        }, function(data) {
            $rootScope.cart = data;
            alertify.success("You have added a product to Cart");
        });
    }

    //Watching rating
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

function promotionCtrl($scope, $rootScope, $location, $routeParams, Promotion, Cart) {
    //List product
    $scope.listPromotionProducts = [];
    // current page
    $scope.currentPage = 1;
    // number of items per page
    $scope.pageSize = 6;
    $scope.numberOfPages = 0;

    Promotion.getPromotionProducts({
    }, function(data) {
        $scope.listPromotionProducts = data;
        $scope.numberOfPages = Math.ceil($scope.listPromotionProducts.length / $scope.pageSize);
        console.log(data);
    }, function(response) {

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
            alertify.success("You have added a product to Cart");
        });
    }

    //SORT Don't touch
    //Default sort by name
    $scope.predicate = '+product.name';

    $scope.check = [];

    $rootScope.compairItems = [];

    $scope.compair = function(item, isCheck) {
        if (isCheck) {
            if ($rootScope.compairItems !== undefined || $rootScope.compairItems !== null) {
                if ($rootScope.compairItems.length == 4) {
                    alertify.error("Only compair 4 product");
                } else {
                    $rootScope.compairItems.push(item);
                    alertify.success("You have added a product to compair list");
                }
            }

        } else {
            for (var i = 0; i < $rootScope.compairItems.length; i++) {
                if ($rootScope.compairItems[i].id == item.id) {
                    $rootScope.compairItems.splice(i, 1);
                    alertify.error("You have removed a product from compair list");
                }
            }
        }
    }
}


function compairCtrl($scope, $rootScope) {

}

function orderCtrl($scope, $rootScope, History) {
    $scope.histories = [];

    $scope.selectedItem = {};

    $scope.confirmCanel = function(item) {
        $('#cancelOrder').modal('show');
        $scope.selectedItem = item;
    }

    $scope.canelHistory = function() {
        $('#cancelOrder').modal('hide');
        History.cancelHistory({
            action: 'cancel',
            id: $scope.selectedItem.id
        }, function(data) {
            alertify.success("You have cancel a History");
            History.getHistory({

            }, function(data) {
                // body...
                console.log(data);
                $scope.histories = data;
            });
        }, function(response) {
            console.log(response);
        });
    }

    History.getHistory({

    }, function(data) {
        // body...
        console.log(data);
        $scope.histories = data;
    });
}

function filterCtrl($scope, $rootScope, Product) {
    //List product
    $scope.listProducts = [];

    Product.getProducts({

    }, function(data) {
        $scope.listProducts = data;
        $scope.numberOfPages = Math.ceil($scope.listProducts.length / $scope.pageSize);
    }, function(response) {
        // body...
    });

    // current page
    $scope.currentPage = 1;
    // number of items per page
    $scope.pageSize = 4;
    $scope.numberOfPages = 0;

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

    //SORT Don't touch
    //Default sort by name
    $scope.predicate = '+name';
}
