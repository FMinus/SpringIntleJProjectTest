define(['app','MainFactory','restRequester','cssInjector','appConstants'],function(app,MainFactory,restRequester,cssInjector,appConstants)
{
	app.controller('MainCtrl',MainCtrl);

	MainCtrl.$inject = ['$scope','MainFactory','restRequester','cssInjector','appConstants'];

	function MainCtrl($scope,MainFactory,restRequester,cssInjector,appConstants)
	{
		console.log("MainCtrl called");
		var vm = this;
		vm.message = MainFactory.hello + ' At '+appConstants.url+':'+appConstants.port;
		
		cssInjector.add("/css/bootstrap-3.3.6-dist/css/bootstrap.min.css");
	};

	
});

