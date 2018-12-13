'use strict';

appControllers.controller("ReportController", function($scope, $http, $location, $rootScope, $window, notify) {
		
	$scope.endpointPath = '';
	$scope.createPath = '/create';

	$scope.defaultCreateParams = {
		status : "",
		streetAddress : "",
		zipCode : "",
		xCoordinate : "",
		yCoordinate : "",
		ward : "",
		policeDistrict : "",
		communityArea : "",
		latitude : "",
		longitude : "",
		location : ""
	};

	$scope.abandonedVehiclesEndpoint = "/abandonedVehiclesEndpoint"
	$scope.abandonedVehiclesParams = {
		licensePlate : "",
		model : "",
		color : "",
		currentActivity : "",
		mostRecentAction : "",
		daysAbandoned : "",
		ssa : ""
	};

	$scope.alleyLightsOutEndpoint = "/alleyLightsOutEndpoint";
	$scope.alleyLightsOutParams = {
	};	

	$scope.garbageCartsEndpoint = "/garbageCartsEndpoint";
	$scope.garbageCartsParams = {
		blackCartsDelivered : "",
		currentActivity : "",
		mostRecentAction : "",
		ssa : ""
	};

	$scope.graffitiRemovalEndpoint = "/graffitiRemovalEndpoint";
	$scope.graffitiRemovalParams = {
		typeOfSurface : "",
		located : "",
		ssa : ""
	};

	$scope.potHolesEndpoint = "/potHolesEndpoint";
	$scope.potHolesParams = {
		currentActivity : "",
		mostRecentAction : "",
		potHoles : "",
		ssa : ""
	};

	$scope.rodentBaitingEndpoint = "/rodentBaitingEndpoint";
	$scope.rodentBaitingParams = {
		premisesBaited : "",
		premisesWithGarbage : "",
		premisesWithRats : "",
		currentActivity : "",
		mostRecentAction : ""
	};

	$scope.sanitationCodeComplaintsEndpoint = "/sanitationCodeComplaintsEndpoint";
	$scope.sanitationCodeComplaintsParams = {
		natureOfViolation : ""
	};

	$scope.lightsAllOutEndpoint = "/lightsAllOutEndpoint";
	$scope.lightsAllOutParams = {
	};

	$scope.streetLightOneOutEndpoint = "/streetLightOneOutEndpoint";
	$scope.streetLightOneOutParams = {
	};

	$scope.treeDebrisEndpoint = "/treeDebrisEndpoint";
	$scope.treeDebrisParams = {
		location2 : "",
		currentActivity : "",
		mostRecentAction : ""
	};

	$scope.treeTrimsEndpoint = "/treeTrimsEndpoint";
	$scope.treeTrimsParams = {
		location2 : ""
	};

	$scope.requestTypes = [
		"ABANDONED VEHICLE",
		"ALLEY LIGHTS OUT",
		"GARBAGE CART",
		"GRAFFITI REMOVAL",
		"POT HOLES",
		"RODENT BAITING",
		"SANITATION CODE",
		"LIGHTS ALL OUT",
		"STREET LIGHT ONE OUT",
		"TREE DEBRIS",
		"TREE TRIMS"
	];

	$scope.endpointPath = $scope.abandonedVehiclesEndpoint;
	$scope.selectedRequestType = $scope.requestTypes[0];
	$scope.incidentParams = $.extend({}, $scope.defaultCreateParams, $scope.abandonedVehiclesParams);

	$scope.updateEndpointPath = function() {

		switch ($scope.selectedRequestType) {
			case ($scope.requestTypes[0]):
				$scope.endpointPath = $scope.abandonedVehiclesEndpoint;
				break;
			case ($scope.requestTypes[1]):
				$scope.endpointPath = $scope.alleyLightsOutEndpoint;
				break;
			case ($scope.requestTypes[2]):
				$scope.endpointPath = $scope.garbageCartsEndpoint;
				break;
			case ($scope.requestTypes[3]):
				$scope.endpointPath = $scope.graffitiRemovalEndpoint;
				break;
			case ($scope.requestTypes[4]):
				$scope.endpointPath = $scope.potHolesEndpoint;
				break;
			case ($scope.requestTypes[5]):
				$scope.endpointPath = $scope.rodentBaitingEndpoint;
				break;
			case ($scope.requestTypes[6]):
				$scope.endpointPath = $scope.sanitationCodeComplaintsEndpoint;
				break;
			case ($scope.requestTypes[7]):
				$scope.endpointPath = $scope.lightsAllOutEndpoint;
				break;
			case ($scope.requestTypes[8]):
				$scope.endpointPath = $scope.streetLightOneOutEndpoint;
				break;
			case ($scope.requestTypes[9]):
				$scope.endpointPath = $scope.treeDebrisEndpoint;
				break;
			case ($scope.requestTypes[10]):
				$scope.endpointPath = $scope.treeTrimsEndpoint;
				break;
		}
	}

	$scope.getIncidentParams = function() {

		switch ($scope.selectedRequestType) {
			case ($scope.requestTypes[0]):
				return $.extend({}, $scope.defaultCreateParams, $scope.abandonedVehiclesParams);
			case ($scope.requestTypes[1]):
				return $.extend({}, $scope.defaultCreateParams, $scope.alleyLightsOutParams);
			case ($scope.requestTypes[2]):
				return $.extend({}, $scope.defaultCreateParams, $scope.garbageCartsParams);
			case ($scope.requestTypes[3]):
				return $.extend({}, $scope.defaultCreateParams, $scope.graffitiRemovalParams);
			case ($scope.requestTypes[4]):
				return $.extend({}, $scope.defaultCreateParams, $scope.potHolesParams);
			case ($scope.requestTypes[5]):
				return $.extend({}, $scope.defaultCreateParams, $scope.rodentBaitingParams);
			case ($scope.requestTypes[6]):
				return $.extend({}, $scope.defaultCreateParams, $scope.sanitationCodeComplaintsParams);
			case ($scope.requestTypes[7]):
				return $.extend({}, $scope.defaultCreateParams, $scope.lightsAllOutParams);
			case ($scope.requestTypes[8]):
				return $.extend({}, $scope.defaultCreateParams, $scope.streetLightOneOutParams);
			case ($scope.requestTypes[9]):
				return $.extend({}, $scope.defaultCreateParams, $scope.treeDebrisParams);
			case ($scope.requestTypes[10]):
				return $.extend({}, $scope.defaultCreateParams, $scope.treeTrimsParams);
		}
	}

	$scope.resetAllParams = function() {
		$scope.defaultCreateParams.status = "";
		$scope.defaultCreateParams.streetAddress = "";
		$scope.defaultCreateParams.zipCode = "";
		$scope.defaultCreateParams.xCoordinate = "";
		$scope.defaultCreateParams.yCoordinate = "";
		$scope.defaultCreateParams.ward = "";
		$scope.defaultCreateParams.policeDistrict = "";
		$scope.defaultCreateParams.communityArea = "";
		$scope.defaultCreateParams.latitude = "";
		$scope.defaultCreateParams.longitude = "";
		$scope.defaultCreateParams.location = "";

		$scope.abandonedVehiclesParams.licensePlate = "";
		$scope.abandonedVehiclesParams.model = "";
		$scope.abandonedVehiclesParams.color = "";
		$scope.abandonedVehiclesParams.currentActivity = "";
		$scope.abandonedVehiclesParams.mostRecentAction = "";
		$scope.abandonedVehiclesParams.daysAbandoned = "";
		$scope.abandonedVehiclesParams.ssa = "";

		$scope.garbageCartsParams.blackCartsDelivered = "";
		$scope.garbageCartsParams.currentActivity = "";
		$scope.garbageCartsParams.mostRecentAction = "";
		$scope.garbageCartsParams.ssa = "";

		$scope.graffitiRemovalParams.typeOfSurface = "";
		$scope.graffitiRemovalParams.located = "";
		$scope.graffitiRemovalParams.ssa = "";

		$scope.potHolesParams.currentActivity = "";
		$scope.potHolesParams.mostRecentAction = "";
		$scope.potHolesParams.potHoles = "";
		$scope.potHolesParams.ssa = "";

		$scope.rodentBaitingParams.premisesBaited = "";
		$scope.rodentBaitingParams.premisesWithGarbage = "";
		$scope.rodentBaitingParams.premisesWithRats = "";
		$scope.rodentBaitingParams.currentActivity = "";
		$scope.rodentBaitingParams.mostRecentAction = "";

		$scope.sanitationCodeComplaintsParams.natureOfViolation = "";

		$scope.treeDebrisParams.location2 = "";
		$scope.treeDebrisParams.currentActivity = "";
		$scope.treeDebrisParams.mostRecentAction = "";

		$scope.treeTrimsParams.location2 = "";	
	}

	$scope.getIsLoggedIn = function () {
        return $rootScope.isLoggedIn;
  	};

	//New incident
	$scope.reportIncident = function() {
		//console.log('in createPost');
		$http({
			method : "POST",
			url : $scope.endpointPath + $scope.createPath,
			params : $scope.getIncidentParams(),
			headers : {
			  'Content-Type' : 'application/json'
			}
		})
		.then(
			function(response) {
				$scope.resetAllParams();
				notify({message: "Incident reported!\nService Request Number: " + response.data.incident.srn, duration: 2000});
			},
			_error)
	}

   function _error(response) {
  		notify({message: response, duration: 5000});
   		console.log(response);
   }

});
		