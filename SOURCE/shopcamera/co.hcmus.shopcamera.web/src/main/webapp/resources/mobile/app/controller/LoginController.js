Ext.define('cam3tshop.controller.LoginController', {
    extend: 'Ext.app.Controller',
    requires: [
        //''
    ],

    config: {
        control: {
            loginButton: {
                tap: 'onLoginButtonTap'
            }
        },

        refs: {
            loginButton: '#btn_login'
        },

        stores: [
            //''
        ]
    },

    //controller methods
    onLoginButtonTap: function() {
        var loginUser = {};
        loginUser.email = Ext.getCmp('txb_login_email').getValue();
        loginUser.password = Ext.getCmp('txb_login_pass').getValue();

        //console.log(loginUser);

        Ext.Ajax.request({
            url: '/login',
            method: 'POST',
            jsonData: loginUser,

            success: function(response, opts) {
                Ext.Viewport.animateActiveItem(1, {
                    type: 'slide',
                    direction: 'left'
                });
            },
            failure: function(response, opts) {
                Ext.Msg.alert("Login failure");
            }
        });
    }
});
