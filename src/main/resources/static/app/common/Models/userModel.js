define(['app'],function(app)
{
    app.factory('User',UserModel);

    function UserModel()
    {

       //implementation
        function User(username ,password ,firstname ,lastname ,email ,enabled ,lastPasswordResetDate ,avatar ,authorities) {
        
            this.username = username;
            this.password = password;
            this.firstname= firstname;
            this.lastname= lastname;
            this.email= email;
            this.enabled= enabled;
            this.lastPasswordResetDate = lastPasswordResetDate;
            this.avatar = avatar;
            this.authorities = authorities;

        }



        // Define the "instance" methods using the prototype
        // and standard prototypal inheritance.
        
        User.prototype = {
        
            getUsername : function(){
                return (this.username);
            },
            getPassword : function(){
                return (this.password);
            },
            getFirstname : function(){
                return this.firstname;
            },
            getLastname : function(){
                return this.lastname;
            },
            getEmail: function(){
                return this.email;
            },
            getEnabled : function(){
                return this.enabled;
            },
            getLastPasswordResetDate : function(){
                return this.lastPasswordResetDate;
            },
            getAvatar : function(){
                return this.avatar;
            },
            getAuthorities : function(){
                return this.authorities;
            },
            
        };
        

        // Define the "class" / "static" methods. These are
        // utility methods on the class itself; they do not
        // have access to the "this" reference.
        User.createFromUsernamePassword = function(data)
        {
            var parts = data.split(":");

            return new User(parts[0],parts[1]);
        };
    
        // Return constructor - this is what defines the actual
        // injectable in the DI framework.
        return User;

    };

});