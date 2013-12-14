'use strict';

/* App Module */

var shop = angular.module('shop', ['shopsv.services', 'localization', 'ngCookies', 'ngResource']);

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
            .when('/product_details/:id', {
                templateUrl: '/partials/pages/product_details.html',
                controller: productDetailsCtrl
            })
            .when('/product_summary', {
                templateUrl: '/partials/pages/product_summary.html',
                controller: cartCtrl
            })
            .when('/register', {
                templateUrl: '/partials/pages/register.html',
                controller: accountCtrl
            })
            .when('/special_offer', {
                templateUrl: '/partials/pages/special_offer.html'
                // ,
                // controller : homeCtrl
            })
            .when('/products/:typeId', {
                templateUrl: '/partials/pages/products.html',
                controller: productCtrl
            })
            .when('/login', {
                templateUrl: '/partials/pages/login.html',
                controller: accountCtrl
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
    $rootScope.languages = [{
        name: 'EN',
        localize: 'en-US'
    }, {
        name: 'VI',
        localize: 'vi'
    }];

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


shopsv.filter('startFrom', function() {
    return function(input, start) {
        if (input) {
            start = +start; // parse to int
            return input.slice(start);
        }
        return [];
    }
});

// date picker
shopsv.directive('bsDatepicker', function() {
    return {
        require: 'ngModel',
        scope: true,
        restrict: 'A',
        link: function($scope, element, attrs, controller) {
            var options = {};
            var updateModel = function(ev) {
                element.datepicker('hide');
                element.blur();

                if (angular.equals(attrs.name, "dueDate")) {
                    $("#startDate").datepicker('setEndDate', ev.date);

                } else if (angular.equals(attrs.name, "startDate")) {
                    $("#endDate").datepicker('setStartDate', ev.date);
                }
                return $scope.$apply(function() {
                    return controller.$setViewValue(ev.date);
                });
            };

            if (controller != null) {
                controller.$render = function() {
                    return controller.$viewValue;
                };
            }

            return attrs.$observe('bsDatepicker', function(value) {

                if (angular.isObject(value)) {
                    options = value;
                }

                if (typeof(value) === "string" && value.length > 0) {
                    options = angular.fromJson(value);
                }

                if (angular.equals(attrs.name, "startDate")) {
                    var current = new Date();
                    var startStr = current.getFullYear() + "-" + (current.getMonth() <= 8 ? "0" : "") + (current.getMonth() + 1) + "-" + (current.getDate() <= 9 ? "0" : "") + current.getDate();

                    $('#startDate').datepicker('setStartDate', startStr);
                    $('#endDate').datepicker('setStartDate', startStr);
                }

                // element.datepicker('setLanguage',
                // $scope.currentLanguage.localize.split('-')[0]);
                // datepicker at the bottom search
                if (attrs.placement === "top") {
                    element.on('show', function() {
                        var picker = $('body').find('.datepicker');

                        picker.addClass('datepicker-dropup');

                        var offset = element.offset();
                        picker.css({
                            top: offset.top - picker.outerHeight(true) - 3,
                            left: offset.left

                        });
                    });

                }

                return element.datepicker(options)
                    .on('changeDate', updateModel);
            });
        }
    };
});

shopsv.directive('fundooRating', function() {
    return {
        restrict: 'A',
        template: '<ul class="rating">' 
            + '<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">' 
            + '\u2605' 
            + '</li>' 
            + '</ul>',
        scope: {
            ratingValue: '=',
            max: '=',
            readonly: '@',
            onRatingSelected: '&'
        },
        link: function(scope, elem, attrs) {

            var updateStars = function() {
                scope.stars = [];
                for (var i = 0; i < scope.max; i++) {
                    scope.stars.push({
                        filled: i < scope.ratingValue
                    });
                }
            };

            scope.toggle = function(index) {
                if (scope.readonly && scope.readonly === 'true') {
                    return;
                }
                scope.ratingValue = index + 1;
                scope.onRatingSelected({
                    rating: index + 1
                });
            };

            scope.$watch('ratingValue', function(oldVal, newVal) {                
                if (newVal) {
                    updateStars();
                }
            });
        }
    }
});
