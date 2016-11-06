define([ 'app' ], function(app)
{
	app.controller('headerController', headerController);

	headerController.$inject = ['$log'];

	function headerController($log)
	{
		var vm = this;
		vm.message = "Header";
		//$scope.message = "Header";

		//cssLoader.loadDefaults();

		//console.log($controller);

		$log.info("test");
	}
});
