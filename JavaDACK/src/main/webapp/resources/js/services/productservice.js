'use strict';

shopsv.factory('Product', function($resource) {
    return $resource('/product/:type/:id', {
        type: "@type",
        id: "@id"
    }, {
        getProducts: {
            method: 'GET',
            isArray: true
        },
        getProductById: {
            method: 'GET'
        },
        getProductsByType: {
            method: 'GET',
            isArray: true,
            params: {
            	type: "type"
            }
        }
    });
});

shopsv.factory('ProductType', function($resource) {
    return $resource('/type', {
        type: "@type"
    }, {
        getProductTypes: {
            method: 'GET',
            isArray: true
        }
    });
});

shopsv.factory('ProductDetails', function($resource) {
    return $resource('/productDetail/:id', {
        id: "@id"
    }, {
        getProductDetails: {
            method: 'GET'
        }
    });
});

shopsv.factory('Rating', function ($resource) {
    return $resource('/rating/:productId', {
        productId: "@productId"
    }, {
        getRate: {
            method: 'POST'
        },
        doRate: {
            method: 'PUT'
        }
    });
});