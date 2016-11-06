define(['appAuthentification', 'cssLoader', 'restRequester'],
    function(appAuthentification, cssLoader, restRequester)
    {
        // console.log(appRoot);

        appAuthentification.controller('registerUserController', registerUserController);

        registerUserController.$inject = ['cssLoader', 'restRequester','$location'];


        function registerUserController(cssLoader, restRequester,$location)
        {
            console.log("registerUserController called");

            // viewModel Object : controller is refered to as registerUser
            var vm = this;

            // ************ interface
            vm.message = "welcome to the register page";

            //vm.userCredentials = {username : 'user',password : 'user'};

            vm.register = register;


            // ********* Implementation


            function register()
            {

            }




            // view specific css and js
            cssLoader.loadDefaults();
        }



    });
