'use strict';

var app = angular.module('app', [
	'ngRoute',
    'ngCookies',
    // 'app.services',
    'app.controllers',
    'app.services',
    'cgNotify',
    '720kb.datepicker',
    'checklist-model',
    'infinite-scroll'
])
.config(['$routeProvider', '$locationProvider', '$httpProvider', function ($routeProvider, $locationProvider, $httpProvider) {
	  $routeProvider.when('/', {templateUrl: 'pages/incidents/main.html', controller: 'IncidentsController'});
      $routeProvider.when('/', {templateUrl: 'pages/report/main.html', controller: 'ReportController'});
	  $routeProvider.when('/register', {templateUrl: 'partial/register.html', controller: 'RegisterCtrl'});
	  $routeProvider.when('/settings', {templateUrl: 'partial/settings.html', controller: 'SettingsController'});
	  
	  $routeProvider.otherwise({redirectTo: '/'});
      
      $locationProvider.html5Mode(true);

             /* Register error provider that shows message on failed requests or redirects to login page on
             * unauthenticated requests */
            $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                    return {
                        'responseError': function (rejection) {
                            var status = rejection.status;
                            var config = rejection.config;
                            var method = config.method;
                            var url = config.url;

                            if (status == 401) {
                                $location.path("/");
                            } else {
                                $rootScope.error = method + " on " + url + " failed with status " + status;
                            }

                            return $q.reject(rejection);
                        }
                    };
                }
            );

            /* Registers auth token interceptor, auth token is either passed by header or by query parameter
             * as soon as there is an authenticated user */
            $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
                    return {
                        'request': function (config) {

                            if (angular.isDefined($rootScope.accessToken)) {
                                var accessToken = $rootScope.accessToken;
                                if (exampleAppConfig.useAccessTokenHeader) {
                                    config.headers['Authorization'] = accessToken;
                                    //console.log('Authorization' + accessToken);
                                } else {
                                    config.url = config.url + "?token=" + accessToken;
                                }
                            }
                            return config || $q.when(config);
                        }
                    };
                }
            );

        }]
    )
    .run(function ($rootScope, $location, $cookieStore, $http) {

    	//FUNCTIONS
    	
	    /* Reset error when a new view is loaded */
	    $rootScope.$on('$viewContentLoaded', function () {
	        delete $rootScope.error;
	    });

	    $rootScope.hasRole = function (role) {

	        if ($rootScope.user === undefined) {
	            return false;
	        }

	        if ($rootScope.user.roles[role] === undefined) {
	            return false;
	        }

	        return $rootScope.user.roles[role];
	    };
	    
	    $rootScope.getUsername = function() {
		    $http({
	            method : "POST",
	            url : "/getUsernameAndPic",
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then( _successGetUsername, _error );
	    }
	    
	    
	    function _successGetUsername(response) {
	    	if (response.data.username === "") {
	    		$rootScope.isLoggedIn = false;
	    		$rootScope.username = "";
	    		$rootScope.imagePath = "";
	    		$rootScope.type = "";
                $rootScope.userId = -1;
	    		
	    		console.log('Something went wrong with rootScope.getUsername(), empty reply')
	    	}
	    	else {
	    		//console.log(response);
	    		$rootScope.isLoggedIn = true;
	    		$rootScope.username = response.data.username;
	    		$rootScope.imagePath = response.data.imgPath;
	    		$rootScope.type = response.data.type;
                $rootScope.userId = response.data.userId;
	    	}
	    }
	    
	    function _error(response) {
	        console.log(response.statusText);	        
	    }
	    
	    
	    //STARTUP ROUTINE
	    
	    /*initialize log in variables*/
	    $rootScope.isLoggedIn = false;
	    $rootScope.username = "";
	    $rootScope.imagePath = "";

	    /* Try getting valid user from cookie*/
	    var originalPath = $location.path();
	    var accessToken = $cookieStore.get('accessToken');
	    $location.path("/");//go to home (unless we got a token)
	    
	    if (accessToken !== undefined) {
	    	//console.log(accessToken)
	        $rootScope.accessToken = accessToken;
	    	
		    //see if we are logged in. If we are, get username
		    $rootScope.getUsername();
		    $location.path(originalPath);//go where we wanted to go (we got a token!)
	    }
	    else {
	    	//REDIRECT IF I CANT SEE THE PAGE, REDIRECT TO /
	    	var isAuthorized = false;//boolean to redirect to home page if I need to login first
	    	if (isAuthorized)
	    		$location.path(originalPath);
	    }

	    $rootScope.initialized = true;

	});
        
var appControllers = angular.module("app.controllers", [])
	.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

/**
 * infiniteScroll - Directive for ui-select when drop-down has lots of items
 * usage: "infinite-scroll" on ui-select-choices tag
 */
function infiniteScroll($rootScope, $window, $timeout) {
    return {
        link: function(scope, elem, attrs) {
            var checkWhenEnabled, handler, scrollDistance, scrollEnabled;
            $window = angular.element($window);
            elem.css('overflow-y', 'auto');
            elem.css('overflow-x', 'hidden');
            elem.css('height', 'inherit');
            scrollDistance = 0;
            if (attrs.infiniteScrollDistance != null) {
                scope.$watch(attrs.infiniteScrollDistance, function(value) {
                    return (scrollDistance = parseInt(value, 10));
                });
            }
            scrollEnabled = true;
            checkWhenEnabled = false;
            if (attrs.infiniteScrollDisabled != null) {
                scope.$watch(attrs.infiniteScrollDisabled, function(value) {
                    scrollEnabled = !value;
                    if (scrollEnabled && checkWhenEnabled) {
                        checkWhenEnabled = false;
                        return handler();
                    }
                });
            }
            $rootScope.$on('refreshStart', function(){
                elem.animate({ scrollTop: "0" });
            });
            handler = function() {
                var container, elementBottom, remaining, shouldScroll, containerBottom;
                container = $(elem.children()[0]);
                elementBottom = elem.offset().top + elem.height();
                containerBottom = container.offset().top + container.height();
                remaining = containerBottom - elementBottom ;
                shouldScroll = remaining <= elem.height() * scrollDistance;
                if (shouldScroll && scrollEnabled) {
                    if ($rootScope.$$phase) {
                        return scope.$eval(attrs.infiniteScroll);
                    } else {
                        return scope.$apply(attrs.infiniteScroll);
                    }
                } else if (shouldScroll) {
                    return (checkWhenEnabled = true);
                }
            };
            elem.on('scroll', handler);
            scope.$on('$destroy', function() {
                return $window.off('scroll', handler);
            });
            return $timeout((function() {
                if (attrs.infiniteScrollImmediateCheck) {
                    if (scope.$eval(attrs.infiniteScrollImmediateCheck)) {
                        return handler();
                    }
                } else {
                    return handler();
                }
            }), 0);
        }
    }
};

var services = angular.module('app.services', ['ngResource']);

services.factory('UserService', function ($resource) {

    return $resource('rest/user/:action', {},
        {
            authenticate: {
                method: 'POST',
                params: {'action': 'authenticate'},
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        }
    );
});