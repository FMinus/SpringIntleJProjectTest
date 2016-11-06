define(['appAuthentification', 'cssLoader', 'angularAMD', 'restRequester','cookieUtils','User'],
		function(appAuthentification, cssLoader, angularAMD, appConstants,
				restRequester,cookieUtils,User)
		{
			// console.log(appRoot);

			appAuthentification.controller('loginController', loginController);

			loginController.$inject = ['cssLoader', 'restRequester','cookieUtils','$location','User'];

			// angularAMD.bootstrap(appRoot.appAuthentification);

			function loginController(cssLoader, restRequester,cookieUtils,$location,User)
			{
				var ayoub = new User("minus","password","ayoub","lastname","mail@gmail.com",true,new Date(),"avatar",[{"name":"user"},{"name":"admin"}]);
				//console.log(ayoub.getAuthorities());

				// viewModel Object : controller is refered to as login
				var vm = this;

				// ************ interface
				vm.message = "welcome to login page";
				vm.userCredentials = {username : 'user',password : 'user'};
					
				vm.login = login;
				vm.token = "";

				// ********* Implementation


				function login()
				{
					restRequester.postRequest("/auth","" ,vm.userCredentials,true).then(
							function(data)
							{

								vm.token = data.data.token;

								console.log("path "+$location.url());
								//console.log(vm.token);

								$location.path('/back');

								// $scope.getUserInformation();
								//$scope.loggedIn = true;
							}, function(data)
							{
								console.log("failed");
							});
					// console.log($scope.userInfo);
				}

				// console.log(appConstants.url);
				
				
				// view specific css and js
				cssLoader.loadDefaults();
			}

			

		});
