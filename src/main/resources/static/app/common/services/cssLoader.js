define([ 'app' ,'cssInjector'], function(app,cssInjector) 
{
	app.factory('cssLoader', cssLoader);
	
	cssLoader.$inject = ['cssInjector'];
	
	function cssLoader(cssInjector) 
	{
		
		//Interface
		var service = {
				loadBootstrap:loadBootstrap,
				loadJQuery:loadJQuery,
				loadJQueryUI:loadJQueryUI,
				loadPureCss:loadPureCss,
				loadMyStyle:loadMyStyle,
				loadDefaults:loadDefaults,
				loadCustomCss:loadCustomCss
			
		}

		return service;
		
		
		//Implementation
		
		function loadBootstrap ()
		{
			cssInjector.add("/css/bootstrap-3.3.6-dist/css/bootstrap.min.css");
			//cssInjector.add("/css/bootstrap-3.3.6-dist/js/bootstrap.min.js");
		}
		
		function loadJQuery ()
		{
			cssInjector.add("/js/jquery-3.1.0.min.js");
		}
		
		function loadJQueryUI ()
		{
			cssInjector.add("/js/jquery-3.1.0.min.js");
			cssInjector.add("/js/jquery-ui-1.11.4/jquery-ui.theme.min.css");
			cssInjector.add("/js/jquery-ui-1.11.4/jquery-ui.min.js");
		}
		
		function loadPureCss ()
		{
			cssInjector.add("/css/pure-min.css");
		}
		
		function loadDefaults ()
		{
			cssInjector.add("/css/mystyle.css");
			cssInjector.add("/css/pure-min.css");
			cssInjector.add("/css/bootstrap-3.3.6-dist/css/bootstrap.min.css");
			//cssInjector.add("/css/bootstrap-3.3.6-dist/js/bootstrap.min.js");
		}
		
		function loadMyStyle()
		{
			cssInjector.add("/css/mystyle.css");
		}
		
		function loadCustomCss(pathTofile)
		{
			cssInjector.add(pathTofile);
		}
	}
	

});