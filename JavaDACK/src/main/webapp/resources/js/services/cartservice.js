'use strict';

//Cart service
shopsv.factory('Cart', function($resource) {
    return $resource('/cart/:id', {
        id: "@id"
    }, {
        getCart: {
            method: 'GET',
            isArray: true
        },
        addProductToCart: {
            method: 'POST',
            isArray: true
        },
        removeProductFromCart: {
            method: 'DELETE'
        }
    });
});