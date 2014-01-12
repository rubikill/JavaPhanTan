Ext.define('cam3tshop.view.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'main',
    requires: [
        'Ext.TitleBar',
        'Ext.Video',
        'Ext.dataview.List',
        'Ext.field.Email',
        'Ext.field.Number',
        'Ext.field.Hidden'
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
                    id: 'btn_logout_userTab'
                }, {
                    align: 'left',
                    iconCls: 'arrow_left',
                    id: 'btn_back_userTab',
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
                id: 'header_productTab',
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
                    id: 'btn_addOrUpdateProduct'
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
                }, {
                    xtype: 'formpanel',
                    id: 'form_addOrUpdateProduct',
                    items: [{
                        xtype: 'hiddenfield',
                        id: 'form_addOrUpdateProduct_id'
                    }, {
                        xtype: 'textfield',
                        name: 'name',
                        label: 'Name',
                        id: 'form_addOrUpdateProduct_name'
                    }, {
                        xtype: 'emailfield',
                        name: 'description',
                        label: 'Description',
                        id: 'form_addOrUpdateProduct_description'
                    }, {
                        xtype: 'numberfield',
                        name: 'importCount',
                        label: 'ImportCount',
                        id: 'form_addOrUpdateProduct_importCount'
                    }, {
                        xtype: 'numberfield',
                        name: 'quantity',
                        label: 'Quantity',
                        id: 'form_addOrUpdateProduct_quantity'
                    }, {
                        xtype: 'numberfield',
                        name: 'sellCount',
                        label: 'SellCount',
                        id: 'form_addOrUpdateProduct_sellCount'
                    }, {
                        xtype: 'numberfield',
                        name: 'point',
                        label: 'Point',
                        id: 'form_addOrUpdateProduct_point'
                    }, {
                        xtype: 'numberfield',
                        name: 'price',
                        label: 'Price',
                        id: 'form_addOrUpdateProduct_price'
                    }, {
                        xtype: 'textfield',
                        name: 'status',
                        label: 'Status',
                        id: 'form_addOrUpdateProduct_status'
                    }, {
                        xtype: 'textfield',
                        name: 'url',
                        label: 'Url',
                        id: 'form_addOrUpdateProduct_url'
                    }, {
                        xtype: 'button',
                        text: 'Save',
                        id: 'form_addOrUpdateProduct_saveButton'
                    }]
                }]
            }]
        }]
    }
});