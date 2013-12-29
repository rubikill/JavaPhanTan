Ext.define('cam3tshop.store.ProductStore', {
    extend: 'Ext.data.Store',
	config: {
        model: 'cam3tshop.model.Product',
        proxy: {
            type: "ajax",
            api: {
                create: '/product',
                read: '/product',
                update: '/product',
                destroy: '/product/:id'
            },
            actionMethods: {
                create: 'POST',
                read: 'GET',
                update: 'PUT',
                destroy: 'DELETE'
            }
        },
        autoLoad: false
    }
});