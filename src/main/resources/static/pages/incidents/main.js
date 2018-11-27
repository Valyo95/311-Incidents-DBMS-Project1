'use strict';

appControllers.controller("IncidentsController", function($scope, $http, $location, $rootScope, $window, notify) {
		
	var endpointPath = '/incidentsEndpoint';
	$scope.fetchPath = endpointPath + '/fetchAll';
	$scope.createPath = endpointPath + '/create';
	
	// Page data
	$scope.data = {};

	$scope.incidents = [];

	//Infinite scroll vars
	$scope.start = 0;
	$scope.size = 5;
	$scope.isBusy = true;

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  };

	//New incident
	$scope.createIncident = function() {
		//console.log('in createPost');
		$http({
			method : "POST",
			url : $scope.createPath,
			data : angular.toJson({str : $scope.content}),
      headers : {
          'Content-Type' : 'application/json'
      }
		})
		.then(
			function(response) {
				//console.log('done with content')
				var incidentId = response.data.id;
			},
			_error)
	}

	// Get data function for this page
	$scope.fetchAll = function() { 
		$http({
			method : "GET",
			url : $scope.fetchPath,
			params : {
				start : $scope.start,
				size : $scope.size
			}
		}).then(_success, _error);
	}
	

	function _success(response) {

   		var newIncidents = response.data.first;
   		
		for (var i = 0; i < newIncidents.length; i++) {
			$scope.incidents.push(newIncidents[i]);

			var incidentId = newIncidents[i].id;
		}

		$scope.start += newIncidents.length;
		$scope.isBusy = false; 
	}

   function _error(response) {
       console.log(response.statusText);
   }

   $scope.addIncidents = function () {
   	if($scope.isBusy === true) return; // request in progress, return
   	$scope.isBusy = true;
   	$http({
			method : "GET",
			url : $scope.fetchPath,
			params : {
				start : $scope.start,
				size : $scope.size
			}
		}).then(_success, _error);
   }

  $scope.viewUser = function(id) {
    $window.sessionStorage.setItem("userId", id);
    $location.path('/profile');
  }
   
   // Invoke the fetch all function
   $scope.fetchAll();

});
		