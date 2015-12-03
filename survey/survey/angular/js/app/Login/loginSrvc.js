'use strict';
app.factory('loginService', function($http){
	return{
		login: function(UserName,Password){
			var requestJSON = {"username": UserName, "password":Password};
			var $promise=$http.post("http://localhost:8000/login",requestJSON); //send login data to login service
			return $promise;
			
		},
	logout: function(){
				var $promise=$http.get("http://localhost:9090/webapp/page1/logout.php"); //send login data to login service
				return $promise;	
			}
		};
		
		
    });