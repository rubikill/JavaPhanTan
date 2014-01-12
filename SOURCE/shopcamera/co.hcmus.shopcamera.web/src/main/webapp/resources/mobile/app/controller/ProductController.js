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
            addOrUpdateProductButton: {
                tap: 'onAddOrUpdateProductButtonTap'
            },
            backButton: {
                tap: 'onBackButtonTap'
            },
            saveButton: {
                tap: 'onSaveButtonTap'
            },
            listProduct: {
                itemtap: 'onItemTap'
            }
        },

        refs: {
            addOrUpdateProductButton: '#btn_addOrUpdateProduct',
            backButton: '#btn_back',
            saveButton: '#form_addOrUpdateProduct_saveButton',
            listProduct: '#lv_Product'
        }
    },

    onAddOrUpdateProductButtonTap: function() {
        console.log("add product tap");

        Ext.getCmp('btn_logout').hide();
        Ext.getCmp('btn_addOrUpdateProduct').hide();

        Ext.getCmp('btn_back').show();

        Ext.getCmp('tabProduct').animateActiveItem(1, {
            type: 'slide',
            direction: 'left'
        });


        Ext.getCmp('header_productTab').setTitle('Add product');

    },

    onBackButtonTap: function() {
        console.log("back button tap");

        Ext.getCmp('btn_logout').show();
        Ext.getCmp('btn_addOrUpdateProduct').show();

        Ext.getCmp('btn_back').hide();

        Ext.getCmp('tabProduct').animateActiveItem(0, {
            type: 'slide',
            direction: 'right'
        });

        Ext.getCmp('header_productTab').setTitle('');
    },

    onSaveButtonTap: function() {
        console.log("save button tap");

        var productStore = Ext.getStore('ProductStore');

        // console.log(userStore);

        var newProduct = {};
        var method = 'POST';

        //Set param

        newProduct.name = Ext.getCmp('form_addOrUpdateProduct_name').getValue();
        newProduct.description = Ext.getCmp('form_addOrUpdateProduct_description').getValue();
        newProduct.importCount = Ext.getCmp('form_addOrUpdateProduct_importCount').getValue();
        newProduct.quantity = Ext.getCmp('form_addOrUpdateProduct_quantity').getValue();
        newProduct.sellCount = Ext.getCmp('form_addOrUpdateProduct_sellCount').getValue();
        newProduct.point = Ext.getCmp('form_addOrUpdateProduct_point').getValue();
        newProduct.price = Ext.getCmp('form_addOrUpdateProduct_price').getValue();
        newProduct.status = Ext.getCmp('form_addOrUpdateProduct_status').getValue();
        newProduct.url = Ext.getCmp('form_addOrUpdateProduct_url').getValue();

        if (Ext.getCmp('header_productTab').getTitle() == 'Edit product') {
            method = 'PUT';
            newProduct.id = Ext.getCmp('form_addOrUpdateProduct_id').getValue();
        }

        Ext.Ajax.request({
            url: '/product',
            method: method,
            jsonData: newProduct,

            success: function(response, opts) {
                Ext.Msg.alert("success");

                //Duplicate code here
                Ext.getCmp('btn_logout').show();
                Ext.getCmp('btn_addOrUpdateProduct').show();

                Ext.getCmp('btn_back').hide();

                Ext.getCmp('tabProduct').animateActiveItem(0, {
                    type: 'slide',
                    direction: 'right'
                });

                Ext.getCmp('header_productTab').setTitle('');

                productStore.load();

                //
            },
            failure: function(response, opts) {
                Ext.Msg.alert("failure");
            }
        });
    },

    onItemTap: function(index, target, record, e, eOpts) {
        var selectedProduct = e.data;

        Ext.getCmp('btn_logout').hide();
        Ext.getCmp('btn_addOrUpdateProduct').hide();

        Ext.getCmp('btn_back').show();

        Ext.getCmp('tabProduct').animateActiveItem(1, {
            type: 'slide',
            direction: 'left'
        });


        Ext.getCmp('header_productTab').setTitle('Edit product');

        //Set param
        Ext.getCmp('form_addOrUpdateProduct_id').setValue(selectedProduct.id);
        Ext.getCmp('form_addOrUpdateProduct_name').setValue(selectedProduct.name);
        Ext.getCmp('form_addOrUpdateProduct_description').setValue(selectedProduct.description);
        Ext.getCmp('form_addOrUpdateProduct_importCount').setValue(selectedProduct.importCount);
        Ext.getCmp('form_addOrUpdateProduct_quantity').setValue(selectedProduct.quantity);
        Ext.getCmp('form_addOrUpdateProduct_sellCount').setValue(selectedProduct.sellCount);
        Ext.getCmp('form_addOrUpdateProduct_point').setValue(selectedProduct.point);
        Ext.getCmp('form_addOrUpdateProduct_price').setValue(selectedProduct.price);
        Ext.getCmp('form_addOrUpdateProduct_status').setValue(selectedProduct.status);
        Ext.getCmp('form_addOrUpdateProduct_url').setValue(selectedProduct.url);

    }
});
