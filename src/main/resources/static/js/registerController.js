'use strict';

var searchResults = [];

appControllers

	.controller("RegisterCtrl", function($rootScope, $scope, $http, $cookieStore, $location, notify) {

	   $scope.confirmPassword= "";
		
	   $scope.picture={};
	   
	    $scope.registerForm = {
	    	username : "",
	        firstName : "",
	        lastName : "",
	        email : "",
	        password: "",
	        phone: "",
	        type: "",
	        imagePath: ""
	    };
	    

	    //HTTP POST/PUT methods for add/edit customer 
	    // with the help of id, we are going to find out whether it is put or post operation
	    function validatePassword(password1, password2)
	    {
	    	if(password1 === password2)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    $scope.registerUser = function() {
			if( !validatePassword($scope.registerForm.password, $scope.confirmPassword))
			{
				notify({message:'Password and confirmation password fields don\'t match!', duration: 2000});
				return;
			}
			
			checkUsername($scope.registerForm.username);
			
		};
		
		function checkUsername(username) {
			
			var usernameObj = {
					username: "",
			}
			
			usernameObj.username = username;
			
	        $http({
	            method : "POST",
	            url : "/isUsernameTaken",
	            data : angular.toJson(usernameObj),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _successCheckUsername, _error );
		}
		
		 function _successCheckUsername(response) {
			 if (response.data.message == true) {
					notify({message:'This username is already in use!', duration: 2000});		
			 }
			 else {
				    var picture = $scope.picture;
				    var url = '/register/uploadUserPic';

			        var fd = new FormData();
			        fd.append('file', picture);
			        fd.append('username', $scope.registerForm.email);
			        
				    $http({
				        method : "POST",
				        url : url,
				        data : fd,
				        transformRequest: angular.identity,
			            headers: {'Content-Type': undefined}
				    }).then(_successUpload, _error);
			 }
		 }
		 
		function _successUpload(response) {
			//add user to database
		    var method = "";
		    var url = "";

		    //response message contains the path where the image was saved
		    $scope.registerForm.imagePath = response.data.message;
		    
		    method = "POST";
		    url = '/register/addUser';

		    $http({
		        method : method,
		        url : url,
		        data : angular.toJson($scope.registerForm),
		        headers : {
		            'Content-Type' : 'application/json'
		        }
		    }).then( _success, _error );
		}
		
		function _success(response) {
			if (response.data) {
				notify({message:"User " + $scope.registerForm.username + " was successfully registered!", duration: 2000});
	    		login($scope.registerForm.username, $scope.registerForm.password);
	    		$location.path("/");
			}
		}

		function _error(response) {
		    console.log(response.statusText);
		}

		//Clear the form
		function _clearFormData() {
		    $scope.registerForm.firstName = "",
		    $scope.registerForm.lastName = "";
		    $scope.registerForm.email = "";
		    $scope.registerForm.password = "";
		    $scope.registerForm.type = "";
		    $scope.registerForm.phone = "",
		    $scope.confirmPassword = "";
		};
		
		
		//login function used to login succesfully register users (get token)
		function login(username, password) {
			
	        var userPass = {
	        	username : "",
	        	password : ""
	        };
	        
	        userPass.username = username;
	        userPass.password = password;
			
	        $http({
	            method : "POST",
	            url : "/login",
	            data : angular.toJson(userPass),
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _successLogin, _error );
	    };
	    

	    function _successLogin(response) {
	        console.log(response);
			console.log(response.headers('Authorization'));
			$rootScope.accessToken = response.headers('Authorization');
        	$cookieStore.put('accessToken', $rootScope.accessToken);
	        $rootScope.getUsername();
   
	    }
	    
	    function _error(response) {
	        console.log(response.statusText);	        
	    }
});
