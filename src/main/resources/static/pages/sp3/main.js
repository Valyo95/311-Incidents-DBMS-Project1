'use strict';

appControllers.controller("SP3Controller", function($scope, $http, $location, $rootScope, $window, notify) {
		
	$scope.searchPath = '/getTotalRequestsPerType';
	$scope.searchResults = [];

	$scope.searchParams = {
		startDate : "",
		endDate : ""
	};

	$scope.resetAllParams = function() {
		$scope.searchParams.startDate = "";
		$scope.searchParams.endDate = "";
	}

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  	};

	//New incident
	$scope.search = function() {
		//console.log('in createPost');
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
				$scope.resetAllParams();
				$scope.searchResults = response.data;
			},
			_error)
	}

   function _error(response) {
  		notify({message: response, duration: 5000});
   		console.log(response);
   }



});
		