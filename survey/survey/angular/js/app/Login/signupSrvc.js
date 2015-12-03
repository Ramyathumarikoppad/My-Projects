'use strict';
app.factory('signupservice', function($http){
	return{
		signup: function(signup){
			var $promise=$http.get("http://localhost:9090/webapp/page1/signup.php?FirstName="+signup.FirstName+"&LastName="+signup.LastName+"&Mobile="+signup.Mobile+"&UserName="+signup.UserName+"&Password="+signup.Password); //send login data to login service
			return $promise;
		}
		}
    });