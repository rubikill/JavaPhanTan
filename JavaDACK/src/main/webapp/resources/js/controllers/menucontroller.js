        'use strict';

        //Menu controller

        function menuCtrl($location, $scope, localize, $rootScope, $cookieStore, Cart, LoginService, Fetch) {
            $scope.path = $location.path();

            $scope.$on('$locationChangeSuccess', function() {
                $scope.path = $location.path();
                //console.log($scope.path);
            });

            Fetch.getExchangerate({}, function (data) {
               $scope.exchangeRate = data;

               //console.log(data);
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
                    alertify.success("Logout successful");
                }).error(function(msg) {
                    //$scope.errMessage = localize.getLocalizedString(msg);
                });
            }


            /**
             * Init
             */
             window.fbAsyncInit = function() {
                FB.init({
                    appId: '1435775303319223', // App ID
                    channelUrl: 'http://localhost:8080', // Channel File
                    status: true, // check login status
                    xfbml: true,

                    // parse XFBML
                });

                FB.Event.subscribe('auth.authResponseChange', function(response) {
                    if (response.status === 'connected') {
                        console.log("authResponse - connected");
                        loginFB();
                    } else if (response.status === 'not_authorized') {
                        console.log("Login 1");

                        FB.login(function(response) {
                            // handle the response
                            if (!response || response.error) {
                                alert('Error occured');
                            } else {
                                alert('not_authorized: OK');
                            }
                        }, {
                            scope: 'email'
                        });
                    } else {
                        FB.login(function(response) {
                            // handle the response
                            if (!response || response.error) {
                                alert('Error occured');
                            } else {
                                alert('You have just logged out Facebook');
                            }
                        }, {
                            scope: 'email'
                        });
                    }
                });
    };

    function loginFB() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log('Good to see you, ' + response.name + '.');
        });
        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                $scope.token = response.authResponse.accessToken;

                console.log("login status:",response);
                 FB.api('/me', function(response) {
                        document.getElementById("avatar_img").innerHTML=
                        "<img src=\"http://graph.facebook.com/"+ response.id +"/picture\" border=\"0\" alt=\"\"> Hello, <strong>" + response.name +"</strong>"
                        document.getElementById("avatar_img").href="http://www.facebook.com/"+response.id;
                    });

                        // Auth.setToken({
                        //     token: response.authResponse.accessToken
                        // }, function(data) {
                        //     console.log("success");
                        // }, function(response) {
                        //     console.log("fail");
                        // });

    } else if (response.status === 'not_authorized') {
        console.log('Fail');
    } else {
        console.log('not login');
    }
    });
    }


        $scope.logoutFB = function() {
            FB.logout(function(response) {
            });
        }

        $scope.fb_login = function(){
            console.log('Welcome!  Fetching your information.... ');
            FB.api('/me', function(response) {
                console.log('Good to see you, ' + response.name + '.');
            });
            FB.getLoginStatus(function(response) {
                if (response.status === 'connected') {
                    $scope.token = response.authResponse.accessToken;

                    console.log("login status (fb_login):",response);

                            // Auth.setToken({
                            //     token: response.authResponse.accessToken
                            // }, function(data) {
                            //     console.log("success");
                            // }, function(response) {
                            //     console.log("fail");
                            // });
                    FB.api('/me', function(response) {
                        document.getElementById("avatar_img").innerHTML=
                        "<img src=\"http://graph.facebook.com/"+ response.id +"/picture\" border=\"0\" alt=\"\"> Hello, <strong>" + response.name +"</strong>"
                        document.getElementById("avatar_img").href="http://www.facebook.com/"+response.id;
                    });
                } else if (response.status === 'not_authorized') {
                       console.log('Fail: not_authorized');
                       FB.login(function(response) {

                            if (response.authResponse) {
                                console.log('not_authorize: Welcome!  Fetching your information.... ');
                                 $scope.token = response.authResponse.accessToken;
                                 console.log("accessToken",$scope.token);
                                // Auth.setToken({
                                //     token : response.authResponse.accessToken
                                // }, function(data) {
                                //     console.log("not_authorized: Connect success");
                                // }, function(response) {
                                //     console.log("Connect fail");
                                // });        

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
                                alert('OK');
                            }
                        }, {
                            scope : 'email'
                        });
                    }
            }
        );
     }
    }
