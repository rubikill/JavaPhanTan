'use strict';

//Account controller

function accountCtrl($scope, $rootScope, $location, LoginService, localize, Account) {
    //this var use for form login
    $scope.account = {};

    $scope.login = function() {
        LoginService.login($scope.account).success(function(user) {
            $rootScope.user = user;

            console.log($rootScope.user);
            $rootScope.logged = true;
            $scope.errMessage = undefined; // success
            $location.path("#/");
        }).error(function(msg) {
            $scope.errMessage = localize.getLocalizedString(msg);
        });
    };

    //this car use for reg form
    $scope.regUser = {};

    $scope.register = function() {

        if ($scope.verify()) {
            Account.register({

            }, $scope.regUser, function(data) {
                $location.path("#/");
                //alertify.success(data.message);
            }, function(response) {
                alertify.error(JSON.stringify(response));
            });
        }
    }

    $scope.verify = function() {
        if ($scope.regUser.password != $scope.repassword) {
        	alertify.error("Retype password is not correct");
            return false;
        } else {
            return true;
        }
    }
}
