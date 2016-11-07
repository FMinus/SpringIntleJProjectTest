define(['appUserAdmin', 'cssLoader', 'restRequester','User','cookieUtils'],
    function(appUserAdmin, cssLoader,restRequester,User,cookieUtils)

    {
        appUserAdmin.controller('listUsersController', listUsersController);

        listUsersController.$inject = ['cssLoader', 'restRequester','User','$rootScope','cookieUtils',"$log"];

        function listUsersController(cssLoader, restRequester,User,$rootScope,cookieUtils,$log)
        {
            // viewModel Object : controller is refered to as pageUsers
            var vm = this;

            //$log.warn(cookieUtils);
            //$log.warn("rootScope : "+$rootScope.token);

            vm.message = "welcome to List Users page : your token is = ";
            vm.listUsers = [];
            vm.pageCourante = 0;
            vm.pageSize = 3;
            vm.pages = [];

            //functions
            vm.getToPage = getToPage;
            vm.recherche = recherche;



            //implementation
            function getToPage(page)
            {
                vm.pageCourante = page;
                vm.recherche();

            }

            function recherche()
            {
                restRequester.getRequest("/allUsers",$rootScope.token).then(
                    function(data)
                    {
                        console.log("returned "+data);
                        vm.listUsers = data;
                    },
                    function(data)
                    {
                        console.log("failed");
                    });
            }

            console.log("token in the controller "+cookieUtils.getCookie());
            //vm.recherche();


            var ayoub = new User("minus","password","ayoub","lastname","mail@gmail.com",true,new Date(),"avatar",[{"name":"user"},{"name":"admin"}]);
            cssLoader.loadDefaults();
        }



    });
