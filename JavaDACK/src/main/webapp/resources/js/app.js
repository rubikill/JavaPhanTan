'use strict';

/* App Module */

var shop = angular.module('shop', [
    'shopsv.services'
]);

shop.config(['$routeProvider',
    function($routeProvider, $rootScope) {
        $routeProvider.when('/', {
            templateUrl: '/partials/pages/home.html',
            controller: homeCtrl
        })
            .when('/compair', {
                templateUrl: '/partials/pages/compair.html'
                // ,
                // controller : homeCtrl
            })
            .when('/product_details', {
                templateUrl: '/partials/pages/product_details.html'
                // ,
                // controller : homeCtrl
            })
            .when('/product_summary', {
                templateUrl: '/partials/pages/product_summary.html'
                // ,
                // controller : homeCtrl
            })
            .when('/register', {
                templateUrl: '/partials/pages/register.html'
                // ,
                // controller : homeCtrl
            })
            .when('/special_offer', {
                templateUrl: '/partials/pages/special_offer.html'
                // ,
                // controller : homeCtrl
            })
            .when('/products', {
                templateUrl: '/partials/pages/products.html'
                // ,
                // controller : homeCtrl
            })
            .when('/login', {
                templateUrl: '/partials/pages/login.html'
                // ,
                // controller : homeCtrl
            })
            .when('/contact', {
                templateUrl: '/partials/pages/contact.html'
                // ,
                // controller : homeCtrl
            })
            .when('/forgetpass', {
                templateUrl: '/partials/pages/forgetpass.html'
                // ,
                // controller : homeCtrl
            })
            .otherwise({
                redirectTo: ('/')
            });
    }
]);



var shopsv = angular.module('shopsv.services', []);
