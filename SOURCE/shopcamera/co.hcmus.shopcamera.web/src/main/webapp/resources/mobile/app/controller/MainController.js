Ext.define('cam3tshop.controller.MainController', {
    extend: 'Ext.app.Controller',
    requires: [
        //''
    ],

    config: {
        stores: [
            //'store'
        ],
        control: {
            logoutButton: {
                tap: 'onLogoutButtonTap'
            },
            logoutButton1: {
                tap: 'onLogoutButtonTap'
            },
            mainTabBar: {
                activeitemchange: 'onActiveitemchange'
            }
        },

        refs: {
            logoutButton: '#btn_logout',
            logoutButton1: '#btn_logout_userTab',
            mainTabBar: '#tabBarMain'
        }
    },

    //controller methods
    onLogoutButtonTap: function() {
        Ext.Ajax.request({
            url: '/logout',
            method: 'GET',
            success: function(response, opts) {
                Ext.Viewport.animateActiveItem(0, {
                    type: 'slide',
                    direction: 'right'
                });
            }
        });
    },
    onActiveitemchange: function (value, oldValue, eOpts) {
        if(Ext.getCmp('tabBarMain').getActiveItem().title == 'User'){
            Ext.getStore('UserStore').load();
        }

        if(Ext.getCmp('tabBarMain').getActiveItem().title == 'Product'){
            Ext.getStore('ProductStore').load();
        }
    }
});
