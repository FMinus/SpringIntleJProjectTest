define(['angular','angularAMD','ngRoute','ngCookies'],function(angular,angularAMD,ngCookies)
{	 
	var app = angular.module("webbapp",['ngRoute','ngCookies']);

    //app
	app.config(routeConfig);
	
	routeConfig.inject = ['$routeProvider'];
	
	function routeConfig($routeProvider)
	{
      
		//$locationProvider.html5Mode(true).hashPrefix('*');
        $routeProvider
            .when('/back', angularAMD.route( {
                title : 'Add User',
                controller : 'MainCtrl',
                controllerAs: 'vm',
                templateUrl: '/app/module/authentification/partials/hello.html',
                controllerUrl: '/app/module/authentification/controllers/MainCtrl.js'
            }))
            .when('/',angularAMD.route(
            {
            	title : 'Login',
                controller : 'loginController',
                controllerAs: 'login',
                templateUrl: '/app/module/authentification/partials/login.html',
                controllerUrl: '/app/module/authentification/controllers/loginController.js',

            }))
            .when('/register',angularAMD.route(
            {
            	title : 'Register',
                controller : 'registerUserController',
                controllerAs: 'registerUser',
                templateUrl: '/app/module/authentification/partials/registerUser.html',
                controllerUrl: '/app/module/authentification/controllers/registerUserController.js',

            }))
            .otherwise({
                redirectTo : '/error'
            });
    }

    //console.log(app);


	return angularAMD.bootstrap(app);

});


