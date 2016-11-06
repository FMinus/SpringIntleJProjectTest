define(['app'], function(app)
{
	app.factory('cookieUtils', cookieUtils);

	cookieUtils.$inject = ['$cookies'];

	function cookieUtils($cookies)
	{
		

		// *****************interface
		var service =
		{
			getCookie : getCookie,
			setCookie : setCookie,
			removeCookie: removeCookie	
		}

		return service;

		var cookie = {};

		// ***************implementation
		function getCookie()
		{
			cookie = $cookies.get('currentUser');
            return cookie;
		}

		function setCookie(token)
		{
			 $cookies.put('currentUser',token);
		}
		
		function removeCookie()
		{
			$cookies.remove("currentUser");
		}
	}

});
