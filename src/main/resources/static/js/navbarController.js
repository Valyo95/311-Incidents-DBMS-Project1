'use strict';

var searchResults = [];

appControllers

	.controller("NavbarController", function($rootScope,$window, $scope, $http, $location, $cookieStore, notify) {
	    $scope.loginForm = {
	        username : "",
	        password : "",
	    };

	    $scope.isAdmin = function(){
	    if($rootScope.username === "admin" || $rootScope.username === "admin@admin.com"){
		    return true;
    	}
	    return false;
	    }
	    $scope.getIsLoggedIn = function () {
	        return $rootScope.isLoggedIn;
	    };
	    
	    $scope.hasAPic = function() {
	    	return $rootScope.imagePath !== "";
	    }
	    
	    $rootScope.loginUser = function() {
	        console.log("Login button pressed!");
	        
	        console.log($scope.loginForm);

	        $http({
	            method : "POST",
	            url : "/login",
	            data : angular.toJson($scope.loginForm),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _successLogin, _errorLogin );
	    };
	    

	    function _successLogin(response) {
	        console.log(response);
			console.log(response.headers('Authorization'));
			$rootScope.accessToken = response.headers('Authorization');
        	$cookieStore.put('accessToken', $rootScope.accessToken);
        	$rootScope.getUsername();
	        console.log("Cookie is: " + $cookieStore.get('accessToken'));
            console.log($scope.loginForm.username);

            localStorage.setItem("isLoggedIn", "true");
    		localStorage.setItem("username", response.data.username);
    		localStorage.setItem("imgPath", response.data.imgPath);
    		localStorage.setItem("type", response.data.type);
	        
    		console.log("to teoiio einai: " + $rootScope.type );
        	if($scope.loginForm.username === "admin" ||  $scope.loginForm.username === "admin@admin.com") {
                $location.path("/admin");
            }
        	else
    		{
                $window.location.href = "/"
    		}

            _clearFormData();
   
	    }
	    
	    function _errorLogin(response) {
	        console.log(response.statusText);
	        notify({message:'Wrong email or password!', duration: 2000});
	        
	    }
	    
	    $scope.logout = function () {
	    	_clearFormData();
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
            _clearFormData();
   
	    }

	    function _errorLoggout(response) {
	        console.log(response.statusText);
	        
	    }

	    //Clear the form
	    function _clearFormData() {
	        $scope.loginForm.username = "";
	        $scope.loginForm.password = "";
	    };
});