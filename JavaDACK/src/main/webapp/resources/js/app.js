'use strict';

/* App Module */

var shop = angular.module('shop', [ 'shopsv.services', 'localization', 'ngCookies', 'ngResource' ]);

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
            templateUrl: '/partials/pages/login.html',
            controller : accountCtrl
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

shop.run(function($rootScope, $location, localize, $cookieStore) {
    $rootScope.requests401 = []; // global init, todo replace by module

    // multi languages
    $rootScope.languages = [ {
        name : 'EN',
        localize : 'en-US'
    }, {
        name : 'VI',
        localize : 'vi'
    } ];

    var index = 0;
    // get language from cookie
    if ($cookieStore.get("language") != null) {
        for (index = 0; index < $rootScope.languages.length; index++) {
            var lang = $rootScope.languages[index];
            if (angular.equals(lang.localize,
                $cookieStore.get("language").localize)) {
                break;
        }
    }
}
    // default language is the first (EN)
    $rootScope.currentLanguage = $rootScope.languages[index];
    // load json language data
    localize.setLanguage($rootScope.currentLanguage.localize);
});

var shopsv = angular.module('shopsv.services', ['ngResource']);
