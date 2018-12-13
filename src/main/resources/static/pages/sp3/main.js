'use strict';

appControllers.controller("SP3Controller", function($scope, $http, $location, $rootScope, $window, notify) {
		
	$scope.searchPath = '/mostCommonServicePerZipCode';
	$scope.searchResults = [];

	$scope.searchParams = {
		date : ""
	};

	//Infinite scroll vars
	$scope.currentType = "";
	$scope.start = 0;
	$scope.size = 10;
	$scope.isBusy = true;

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  	};

	$scope.search = function() {
		//Reset infinite-scroll params and data
		$scope.currentType = $scope.selectedRequestType;
		$scope.start = 0;
		$scope.searchResults = [];


		$http({
			method : "GET",
			url : $scope.searchPath,
			params : {
				start : $scope.start,
				size : $scope.size,
				date: $scope.searchParams.date
			},
			headers : {
			  'Content-Type' : 'application/json'
			}
		})
		.then(_success, _error)
	}

   $scope.addResults = function () {
   	if($scope.isBusy === true) return; // request in progress, return
   	$scope.isBusy = true;
   	$http({
			method : "GET",
			url : $scope.searchPath,
			params : {
				start : $scope.start,
				size : $scope.size,
				date: $scope.searchParams.date
			}
		}).then(_success, _error);
   }

   	function _success(response) {

   		var newResults = response.data;
   		
		for (var i = 0; i < newResults.length; i++) {
			$scope.searchResults.push(newResults[i]);
		}

		$scope.start += newResults.length;
		$scope.isBusy = false; 
	}

   function _error(response) {
  		notify({message: response, duration: 5000});
   		console.log(response);
   }

});
		