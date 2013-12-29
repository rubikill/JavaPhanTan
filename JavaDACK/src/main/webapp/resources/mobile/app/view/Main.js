Ext.define('cam3tshop.view.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'main',
    requires: [
        'Ext.TitleBar',
        'Ext.Video',
        'Ext.dataview.List'
    ],

    config: {
        tabBarPosition: 'bottom',
        id: 'tabBarMain',

        items: [{
            title: 'User',
            iconCls: 'user',

            items: [{
                docked: 'top',
                xtype: 'titlebar',
                id: 'header_userTab',
                items: [{
                    xtype: 'button',
                    align: 'left',
                    text: 'logout',
                    id: 'btn_logout'
                }, {
                    align: 'left',
                    iconCls: 'arrow_left',
                    id: 'btn_back',
                    hidden: true
                }, {
                    xtype: 'button',
                    align: 'right',
                    iconCls: 'add',
                    id: 'btn_addOrUpdateUser'
                }]
            }, {
                xtype: 'panel',
                id: 'tabUser',
                layout: {
                    type: 'card'
                },

                height: '100%',
                width: '100%',
                items: [{
                    id: 'lv_User',
                    xtype: 'list',
                    store: 'UserStore',
                    itemTpl: '{email}'
                }, {
                    xtype: 'formpanel',
                    id: 'form_addOrUpdateUser',
                    items: [{
                        xtype: 'textfield',
                        name: 'name',
                        label: 'Name',
                        id: 'form_addOrUpdateUser_name'
                    }, {
                        xtype: 'emailfield',
                        name: 'email',
                        label: 'Email',
                        id: 'form_addOrUpdateUser_email'
                    }, {
                        xtype: 'textfield',
                        name: 'phone',
                        label: 'Phone',
                        id: 'form_addOrUpdateUser_phone'
                    }, {
                        xtype: 'textfield',
                        name: 'address',
                        label: 'Address',
                        id: 'form_addOrUpdateUser_address'
                        // }, {
                        //     xtype: 'datepickerfield',
                        //     name: 'birthday',
                        //     label: 'Birthday',
                        //     value: new Date(),
                        //     id: 'form_addOrUpdateUser_birthday'
                        // }, {
                        //     xtype: 'selectfield',
                        //     name: 'accountType',
                        //     label: 'AccountType',
                        //     options: [{
                        //         text: 'First Option',
                        //         value: 'first'
                        //     }, {
                        //         text: 'Second Option',
                        //         value: 'second'
                        //     }, {
                        //         text: 'Third Option',
                        //         value: 'third'
                        //     }],
                        //     id: 'form_addOrUpdateUser_accountType'
                    }, {
                        xtype: 'button',
                        text: 'Save',
                        id: 'form_addOrUpdateUser_saveButton'
                    }]

                }]

            }]
        }, {
            title: 'Product',
            iconCls: 'action',

            items: [{
                docked: 'top',
                xtype: 'titlebar',
                items: [{
                    align: 'left',
                    text: 'logout',
                    id: 'btn_logout'
                }, {
                    align: 'left',
                    iconCls: 'arrow_left',
                    id: 'btn_back',
                    hidden: true
                }, {
                    align: 'right',
                    iconCls: 'add',
                    id: 'btn_addProduct'
                }]
            }, {
                xtype: 'panel',
                id: 'tabProduct',
                layout: {
                    type: 'card'
                },

                height: '100%',
                width: '100%',
                items: [{
                    id: 'lv_Product',
                    xtype: 'list',
                    height: '100%',
                    width: '100%',
                    store: 'ProductStore',
                    itemTpl: '{name}'
                }]
            }]
        }]
    }
});
