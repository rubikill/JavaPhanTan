'use strict';

//Menu controller

function menuCtrl($location, $scope, localize, $rootScope, $cookieStore, Cart, LoginService, Fetch) {
    $scope.path = $location.path();

    $scope.$on('$locationChangeSuccess', function() {
        $scope.path = $location.path();
    });

    Fetch.getExchangerate({}, function(data) {
        $scope.exchangeRate = data;
    });

    /**
     * Change localize when switch language
     */
    $rootScope.$watch('currentLanguage', function(newLang, oldLang) {
        if (!newLang) {
            return;
        }

        $rootScope.currentLanguage = newLang;
        // store at cookie
        $cookieStore.put("language", newLang);
        // the first load localize resource file
        localize.language = newLang.localize;
        localize.setLanguage($rootScope.currentLanguage.localize);
    });


    Cart.getCart({}, function(data) {
        $rootScope.cart = data;
    });

    $scope.logout = function() {
        LoginService.logout().success(function() {
            $rootScope.user = null;
            $rootScope.logged = false;
            //FB.logout(function(response) {});
            alertify.success("Logout successful");
            deleteCookie();
            // document.getElementById("avatar_img").innerHTML="<img src=\"themes/images/login_button.png\" border=\"0\">";
            // document.getElementById("avatar_img").ng-click = "fb_login()";
        }).error(function(msg) {
            //$scope.errMessage = localize.getLocalizedString(msg);
        });
    }


    /**
     * Init
     */
    window.fbAsyncInit = function() {
        FB.init({
            appId: '194519237403528', // App ID
            channelUrl: 'http://shopcamera.windyzboy.cloudbees.net/',
            //'http://localhost:8080', // Channel File            
            status: true, // check login status
            xfbml: true
        });
    };

    $scope.logoutFB = function() {
        FB.logout(function(response) {});
    }

    $scope.fb_login = function() {
        console.log('Welcome!  Fetching your information.... ');
        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                $scope.token = response.authResponse.accessToken;
                console.log("login status (fb_login):", response);

                dologin();

            } else if (response.status === 'not_authorized') {
                console.log('Fail: not_authorized');
                FB.login(function(response) {

                    if (response.authResponse) {
                        console.log('not_authorize: Welcome!  Fetching your information.... ');
                        $scope.token = response.authResponse.accessToken;
                        console.log("accessToken", $scope.token);

                        dologin();
                    } else {
                        //user hit cancel button
                        console.log('User cancelled login or did not fully authorize.');

                    }
                }, {
                    scope: 'email'
                });
            } else {
                console.log('not login');
                FB.login(function(response) {
                    // handle the response
                    if (!response || response.error) {
                        alert('Error occured');
                    } else {
                        dologin();
                        //alert('OK');
                    }
                }, {
                    scope: 'email'
                });
            }
        });
    }

    function dologin() {
        FB.api('/me', function(response) {
            // document.getElementById("avatar_img").innerHTML =
            //     "<img src=\"http://graph.facebook.com/" + response.id + "/picture\" border=\"0\" alt=\"\"> Hello, <strong>" + response.name + "</strong>";
            // document.getElementById("avatar_img").href = "http://www.facebook.com/" + response.id;

            console.log('Good to see you, ' + response.name + '.');
            console.log(response);


            $scope.loginUser = {};
            $scope.loginUser.email = response.email;
            $scope.loginUser.name = response.name;

            LoginService.loginFB($scope.loginUser).success(function(user) {
                $rootScope.user = user;

                console.log($rootScope.user);
                $rootScope.logged = true;
                $scope.errMessage = undefined; // success
                $location.path("#/");
            }).error(function(msg) {
                $scope.errMessage = localize.getLocalizedString(msg);
            });
        });
    }
}
