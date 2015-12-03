'use strict';
app.controller('DashBoardController', [
		'$scope',
		'$location',
		'dashboardService',
		function($scope, $location, dashboardService) {
				
				var user = dashboardService.getEmployees();
				user.then(function(msg){
					console.log(msg);
					
					if (msg.data.success == true) {
						$scope.employees = msg.data.employees;
					} else {
						$location.path('/');
					}
					
				});
		}]);