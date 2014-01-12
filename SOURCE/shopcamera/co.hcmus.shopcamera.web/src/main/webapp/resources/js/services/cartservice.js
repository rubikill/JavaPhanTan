'use strict';

//Cart service
shopsv.factory('Cart', function ($resource) {
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
        },
        updateCart: {
            method: 'PUT',
            params: {
                id: 'updateCart'
            }
        }
    });
});

shopsv.factory('History', function ($resource) {
    return $resource('history/:action/:id', {
        action: '@action',
        id: '@id'
    }, {
        checkout: {
            method: 'POST',
            params: {
                action: 'create'
            }
        },
        getHistory: {
            method: 'GET',
            isArray: true
        },
        cancelHistory: {
            method: 'POST'
        }
    });
});