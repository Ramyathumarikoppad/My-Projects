'use strict';
app.factory('employeeservice', function($http){
	return{
		getEmployees: function(){
			var $promise=$http.get("http://localhost:9090/webapp/page1/employee.php"); //send login data to login service
			return $promise;
		},
		deleteemployees: function(employee){
			var $promise=$http.get("http://localhost:9090/webapp/page1/delete.php?id="+employee.id); //send login data to login service
			return $promise;
		},
		updateemployees: function(employee){
			var $promise=$http.get("http://localhost:9090/webapp/page1/update.php?id="+employee.id); //send login data to login service
			return $promise;
		},
		updateemployee: function(employee){
			var $promise=$http.get("http://localhost:9090/webapp/page1/updateit.php?id="+employee.id+"&firstname="+employee.firstname+"&lastname="+employee.lastname+"&mobile="+employee.mobile+"&username="+employee.username); //send login data to login service
			return $promise;
		},
		create: function(creat){
			var $promise=$http.get("http://localhost:9090/webapp/page1/create.php?firstname="+creat.firstname+"&lastname="+creat.lastname+"&mobile="+creat.mobile+"&username="+creat.username); //send login data to login service
			return $promise;
		}
	}
});