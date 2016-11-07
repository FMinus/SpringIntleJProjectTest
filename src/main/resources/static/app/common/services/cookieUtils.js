define(['app'], function(app)
{
	app.factory('cookieUtils', cookieUtils);

	cookieUtils.$inject = ['$cookieStore'];

	function cookieUtils($cookieStore)
	{
		

		// *****************interface
		var service =
		{
			getCookie : getCookie,
			setCookie : setCookie,
			removeCookie: removeCookie	
		}

		return service;

		//var cookie = {};

		// ***************implementation
		function getCookie()
		{
			return $cookieStore.get('currentUser');
		}

		function setCookie(token)
		{
			$cookieStore.put('currentUser',token);
		}
		
		function removeCookie()
		{
			$cookieStore.remove("currentUser");
		}
	}

});
