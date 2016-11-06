define(['app'], function(app)
{
	app.factory('restRequester', restRequester);

	restRequester.$inject = ['$http', '$q'];

	function restRequester($http, $q)
	{
		/*
		 * service that captures the data and stores is and then notifies the
		 * controller that the data has changed or refreshed
		 */

		// interface
		var service =
		{
			result : [],
			getRequest : getRequest,
			postRequest : postRequest,
			createAuthorizationTokenHeader: createAuthorizationTokenHeader
			
		}

		return service;

		// implementation
		function getRequest(url, header)
		{

			// custom Promise
			// Initial Deferred object using $q.defer().
			var def = $q.defer();

			var req =
			{
				method : 'GET',
				url : url,
				contentType : "application/json; charset=utf-8",
				headers : header,
				dataType : "json"
			}

			$http(req).then(function(data)
			{
				// success
				service.result = data;
				def.resolve(data);
			}, function()
			{
				// failure
				def.reject("Request Failed");
			});

			return def.promise;

			/*
			 * the $http.get() is called and when the initial $http callback
			 * returns either .resolve() or .reject() is called on the deferred
			 * instance.
			 * 
			 * When – later on in the future – the HTTP call returns it triggers
			 * the Deferred to fire its continuation callbacks to the success or
			 * failure operations on whoever is listening to the promise on the
			 * promise
			 * 
			 */

		}

		function postRequest(url,header ,data)
		{
			var def = $q.defer();

			var req =
			{
				method : 'POST',
				url : url,
				contentType : "application/json; charset=utf-8",
				headers : header,
				data :  data,
				dataType : "json"
			}

			$http(req).then(function(data)
			{
				// success
				service.result = data;
				def.resolve(data);
			}, function()
			{
				// failure
				def.reject("Request Failed");
			});

			return def.promise;
		}
		
		function createAuthorizationTokenHeader(token)
		{
			if (token) 
				return {"Authorization" : token};					
			else 
				return {};
		}
	}

});
