'use strict';
app.controller('employeeController', ['$route',
		'$scope',
		'$location',
		'employeeservice',
		function($route,$scope, $location, employeeservice){				
				var user = employeeservice.getEmployees();
				user.then(function(msg){					
					if (msg.data.success == true) {
						$scope.employees = msg.data.employees;
						console.log(msg);
					} else {
						$location.path('/');
					}
				}),
				$scope.delete = function(employee){
				var del = employeeservice.deleteemployees(employee);
				del.then(function(msg){					
					if (msg.data.success == true) {
						$scope.employees = msg.data.employees;
						$route.reload('/employee');
					} 
				})
			},		
				$scope.update = function(employee){
				var update = employeeservice.updateemployees(employee);
				update.then(function(msg){
				$scope.up = false;
				$scope.emp = false;
					if (msg.data.success == true) {
						$scope.employee = msg.data.employee;
						$scope.up = true;
						$location.path('/employee');
					} 
				})
			},
			
				$scope.updateit = function(employee){
				var updateit = employeeservice.updateemployee(employee);
				updateit.then(function(msg){
					if(msg.data.success == true){
						$scope.up =false;
						$route.reload('/employee');
					}
				})
			},
			$scope.cancel = function(){
				$route.reload('/employee');
				
			},
			$scope.create = false;
			$scope.add = function(){
				$scope.create = true;
				$scope.up = false;
				$scope.emp = false;
				
			},
			
			
				$scope.save = function(creat){
				var create = employeeservice.create(creat);	
				create.then(function(msg){
					if(msg.data.success == true){
						$scope.up =false;
						$route.reload('/employee');
					}
				})
				
				}
				


		}]);