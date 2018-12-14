'use strict';

appControllers.controller("SP2Controller", function($scope, $http, $location, $rootScope, $window, notify) {
		
	$scope.searchPath = '/getTotalRequestsPerDayAndType';
	$scope.searchResults = [];
	$scope.hasSearched = false;

	$scope.requestTypes = [
		{name : "ABANDONED VEHICLE", value : "ABANDONED_VEHICLES"},
		{name : "ALLEY LIGHTS OUT", value : "ALLEY_LIGHTS_OUT"},
		{name : "GARBAGE CART", value : "GARBAGE_CARTS"},
		{name : "GRAFFITI REMOVAL", value : "GRAFFITI_REMOVAL"},
		{name : "POT HOLES", value : "POT_HOLES_REPORTED"},
		{name : "RODENT BAITING", value : "RODENT_BAITING"},
		{name : "SANITATION CODE", value : "SANITATION_CODE_COMPLAINTS"},
		{name : "LIGHTS ALL OUT", value : "LIGHTS_ALL_OUT"},
		{name : "STREET LIGHT ONE OUT", value : "STREET_LIGHT_ONE_OUT"},
		{name : "TREE DEBRIS", value : "TREE_DEBRIS"},
		{name : "TREE TRIMS", value : "TREE_TRIMS"}
	];

	$scope.selectedRequestType = $scope.requestTypes[0];

	$scope.searchParams = {
		startDate : "",
		endDate : ""
	};

	//Infinite scroll vars
	$scope.currentType = "";
	$scope.currentStart = "";
	$scope.currentEnd = "";
	$scope.start = 0;
	$scope.size = 10;
	$scope.isBusy = true;

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  	};

	$scope.search = function() {
		$scope.hasSearched = true;

		//Reset infinite-scroll params and data
		$scope.currentType = $scope.selectedRequestType;
		$scope.currentStart = $scope.searchParams.startDate;
		$scope.currentEnd = $scope.searchParams.endDate;
		$scope.start = 0;
		$scope.searchResults = [];


		$http({
			method : "GET",
			url : $scope.searchPath,
			params : {
				start : $scope.start,
				size : $scope.size,
				type: $scope.currentType.value,
				fromDate: $scope.currentStart,
				toDate: $scope.currentEnd
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
				type: $scope.currentType.value,
				fromDate: $scope.currentStart,
				toDate: $scope.currentEnd
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
		