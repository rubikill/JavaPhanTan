'use strict';

shopsv.factory('Product', function($resource) {
	return $resource('/product/:type/:id', {
		//trong truong hop lay 1 san pham thi type la id cua san pham
		type: "@type",
		id : "@id"
	}, {
		getProducts : {
			method : 'GET',
			isArray : true
		},
		getProductById : {
			method : 'GET'
		},
		getProductType : {
			method : 'GET',
			isArray : true,
			params : {
				type : "type"
			}
		},
		getProductByType : {
			method : 'GET',
			isArray : true,
			params : {
				type : "type"
			}
		}
	});
});
