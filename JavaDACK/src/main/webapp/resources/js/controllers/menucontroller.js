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

       console.log(data);
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
                console.log("connected");
                testAPI();
            } else if (response.status === 'not_authorized') {
                console.log("Login 1");

                FB.login(function(response) {
                    // handle the response
                    if (!response || response.error) {
                        alert('Error occured');
                    } else {
                        alert('OK');
                    }
                }, {
                    scope: 'email,user_notes,user_status,publish_actions,user_groups,user_likes,user_photos,user_about_me,user_birthday,user_friends,user_hometown,user_location,user_videos,create_note,manage_friendlists,photo_upload,read_requests,share_item,export_stream,manage_notifications,publish_stream,read_mailbox,read_stream,video_upload,manage_pages,read_friendlists,read_page_mailboxes,status_update,user_events,page'
                });
            } else {
                FB.login(function(response) {
                    // handle the response
                    if (!response || response.error) {
                        alert('Error occured');
                    } else {
                        alert('OK');
                    }
                }, {
                    scope: 'email,user_notes,user_status,publish_actions,user_groups,user_likes,user_photos,user_about_me,user_birthday,user_friends,user_hometown,user_location,user_videos,create_note,manage_friendlists,photo_upload,read_requests,share_item,export_stream,manage_notifications,publish_stream,read_mailbox,read_stream,video_upload,manage_pages,read_friendlists,read_page_mailboxes,status_update,user_events,page'
                });
            }
        });
    };

    function testAPI() {
        console.log('Welcome!  Fetching your information.... ');
        FB.api('/me', function(response) {
            console.log(response);
        });
        FB.getLoginStatus(function(response) {
            if (response.status === 'connected') {
                $scope.token = response.authResponse.accessToken;

                console.log(response);

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
}
