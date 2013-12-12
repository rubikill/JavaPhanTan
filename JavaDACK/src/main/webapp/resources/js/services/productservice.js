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
        //trong truong hop lay 1 san pham thi type la id cua san pham
        type: "@type"
    }, {
        getProductTypes: {
            method: 'GET',
            isArray: true
        }
    });
});