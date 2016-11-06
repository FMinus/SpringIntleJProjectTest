define(['app'],function(app)
{
      app.factory('MainFactory',MainFactory);
      
      function MainFactory()
      {
            return {
                  hello: 'hello World'
            };

      };
      
});