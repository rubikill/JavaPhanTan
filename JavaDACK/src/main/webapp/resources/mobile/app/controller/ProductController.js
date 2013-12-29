Ext.define('cam3tshop.controller.ProductController', {
    extend: 'Ext.app.Controller',
    requires: [
        //''
    ],

    config: {
        stores: [
            //'store'
        ],
        control: {
            // logoutButton: {
            //     tap: 'onLogoutButtonTap'
            // }
        },

        refs: {
            //logoutButton: '#btn_logout'
        }
    }
    //,

    //controller methods
    // onLogoutButtonTap: function() {
    //     Ext.Ajax.request({
    //         url: '/logout',
    //         method: 'GET',
    //         success: function(response, opts) {
    //             Ext.Viewport.animateActiveItem(0, {
    //                 type: 'slide',
    //                 direction: 'right'
    //             });
    //         }
    //     });
    // }
});
