'use strict';

var searchResults = [];

appControllers

	.controller("SettingsController", function($rootScope,$window, $scope, $http, $location, $cookieStore, notify) {
		$scope.confirmPassword = "";
	    $scope.changePasswordForm = {
	        oldPassword : "",
	        newPassword: "",
	    };
	    $scope.newEmail = "";
	    
	    $scope.changeUsername = function() {
			
			//change password
		    var method = "";
		    var url = "";
		    
		    method = "POST";
		    url = '/changeUsername';

		    $http({
		        method : method,
		        url : url,
		        params : {newUsername : $scope.newUsername},
		        headers : {
		            'Content-Type' : 'application/json'
		        }
		    }).then( $scope.successUsername, _error );
			
		};
	    
	    $scope.changePassword = function() {
			if( !validatePassword($scope.changePasswordForm.newPassword, $scope.confirmPassword))
			{
				notify({message:'Password and confirmation password fields don\'t match!', duration: 2000});
				return;
			}
			
			//change password
		    var method = "";
		    var url = "";
		    
		    method = "POST";
		    url = '/changePassword';

		    $http({
		        method : method,
		        url : url,
		        data : angular.toJson($scope.changePasswordForm),
		        headers : {
		            'Content-Type' : 'application/json'
		        }
		    }).then( _success, _error );
			
		};
		
		$scope.successUsername = function(response){
			console.log(response);
			if(response.data.status == "Successfully changed username")
			{
				alert("Email changed with success!\nYou must login again for privacy reason.");
				$scope.logout();
			}
			else
				notify({message:response.data.status, duration: 2000});
		}
		
		$scope.logout = function () {
			console.log("Email changed with success!\nYou must login again for privacy reason.");
	        delete $rootScope.user;
	        delete $rootScope.accessToken;
	        localStorage.setItem("isLoggedIn", "false");
    		localStorage.setItem("username", "");
    		localStorage.setItem("imgPath", "");
    		localStorage.setItem("type", "Anonymous");

	        $cookieStore.remove('accessToken');
	        $rootScope.isLoggedIn = false;
	        $rootScope.username = "";
	        
	        $http({
	            method : "GET",
	            url : "/logout",
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _successLoggout, _errorLoggout );
	        
	        //$location.path("/");
	        $window.location.href = "/"
	    };
	    
	    function _successLoggout(response) {
	        console.log("Cookie is: " + $cookieStore.get('accessToken'));
	    }

	    function _errorLoggout(response) {
	        console.log(response.statusText);
	    }
	    
		function _success(response) {
			if (response.data) {
				notify({message:response.data.status, duration: 2000});
				$scope.changePasswordForm.oldPassword = "";
				$scope.changePasswordForm.newPassword = "";
				$scope.confirmPassword = "";
			}
		}

		function _error(response) {
		    console.log(response.statusText);
		}

		function sleep_ms(millisecs) {
		    var initiation = new Date().getTime();
		    while ((new Date().getTime() - initiation) < millisecs);
		}
	    
	    //HTTP POST/PUT methods for add/edit customer 
	    // with the help of id, we are going to find out whether it is put or post operation
	    function validatePassword(password1, password2)
	    {
	    	if(password1 === password2)
	    		return true;
	    	else
	    		return false;
	    }
});