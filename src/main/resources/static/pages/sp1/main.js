'use strict';

appControllers.controller("SP1Controller", function($scope, $http, $location, $rootScope, $window, notify) {
		
	$scope.searchPath = '/getTotalRequestsPerType';
	$scope.searchResults = [];
	$scope.hasSearched = false;

	$scope.searchParams = {
		startDate : "",
		endDate : ""
	};

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  	};

	$scope.search = function() {
		$scope.hasSearched = true;

		$http({
			method : "GET",
			url : $scope.searchPath,
			params : {
				fromDate: $scope.searchParams.startDate,
				toDate: $scope.searchParams.endDate
			},
			headers : {
			  'Content-Type' : 'application/json'
			}
		})
		.then(
			function(response) {
				$scope.searchResults = response.data;
			},
			_error)
	}

   function _error(response) {
  		notify({message: response, duration: 5000});
   		console.log(response);
   }



});
		