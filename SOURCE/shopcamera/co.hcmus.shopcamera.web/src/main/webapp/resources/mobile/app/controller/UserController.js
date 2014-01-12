Ext.define('cam3tshop.controller.UserController', {
    extend: 'Ext.app.Controller',
    requires: [
        //''
    ],

    config: {
        stores: [
            //'store'
        ],
        control: {
            addOrUpdateUserButton: {
                tap: 'onAddOrUpdateUserButtonTap'
            },
            backButton: {
                tap: 'onBackButtonTap'
            },
            saveButton: {
                tap: 'onSaveButtonTap'
            },
            listUser: {
                itemtap: 'onItemTap'
            }
        },

        refs: {
            addOrUpdateUserButton: '#btn_addOrUpdateUser',
            backButton: '#btn_back_userTab',
            saveButton: '#form_addOrUpdateUser_saveButton',
            listUser: '#lv_User'
        }
    },

    //controller methods
    onAddOrUpdateUserButtonTap: function() {
        console.log("add user tap");

        Ext.getCmp('btn_logout_userTab').hide();
        Ext.getCmp('btn_addOrUpdateUser').hide();

        Ext.getCmp('btn_back_userTab').show();

        Ext.getCmp('tabUser').animateActiveItem(1, {
            type: 'slide',
            direction: 'left'
        });


        Ext.getCmp('header_userTab').setTitle('Add user');

    },

    onBackButtonTap: function() {
        console.log("back button tap");

        Ext.getCmp('btn_logout_userTab').show();
        Ext.getCmp('btn_addOrUpdateUser').show();

        Ext.getCmp('btn_back_userTab').hide();

        Ext.getCmp('tabUser').animateActiveItem(0, {
            type: 'slide',
            direction: 'right'
        });

        Ext.getCmp('header_userTab').setTitle('');
    },

    onSaveButtonTap: function() {
        console.log("save button tap");

        var userStore = Ext.getStore('UserStore');

        // console.log(userStore);

        var newUser = {};
        var method = 'POST';
        newUser.name = Ext.getCmp('form_addOrUpdateUser_name').getValue();
        newUser.email = Ext.getCmp('form_addOrUpdateUser_email').getValue();
        newUser.phone = Ext.getCmp('form_addOrUpdateUser_phone').getValue();
        newUser.address = Ext.getCmp('form_addOrUpdateUser_address').getValue();
        //newUser.accountType = Ext.getCmp('form_addOrUpdateUser_accountType').getValue();

        if(Ext.getCmp('header_userTab').getTitle() == 'Edit user'){
            method = 'PUT';
        }

        Ext.Ajax.request({
            url: '/account',
            method: method,
            jsonData: newUser,

            success: function(response, opts) {
                Ext.Msg.alert("success");

                //Duplicate code here
                Ext.getCmp('btn_logout_userTab').show();
                Ext.getCmp('btn_addOrUpdateUser').show();

                Ext.getCmp('btn_back_userTab').hide();

                Ext.getCmp('tabUser').animateActiveItem(0, {
                    type: 'slide',
                    direction: 'right'
                });

                Ext.getCmp('header_userTab').setTitle('');

                userStore.load();

                //
            },
            failure: function(response, opts) {
                Ext.Msg.alert("failure");
            }
        });
    },

    onItemTap: function (index, target, record, e, eOpts) {        
        var selectedUser = e.data;

        Ext.getCmp('btn_logout_userTab').hide();
        Ext.getCmp('btn_addOrUpdateUser').hide();

        Ext.getCmp('btn_back_userTab').show();

        Ext.getCmp('tabUser').animateActiveItem(1, {
            type: 'slide',
            direction: 'left'
        });

        Ext.getCmp('header_userTab').setTitle('Edit user');

        Ext.getCmp('form_addOrUpdateUser_name').setValue(selectedUser.name);
        Ext.getCmp('form_addOrUpdateUser_email').setValue(selectedUser.email);
        Ext.getCmp('form_addOrUpdateUser_phone').setValue(selectedUser.phone);
        Ext.getCmp('form_addOrUpdateUser_address').setValue(selectedUser.address);
    }
});
