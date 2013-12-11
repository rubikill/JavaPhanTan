'use strict';

function menuCtrl($location, $scope, localize, $rootScope, $cookieStore) {
	$scope.path = $location.path();

	$scope.$on('$locationChangeSuccess', function() {
		$scope.path = $location.path();
		console.log($scope.path);
	});

	/**
	 * Change localize when switch language
	 */
	 $rootScope.$watch('currentLanguage', function(newLang, oldLang) {
	 	if (!newLang) {
	 		return;
	 	}

	 	$rootScope.currentLanguage = newLang;
		// store at cookie
		$cookieStore.put("language", newLang);
		// the first load localize resource file
		localize.language = newLang.localize;
		localize.setLanguage($rootScope.currentLanguage.localize);
	});
}