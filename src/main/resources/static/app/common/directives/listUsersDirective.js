define(['appUserAdmin'],
    function(appUserAdmin)
    {
        appUserAdmin.directive('listUsers', listUsers);

        //listUsersController.$inject = ['User'];

        function listUsers()
        {
            var directive =
            {
                restrict : 'E',
                transclude: true,
                templateUrl: '/app/common/directives/usersList.html'
            }

            return directive;

        }



    });
