require.config({

	paths: 
	{
		'angular': '../js/angular/angular.min',
		'ngRoute': '../js/angular/angular-route.min',
		'ngAnimate': '../js/angular/angular-animate.min',
		'base64': '../js/angular/angular-base64.min',
		'ngCookies': '../js/angular/angular-cookies.min',
		'angularAMD':'../js/angular/angularAMD.min',
		'cssInjector': '../js/angular/angular-css-injector.min',
		
		//****************** Modules Paths
		'app': 'app',
		'appAuthentification':'module/authentification/authentification',
		
		'appConstants': 'appConstants',
		
		//*******************Common Services
		'MainFactory': 'common/services/mainFactory',		
		'restRequester': 'common/services/restRequester',
		'headerController': 'common/partials/headerController',
		'cssLoader': 'common/services/cssLoader',
		'cookieUtils' : 'common/services/cookieUtils',

		//********************Business models
		'User': 'common/Models/userModel'
		
	},
	waitSeconds: 1,
	shim: 
	{
		//**************************Main Angular Modules
		'angular': { exports: 'angular'},
		'ngRoute':{ deps: ['angular']},
		'angularAMD': { deps: ['angular'] },
		'cssInjector': {deps:['angular']},
		'ngAnimate': {deps:['angular']},
		'base64': {deps:['angular']},
		'ngCookies': {deps:['angular']},
		
		//******************* My Modules Instantiators *******************
		
		//Main Module : route config + controllers/views loading based on route + app configuration
		'app': {deps: ['angular','ngRoute','angularAMD','ngCookies']},
		
		//Authentification Module : responsible for Authentification with the server and storing the token
		'appAuthentification': {deps: ['angular','ngRoute','angularAMD','cssInjector','app']},
		
		//applicatioon constants
		'appConstants' : {deps:['app']},
		
		//********************* My Services **************************
		//test factory
		'MainFactory': {deps:['angular']},
		
		//general purpose http requests handler
		'restRequester': {deps:['angular']},
		
		//dynamic css loader : must make calls in controllers for the approptiate css/scripts 
		'cssLoader': {deps:['angular','cssInjector','app']},
		
		//various cookie utilities 
		'cookieUtils': {deps:['angular','ngCookies']},
		
		
		'headerController': {deps:['angular']},

		//******************** My Models
		'User' : {deps : ['angular','app']}
            
	},
	deps: ['app','headerController']
		
});


         
        
