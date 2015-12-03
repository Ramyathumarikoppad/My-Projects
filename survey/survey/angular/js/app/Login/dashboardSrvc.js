'use strict';

app.factory('dashboardService', function($http){

	return{
		getEmployees: function(){
			var $promise=$http.get("http://localhost:9090/webapp/page1/dashboard.php"); //send login data to login service
			return $promise;
		}
	}
		
});