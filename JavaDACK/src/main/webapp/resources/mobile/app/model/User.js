Ext.define('cam3tshop.model.User', {
    extend: 'Ext.data.Model',
    config: {
        fields: [{
            name: 'email',
            type: 'auto'
        }, {
            name: 'token',
            type: 'auto'
        }, {
            name: 'phone',
            type: 'auto'
        }, {
            name: 'birthday',
            type: 'auto'
        }, {
            name: 'accountType',
            type: 'auto'
        }, {
            name: 'accountTypeId',
            type: 'auto'
        }, {
            name: 'name',
            type: 'auto'
        }, {
            name: 'address',
            type: 'auto'
        }, {
            name: 'point',
            type: 'auto'
        }, {
            name: 'password',
            type: 'auto'
        }, {
            name: 'status',
            type: 'auto'
        }]
    }
    //,
    // sorters: [{
    //     property: 'id',
    //     direction: 'ASC'
    // }],
    // validations: [{
    //     type: 'presence',
    //     field: 'name',
    //     message: 'Error Text'
    // }],
    // proxy: {
    //     type: '',
    //     id: ''
    // }


});
