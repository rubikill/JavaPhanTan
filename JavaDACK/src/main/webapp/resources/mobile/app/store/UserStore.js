Ext.define('cam3tshop.store.UserStore', {
    extend: 'Ext.data.Store',
    config: {
        model: 'cam3tshop.model.User',
        proxy: {
            type: "ajax",
            api: {
                create: '/account',
                read: '/account',
                update: '/account',
                destroy: '/account'
            },
            actionMethods: {
                create: 'POST',
                read: 'GET',
                update: 'PUT',
                destroy: 'DELETE'
            }
        },
        autoLoad: true
    }
});
