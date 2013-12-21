'use strict';

//Product service
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
        },
        getProductsByManufacturer: {
            method: 'GET',
            isArray: true,
            params: {
                type: "manufacturer"
            }
        },
        getProductsByPromotion: {
            method: 'GET',
            isArray: true,
            params: {
                type: "promotion"
            }
        },
        getProductsByProductstate: {
            method: 'GET',
            isArray: true,
            params: {
                type: "productstate"
            }
        },
        getProductsByName: {
            method: 'GET',
            isArray: true,
            params: {
                type: "search"
            }
        }
    });
});

//Product type service
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

//Product details service
shopsv.factory('ProductDetails', function($resource) {
    return $resource('/productDetail/:id', {
        id: "@id"
    }, {
        getProductDetails: {
            method: 'GET'
        }
    });
});

//Rating servece
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